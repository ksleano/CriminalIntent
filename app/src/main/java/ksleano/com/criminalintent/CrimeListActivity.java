package ksleano.com.criminalintent;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by kslea_000 on 2/21/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {

        Log.d(CrimeListActivity.class.getSimpleName(), "called createFragment() in CrimeList" +
                "Activity" );
        return new CrimeListFragment();
    }
}
