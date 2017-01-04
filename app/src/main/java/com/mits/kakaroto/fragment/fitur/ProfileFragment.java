package com.mits.kakaroto.fragment.fitur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mits.kakaroto.fragment.R;

/**
 * Created by sunari on 04/01/17.
 */

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Profile");

        ImageView imgHome = (ImageView) activity.findViewById(R.id.img_home);
        ImageView imgFavorite = (ImageView) activity.findViewById(R.id.img_favorite);
        ImageView imgProfile = (ImageView) activity.findViewById(R.id.img_profile);

        imgProfile.setImageResource(R.drawable.person_red);
        imgHome.setImageResource(R.drawable.home);
        imgFavorite.setImageResource(R.drawable.favorite);


    }

}
