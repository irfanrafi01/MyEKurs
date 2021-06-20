package com.example.MyEKurs.Fragment.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.MyEKurs.Fragment.BookFragment;
import com.example.MyEKurs.Fragment.ChangerFragment;
import com.example.MyEKurs.Fragment.HomeFragment;
import com.example.MyEKurs.Fragment.NewsFragment;

public class HomePagerAdapter extends FragmentStateAdapter {

    public HomePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new BookFragment();
            case 2:
                return new ChangerFragment();
            default:
                return new NewsFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
