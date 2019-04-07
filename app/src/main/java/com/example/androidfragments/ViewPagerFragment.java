package com.example.androidfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;

public class ViewPagerFragment extends LoggingFragment {

    public static final String KEY_RECIPE_INDEX = "recipe_index";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        assert getArguments() != null;
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();

        Objects.requireNonNull(getActivity()).setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPager);

        final IngredientsFragment ingredientsFragment = new IngredientsFragment();
        final DirectionsFragment directionsFragment = new DirectionsFragment();

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //return position == 0 ? ingredientsFragment : directionsFragment;
                if(position == 0){
                    return ingredientsFragment;
                }else{
                    return directionsFragment;
                }
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        /*TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);*/

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(getActivity()).setTitle(getResources().getString(R.string.app_name));
    }
}
