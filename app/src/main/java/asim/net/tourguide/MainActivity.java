package asim.net.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by asimaltwijry on 4/6/17.
 */



public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }



}