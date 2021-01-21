package com.maxprof90.myphonebook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.maxprof90.myphonebook.R;
import com.maxprof90.myphonebook.adapters.ViewPagerAdapter;
import com.maxprof90.myphonebook.fragments.FragmentCall;
import com.maxprof90.myphonebook.fragments.FragmentContact;
import com.maxprof90.myphonebook.fragments.FragmentFavorite;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        adapter.addFragment(new FragmentCall(), "Call");
        adapter.addFragment(new FragmentContact(), "Contacts");
        adapter.addFragment(new FragmentFavorite(), "Favorite");

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_call);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_group);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_grade);

    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AddContactsActivity.class);
        startActivity(intent);
    }
}