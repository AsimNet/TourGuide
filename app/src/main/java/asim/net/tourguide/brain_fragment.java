package asim.net.tourguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class brain_fragment extends Fragment {

    public ArrayList<location> locations = new ArrayList<>();

    public brain_fragment() {
        super();


    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public Object getEnterTransition() {

        return super.getEnterTransition();
    }

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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
