package ksleano.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by kslea_000 on 2/21/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
