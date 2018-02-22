package ksleano.com.criminalintent;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by kslea_000 on 2/21/2018.
 * code reuse in action. Just implement createFragment().
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        // set the view to the activity_fragment
        setContentView(R.layout.activity_fragment);

        // use a FragmentManager to manage fragments. what a useless comment
        FragmentManager fragmentManager = getSupportFragmentManager();
        // with the fragment manager, find and use the id of the xml that will contain the fragment
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null ){
            // subclasses that will extend SingleFragmentActivity will have to implement create Fragement;
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
            System.out.println("single Activity");
        }

    }
    protected abstract Fragment createFragment();
}

