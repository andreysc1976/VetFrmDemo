package ru.a_party

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


class Formula(val id: Int,val name: String,val razdel:Int) {
    var params:MutableList<DemoData.Formula_param> = mutableListOf()
}