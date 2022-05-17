package ru.a_party.formulas_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.DemoData
import ru.a_party.Formula
import ru.a_party.formula_screen.FormulaFragment
import ru.a_party.vetfrmdemo.R

const val RAZDEL_ID = "radel.id"

class FormulasListFragment : Fragment() {

    companion object {
        fun newInstance(first: Int) = FormulasListFragment().apply {
            arguments = Bundle().apply {
                putInt(RAZDEL_ID, first)
            }
        }
    }

    private val hAdapter:FormulaListAdapter by lazy{
        FormulaListAdapter(object: FormulaListAdapter.FormulaSelect{
            override fun selectFormula(formula: Formula) {
                requireActivity()
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, FormulaFragment.newInstance(formula))
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

    private lateinit var viewModel: FormulasListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.formulas_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val razdelId = arguments?.getInt(RAZDEL_ID)?:0

        viewModel = ViewModelProvider(this)[FormulasListViewModel::class.java]
        viewModel.razdel = razdelId
        view.findViewById<RecyclerView>(R.id.rvFormulaList).apply{
            adapter=hAdapter
            layoutManager = LinearLayoutManager(context)
            hAdapter.formula_list = viewModel.formulas_list
        }
    }
}