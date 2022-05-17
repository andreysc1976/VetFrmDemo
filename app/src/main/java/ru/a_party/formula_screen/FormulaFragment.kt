package ru.a_party.formula_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.a_party.DemoData
import ru.a_party.Formula
import ru.a_party.formulas_list.RAZDEL_ID
import ru.a_party.vetfrmdemo.R

const val FID = "formula.id"

class FormulaFragment : Fragment() {

    companion object {
        fun newInstance(formula: Formula) = FormulaFragment().apply{
            arguments = Bundle().apply {
                putParcelable(FID, formula)
            }
        }
    }

    private lateinit var viewModel: FormulaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.formula_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormulaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}