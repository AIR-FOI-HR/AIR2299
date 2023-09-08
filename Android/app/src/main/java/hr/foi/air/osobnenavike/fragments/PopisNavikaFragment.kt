package hr.foi.air.osobnenavike.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.inline.InlineContentView.SurfaceControlCallback
import androidx.lifecycle.ViewModelProvider
import hr.foi.air.osobnenavike.R
import hr.foi.air.osobnenavike.data.Navike
import hr.foi.air.osobnenavike.data.NavikeViewModel


class PopisNavikaFragment : Fragment() {

    private lateinit var mNavikeViewModel: NavikeViewModel
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_popis_navika, container, false)

        mNavikeViewModel = ViewModelProvider( this).get(NavikeViewModel::class.java)

        view.findViewById<Button>(R.id.btnDodaj).setOnClickListener{
            dodajNaviku()
        }
        return view
    }

    private fun dodajNaviku() {

        val nazivNavike = editText1.findViewById<EditText>(R.id.editTextNazivNavike).text.toString()
        val tipNavike = editText2.findViewById<EditText>(R.id.editTextTipNavike).text.toString()

        if (  provjeraUnosa(nazivNavike, tipNavike)){
            val navika = Navike( 0, nazivNavike, tipNavike)
            mNavikeViewModel.dodajNaviku(navika)
            Toast.makeText(requireContext(), "Uspješno spremljeni", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(requireContext(), "Potrebno je ispuniti sva polja", Toast.LENGTH_LONG).show()
        }
    }

    private fun provjeraUnosa(nazivNavike: String, tipNavike: String): Boolean{
        return !(TextUtils.isEmpty(nazivNavike)&& TextUtils.isEmpty(tipNavike))
    }
}