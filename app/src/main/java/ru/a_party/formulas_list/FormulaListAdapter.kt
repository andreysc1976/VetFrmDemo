package ru.a_party.formulas_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.DemoData
import ru.a_party.Formula
import ru.a_party.vetfrmdemo.R

class FormulaListAdapter(val formulaSelect:FormulaSelect): RecyclerView.Adapter<FormulaListAdapter.FormulaHolder>() {
    var formula_list:List<Formula> =listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value)
        {
            field = value
            notifyDataSetChanged()
        }

    class FormulaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fButton = itemView.findViewById<Button>(R.id.fButton)

        fun bind(formula: Formula,click:(formula: Formula) -> Unit) {
            fButton.text = formula.name
            fButton.setOnClickListener {
                click(formula)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulaHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.formula_list_holder, parent, false)
        return FormulaHolder(itemView)
    }

    override fun onBindViewHolder(holder: FormulaHolder, position: Int) {
        holder.bind(formula_list[position]){
            formulaSelect.selectFormula(it)
        }
    }

    override fun getItemCount(): Int {
        return formula_list.size
    }

    interface FormulaSelect{
      fun selectFormula(formula: Formula)
    }
}