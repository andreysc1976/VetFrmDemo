package ru.a_party.razdel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.a_party.formulas_list.FormulasListFragment
import ru.a_party.vetfrmdemo.R

class RazdelFragment : Fragment() {

    companion object {
        fun newInstance() = RazdelFragment()
    }

    private val rAdapter:RazdelApater by lazy{
        RazdelApater(object: RazdelApater.OnSelectRazdel {
            override fun onSelectRazdel(razdel: Pair<Int, String>) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, FormulasListFragment.newInstance(razdel.first))
                    .addToBackStack(null)
                    .commit()
            }

        })
    }

    private lateinit var viewModel: RazdelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.razdel_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RazdelViewModel::class.java)
        view.findViewById<RecyclerView>(R.id.rvRazdel).apply {
            this.layoutManager =  LinearLayoutManager(context)
            this.adapter = rAdapter
        }


    }
}