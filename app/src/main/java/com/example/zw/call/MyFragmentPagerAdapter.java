package com.example.zw.call;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by zw on 2016/8/31.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private AddFragment addFragment=null;
    private CallFragment callFragment=null;
    private ListFragment listFragment=null;
    private SearchFragment searchFragment=null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        addFragment=new AddFragment();
        searchFragment=new SearchFragment();
        listFragment=new ListFragment();
        callFragment=new CallFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
   switch (position){
       case MainActivity.PAGE_ONE:
           fragment=callFragment;
           break;
       case MainActivity.PAGE_TWO:
           fragment=listFragment;
           break;
       case MainActivity.PAGE_THREE:
           fragment=searchFragment;
           break;
       case MainActivity.PAGE_FOUR:
           fragment=addFragment;
           break;
   }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
