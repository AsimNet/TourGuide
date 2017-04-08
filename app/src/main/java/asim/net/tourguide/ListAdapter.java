package asim.net.tourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by asimaltwijry on 4/7/17.
 */

public class ListAdapter extends ArrayAdapter<Location> {

    ArrayList<Location> locationsArray ;
    public ListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
    public ListAdapter(Context context, int resource, ArrayList<Location> items) {
        super(context, resource, items);
        locationsArray = items;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_list, null);
        }

        Location loca = getItem(position);

        TextView title = (TextView) view.findViewById(R.id.historical_title);
        title.setText(getContext().getResources().getString(loca.getTitle()));

        TextView lowerBody = (TextView) view.findViewById(R.id.historical_body);

        if (loca.getMode().equals("Historical")){
            //location is historical, show the lower body
            lowerBody.setText(getContext().getResources().getString(loca.getBody()));
        }else {
            lowerBody.setVisibility(View.GONE);
        }


        ImageView bgImage = (ImageView) view.findViewById(R.id.cell_background);
        bgImage.setImageResource(loca.getImage());

        Button phone = (Button) view.findViewById(R.id.cell_call);
        if (loca.getMode().equals("Restaurants")){
            //location is a restaurant!.
            phone.setText(loca.getPhoneNumber());
        }else {
            phone.setVisibility(View.GONE);
        }


        return view;
    }

    @Override
    public int getCount() {
        return locationsArray.size();
    }
}