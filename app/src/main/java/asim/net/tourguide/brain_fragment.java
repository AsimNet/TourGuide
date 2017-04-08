package asim.net.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class brain_fragment extends Fragment {

    public ArrayList<Location> locations = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.list, container, false);
        ListView myListView = (ListView) rootView.findViewById(R.id.list);

        if (this.getArguments() != null){
            locations = this.getArguments().getParcelableArrayList("arraylist");
        }

// get data from the table by the ListAdapter
        ListAdapter customAdapter = new ListAdapter(getActivity(), R.layout.item_list, locations);
        myListView.setAdapter(customAdapter);


        return rootView;
    }


}