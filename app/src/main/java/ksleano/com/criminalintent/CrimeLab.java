package ksleano.com.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by kslea_000 on 2/21/2018. This java class is a singleton designed to hold lists of crimes
 * Only one instance of CrimeLab will be created.
 */

public class CrimeLab {
    // s prefix for static class variables
    private static CrimeLab sCrimeLab;

    // using list to store crimes. Temporary fix since we will be using sql for data storage
    private List<Crime> mCrimeList;

    // private constructor for singletons
    private CrimeLab(Context context){
        mCrimeList = new ArrayList<>();
    }

    // the get() method will call the private constructor if the instance doesn't exist
    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public Crime getCrime(UUID uniqueId){
        for(Crime crime: mCrimeList){
            if(crime.getId().equals(uniqueId)){
                return crime;
            }
        }
        return null;
    }

}
