package ru.a_party

import kotlinx.parcelize.Parcelize
import java.util.*

class DemoData {
    val razdels = listOf(Pair(1,"Разел 1"),Pair(2,"Раздел 2"),Pair(3,"Разел 3"))
    //,Pair(4,"Раздел 4"),Pair(5,"Раздел 4"))

    val forumlas_list = listOf(
        Formula(1,"Формула 1",1),
        Formula(2,"Формула 2",1),
        Formula(3,"Формула 3",1),
        Formula(4,"Формула 4",2),
        Formula(5,"Формула 5",2)
    )

    fun createDemoData(){
        for (fr in forumlas_list){

            for (i in 1..(1..3).random()){
                fr.params.add(Formula_param("Входной параметр формулы №-"+i.toString()))
            }
        }
    }


    data class Formula_param(val name:String)

}