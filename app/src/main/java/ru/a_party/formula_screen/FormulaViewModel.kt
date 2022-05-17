package ru.a_party.formula_screen

import androidx.lifecycle.ViewModel
import ru.a_party.App
import ru.a_party.DemoData

class FormulaViewModel : ViewModel() {
    private var fid:Int=0
    var params_list:MutableList<DemoData.Formula_param> = mutableListOf()

    fun setFormulaID(fid: Int) {
        this.fid =fid
        for (fm in App.demoData.forumlas_list){
            if (fm.id==fid){
                params_list = fm.params
            }
        }
    }

}