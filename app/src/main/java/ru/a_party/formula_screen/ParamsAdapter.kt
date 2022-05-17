package ru.a_party.formula_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.DemoData
import ru.a_party.vetfrmdemo.R

class ParamsAdapter: RecyclerView.Adapter<ParamsAdapter.ParamHolder>() {
    var params:MutableList<DemoData.Formula_param> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    set(value){
        field = value
        notifyDataSetChanged()
    }

    class ParamHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCaption = itemView.findViewById<TextView>(R.id.tvResultCaption)

        fun bind(formulaParam: DemoData.Formula_param) {
            tvCaption.text=formulaParam.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParamHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.param_holder, parent, false)
        return ParamHolder(itemView)
    }

    override fun onBindViewHolder(holder: ParamHolder, position: Int) {
        holder.bind(params[position])
    }

    override fun getItemCount(): Int {
        return params.size
    }
}