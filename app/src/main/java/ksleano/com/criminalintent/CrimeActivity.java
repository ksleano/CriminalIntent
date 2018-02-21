package ksleano.com.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        // use a FragmentManager to manage fragments. what a useless comment
        FragmentManager fragmentManager = getSupportFragmentManager();
        // with the fragment manager, find and use the id of the xml that will contain the fragment
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        // check if a fragment exists
        if(fragment == null){
            // begin the transaction by
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();

        }


    }

}


