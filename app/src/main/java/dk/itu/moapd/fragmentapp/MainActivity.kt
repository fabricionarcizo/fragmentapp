package dk.itu.moapd.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager
            .findFragmentById(R.id.fragment)
        if (fragment == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, FirstFragment())
                .commit()
    }

    fun selectFragment(view: View) {
        val fragment = when (view.id) {
            R.id.first_button -> FirstFragment()
            R.id.second_button -> SecondFragment()
            else -> ThirdFragment()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, fragment)
            .setTransition(FragmentTransaction
                .TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.fragment)
        supportFragmentManager
            .putFragment(outState, "fragment", fragment!!)
        super.onSaveInstanceState(outState)
    }
}
