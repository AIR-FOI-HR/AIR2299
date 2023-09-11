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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.osobnenavike.R
import hr.foi.air.osobnenavike.data.Navike
import hr.foi.air.osobnenavike.data.NavikeViewModel


class PopisNavikaFragment : Fragment() {

    private lateinit var mNavikeViewModel: NavikeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_popis_navika, container, false)

        val adapter = PopisNavikaAdapter()
        val recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter= adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())



        mNavikeViewModel = ViewModelProvider( this).get(NavikeViewModel::class.java)
        mNavikeViewModel.listaNavika.observe(viewLifecycleOwner, Observer {user ->
            adapter.setData(user)
        })

        val nazivNavikeEditText = view.findViewById<EditText>(R.id.editTextNazivNavike)
        val tipNavikeEditText = view.findViewById<EditText>(R.id.editTextTipNavike)
        view.findViewById<Button>(R.id.btnDodaj).setOnClickListener{
            val nazivNavike=nazivNavikeEditText.text.toString();
            val tipNavike=tipNavikeEditText.text.toString();
            dodajNaviku(nazivNavike, tipNavike)
        }
        return view
    }

    private fun dodajNaviku(nazivNavike: String, tipNavike: String) {


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