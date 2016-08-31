package com.example.zw.call;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    private RadioButton call,list,add,search;
    private RadioGroup rg_tab_bar;
    private ViewPager vpager;
    private MyFragmentPagerAdapter mAdapter;
    public static final int PAGE_ONE=0;
    public static  final int PAGE_TWO=1;
    public static  final int PAGE_THREE=2;
    public static  final int PAGE_FOUR=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        call.setChecked(true);
    }

    private void bindViews() {
     call=(RadioButton)findViewById(R.id.rb_call);
        list=(RadioButton)findViewById(R.id.rb_contactlist);
        add=(RadioButton)findViewById(R.id.rb_add);
        search=(RadioButton)findViewById(R.id.rb_search);
        rg_tab_bar=(RadioGroup)findViewById(R.id.rg_tab_bar);
        vpager=(ViewPager)findViewById(R.id.vpager);
       rg_tab_bar.setOnCheckedChangeListener(this);

        vpager=(ViewPager)findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_call:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_contactlist:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_search:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_add:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
       //state的状态有三个，0表示什么都没做，1表示正在滑动，2表示滑动完毕
        if(state==2){
            switch (vpager.getCurrentItem()){
                case PAGE_ONE:
                    call.setChecked(true);
                    break;
                case PAGE_TWO:
                    list.setChecked(true);
                    break;
                case PAGE_THREE:
                    search.setChecked(true);
                    break;
                case PAGE_FOUR:
                    add.setChecked(true);
                    break;
            }
        }
    }
}
