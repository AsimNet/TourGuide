package asim.net.tourguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by asimaltwijry on 4/6/17.
 */

public class pagerAdapter extends FragmentStatePagerAdapter {
    private final FragmentManager fm;
    private Context context;


    public pagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.fm = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Log.v("Hey", position + "");
        Bundle bundle = new Bundle();
        brain_fragment fragment = new brain_fragment();

        if (position == 0) {
            bundle.putParcelableArrayList("arraylist", loadRestuarant());
        } else if (position == 1) {
            bundle.putParcelableArrayList("arraylist", loadHotels());
        } else if (position == 2) {
            bundle.putParcelableArrayList("arraylist", loadHistoricalSites());

        }else if (position == 3){
            bundle.putParcelableArrayList("arraylist", loadDunes());
        }



        fragment.setArguments(bundle);
        return fragment;

}

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.resturants);
            case 1:
                return context.getResources().getString(R.string.hotels);
            case 2:
                return context.getResources().getString(R.string.historical_sites);
            case 3:
                return context.getResources().getString(R.string.dunes);
            default:
                return null;
        }
    }

    public ArrayList<location> loadHotels() {
        //remove old locations.
        ArrayList<location> locations = new ArrayList<>();


        locations.add(new location(R.string.Movenpick, R.mipmap.mhr, "0545847771"));
        locations.add(new location(R.string.tulipInn, R.mipmap.tulipinn, "0545847771"));


        return locations;
    }

    public ArrayList<location> loadRestuarant() {
        //remove old locations.
        ArrayList<location> locations = new ArrayList<location>();

        locations.add(new location(R.string.Albaik, R.mipmap.albaik, "0598273344"));
        locations.add(new location(R.string.Fridays, R.mipmap.fridays, "05498271920"));

        return locations;

    }

    public ArrayList<location> loadHistoricalSites() {
        //remove old locations.
        ArrayList<location> locations = new ArrayList<location>();

        locations.add(new location(R.string.buraydahTower,R.string.buraydahBody, R.mipmap.buraydahtower));

        return locations;

    }

    public ArrayList<location> loadDunes() {
        //remove old locations.
        ArrayList<location> locations = new ArrayList<location>();

        locations.add(new location(R.string.Dunes,R.string.DunesBody, R.mipmap.dunes));

        return locations;

    }
}
