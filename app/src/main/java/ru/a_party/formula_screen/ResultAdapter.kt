package ru.a_party.formula_screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.vetfrmdemo.R

class ResultAdapter: RecyclerView.Adapter<ResultAdapter.ResultHolder>() {

    private var resultList:MutableList<Pair<String,String>> = mutableListOf()

    fun addResult(result:Pair<String,String>)
    {
        resultList.add(result)
        notifyItemInserted(resultList.size-1)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearResult(){
        resultList.clear()
        notifyDataSetChanged()
    }


    class ResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rCaption = itemView.findViewById<TextView>(R.id.tvResultCaption)
        private val rValue = itemView.findViewById<TextView>(R.id.tvResultValue)

        fun bind(result: Pair<String, String>) {
            rCaption.text = result.first
            rValue.text = result.second
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.result_holder, parent, false)
        return ResultHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        holder.bind(resultList[position])
    }

    override fun getItemCount(): Int {
        return  resultList.size
    }
}