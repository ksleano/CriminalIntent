package ksleano.com.criminalintent;


import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {

    // implements the abstract method

    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }

}


