package ru.a_party.formulas_list

import androidx.lifecycle.ViewModel
import ru.a_party.App.Companion.demoData
import ru.a_party.DemoData
import ru.a_party.Formula

class FormulasListViewModel : ViewModel() {
    var razdel:Int?=null
        set(value){
            field = value
            formulas_list.clear()
            for (fm in demoData.forumlas_list){
                if (fm.razdel == razdel){
                    formulas_list.add(fm)
                }
            }
        }

    val formulas_list:MutableList<Formula> = mutableListOf()
}