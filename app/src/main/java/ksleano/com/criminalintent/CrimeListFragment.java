package ksleano.com.criminalintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kslea_000 on 2/21/2018.
 * CrimeListFragment will use recycler view to display crimes generated from the CrimeLab. This will
 * also serve as the Adapter for the model and the view using an inner class CrimeAdapter
 * RecycleView enables us to just use what we need to display at a given screen.
 *
 * The way is works is that a(n) RV creates ViewHolders that show the items. An adapter sits
 * between the RV and the data set that the RV needs to display
 *
 * To use RV add it in the dependency. Sounds like something gradle should handle
 *
 * Create a(n) RV on the CrimeListFragment's view first
 *
 * The last step involves connecting the ADAPTER to the RECYCLERVIEW
 */

public class CrimeListFragment extends Fragment {
    // with the fragment_crime_list.xml set up as a recycle view we can start using it
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // inflate the view with the fragment_crime_list.xml using the View class
        View view = inflater.inflate(R.layout.fragment_crime_list, container,false);

        // link the member variable to the fragment_crime.xml which has the id of crime_recycler_view
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);

        /* RV needs a LayoutManager to position items on the screen itself. RV will not work without
           LM doing the formatting. Pass in the fragment to the LM using getActivity()
        */
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // don't forget to call the UI
        updateUI();

        return view;
    }

    // updateUI will connect the adapter to the reycleview
    public void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();

        // pass in the list of crimes from the CrimeLab to the CrimeAdapter Class
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    // INNER CLASSES

    // CrimeListFragment will also utilize using an anonymous class to do the view holding

    private class CrimeHolder extends RecyclerView.ViewHolder {

        /*  in the CrimeHolders constructor we inflate the list_item_crime.xml then pass it to the
            ViewHolder's constructor using super. This is the item INSIDE the RV
        */
        public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime,parent, false));
        }
    }

    // Adapter for the ViewHolder. Extends the Adapter that only takes CrimeHolder Objects
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        // this method is called whenever RV needs a new ViewHolder to display an item
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {

        }

        // the item count depends on the size of the mCrime List
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
