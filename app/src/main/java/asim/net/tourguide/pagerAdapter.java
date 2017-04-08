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

    public ArrayList<Location> loadHotels() {
        //remove old locations.
        ArrayList<Location> Locations = new ArrayList<>();


        Locations.add(new Location(R.string.Movenpick, 0, R.drawable.mhr_logo, R.string.mobile1,"Restaurants"));
        Locations.add(new Location(R.string.tulipInn, 0, R.drawable.tulipinn, R.string.mobile2,"Restaurants"));


        return Locations;
    }

    public ArrayList<Location> loadRestuarant() {
        //remove old locations.
        ArrayList<Location> Locations = new ArrayList<Location>();

        Locations.add(new Location(R.string.Albaik, 0, R.drawable.albaik, R.string.mobile3,"Restaurants"));
        Locations.add(new Location(R.string.Fridays, 0, R.drawable.fridays, R.string.mobile4,"Restaurants"));

        return Locations;

    }

    public ArrayList<Location> loadHistoricalSites() {
        //remove old locations.
        ArrayList<Location> Locations = new ArrayList<Location>();

        Locations.add(new Location(R.string.buraydahTower,R.string.buraydahBody, R.drawable.buraydahtower, 0,"Historical"));

        return Locations;

    }

    public ArrayList<Location> loadDunes() {
        //remove old locations.
        ArrayList<Location> Locations = new ArrayList<Location>();

        Locations.add(new Location(R.string.Dunes,R.string.DunesBody, R.drawable.dunes, 0, "Historical"));

        return Locations;

    }
}