package ru.a_party.formula_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.Formula
import ru.a_party.vetfrmdemo.R

const val FID = "formula.id"

class FormulaFragment : Fragment() {

    companion object {
        fun newInstance(formula: Formula) = FormulaFragment().apply{
            arguments = Bundle().apply {
                putInt(FID, formula.id)
            }
        }
    }

    private lateinit var viewModel: FormulaViewModel

    private val resultAdapter:ResultAdapter by lazy{
        ResultAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.formula_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormulaViewModel::class.java)

        val fid = arguments?.getInt(FID)?:0
        viewModel.setFormulaID(fid)

        view.findViewById<RecyclerView>(R.id.rvParams).apply {
            layoutManager = LinearLayoutManager(context)
            val adap = ParamsAdapter()
            adapter = adap
            adap.params = viewModel.params_list
        }

        view.findViewById<RecyclerView>(R.id.rvResults).apply{
            layoutManager = LinearLayoutManager(context)
            adapter = resultAdapter
        }

        view.findViewById<Button>(R.id.btnCalc).setOnClickListener {
            resultAdapter.clearResult()


            resultAdapter.addResult(Pair("Литры","13"))

            if ((0..2).random()==1) {
                resultAdapter.addResult(Pair("Граммы", "2"))
            }
            if ((0..2).random()==1) {
                resultAdapter.addResult(Pair("Километры", "4"))
            }
            if ((0..2).random()==1) {
                resultAdapter.addResult(Pair("Световых лет", "1"))
            }


        }

    }
}