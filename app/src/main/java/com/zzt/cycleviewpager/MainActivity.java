package com.zzt.cycleviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zzt.library.CycleViewPager;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private CycleViewPager cycleViewPager;
    ArrayList<View> pages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cycleViewPager = (CycleViewPager)findViewById(R.id.pp);
        pages.add(LayoutInflater.from(this).inflate(R.layout.page1, null));
        pages.add(LayoutInflater.from(this).inflate(R.layout.page2, null));
        pages.add(LayoutInflater.from(this).inflate(R.layout.page3, null));

        cycleViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return pages.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                //Toast.makeText(MainActivity.this, "destroyItem:"+position, Toast.LENGTH_SHORT).show();
                ((CycleViewPager) container).removeView(pages.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((CycleViewPager) container).addView(pages.get(position));
                return pages.get(position);
            }
        });
    }

}
