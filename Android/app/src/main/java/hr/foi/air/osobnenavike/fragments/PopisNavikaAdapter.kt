package hr.foi.air.osobnenavike.fragments

import android.graphics.Path.Direction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.osobnenavike.data.Navike
import hr.foi.air.osobnenavike.R
import hr.foi.air.osobnenavike.fragments.PopisNavikaFragment

class PopisNavikaAdapter: RecyclerView.Adapter<PopisNavikaAdapter.MyViewHolder>() {

    private var navikeLista= emptyList<Navike>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=navikeLista[position]
        holder.itemView.findViewById<TextView>(R.id.textViewId).text=currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewNaziv).text=currentItem.nazivNavike
        holder.itemView.findViewById<TextView>(R.id.textViewTip).text=currentItem.tipNavike

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener{
        
        }
    }

    override fun getItemCount(): Int {
        return navikeLista.size
    }
    fun setData(navike: List<Navike>){
        this.navikeLista=navike
        notifyDataSetChanged()
    }
}