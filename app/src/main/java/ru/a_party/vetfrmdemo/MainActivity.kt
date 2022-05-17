package ru.a_party.vetfrmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.a_party.razdel.RazdelFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, RazdelFragment.newInstance(),"razdel")
            .addToBackStack(null)
            .commit()
    }
}