package ru.a_party.razdel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.App.Companion.demoData
import ru.a_party.vetfrmdemo.R

class RazdelApater(val onSelect:OnSelectRazdel): RecyclerView.Adapter<RazdelApater.RHolder>() {
    class RHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var rButton1 = itemView.findViewById<Button>(R.id.rbutton1)
        private var rButton2 = itemView.findViewById<Button>(R.id.rbutton2)

        fun bind(k1: Pair<Int, String>, k2: Pair<Int, String>?, onSelectK1:(razdel:Pair<Int,String>)->Unit,onSelectK2:(razdel:Pair<Int,String>)->Unit) {
            rButton1.text = k1.second
            rButton1.setOnClickListener {
                onSelectK1(k1)
            }
            rButton2.visibility = View.GONE
            k2?.let{
                rButton2.visibility = View.VISIBLE
                rButton2.text = it.second
                rButton2.setOnClickListener {
                    onSelectK2(k2)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.radel_holder, parent, false)
        return RHolder(itemView)
    }

    override fun onBindViewHolder(holder: RHolder, position: Int) {
        val rposition = position*2
        val k1 = demoData.razdels[rposition]
        var k2:Pair<Int,String>?
        if (demoData.razdels.size>rposition+1) {
            k2 = demoData.razdels[rposition+1]
        } else {
            k2 = null
        }
        holder.bind(k1,k2,{
            onSelect.onSelectRazdel(it)
        },{
            onSelect.onSelectRazdel(it)
        })
    }

    override fun getItemCount(): Int {
        val v1 =  demoData.razdels.size / 2
        val v2 = v1*2
        if (v1 == v2){
            return v1
        } else {
            return v1+1
        }
    }

    interface OnSelectRazdel {
        fun onSelectRazdel(razdel:Pair<Int, String>)
    }


}
