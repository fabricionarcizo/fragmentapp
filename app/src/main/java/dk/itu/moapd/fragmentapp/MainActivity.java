package dk.itu.moapd.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        Fragment fragment =
                fragmentManager.findFragmentById(R.id.fragment);
        if (fragment == null)
            fragmentManager.beginTransaction()
                    .add(R.id.fragment, new FirstFragment())
                    .commit();
    }

    public void selectFragment(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.first_button))
            fragment = new FirstFragment();
        else if (view == findViewById(R.id.second_button))
            fragment = new SecondFragment();
        else
            fragment = new ThirdFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment)
                .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
