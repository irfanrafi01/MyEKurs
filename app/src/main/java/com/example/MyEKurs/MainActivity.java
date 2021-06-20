package com.example.MyEKurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.MyEKurs.Fragment.PagerAdapter.HomePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new HomePagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0: {
                        tab.setText("Home");
                        tab.setIcon(R.drawable.ic_home);
                        break;
                    }
                    case 1: {
                        tab.setText("Book");
                        tab.setIcon(R.drawable.ic_book);
                        break;
                    }
                    case 2: {
                        tab.setText("Changer");
                        tab.setIcon(R.drawable.ic_changer);
                        break;
                    }
                    case 3: {
                        tab.setText("News");
                        tab.setIcon(R.drawable.ic_news);
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }
}