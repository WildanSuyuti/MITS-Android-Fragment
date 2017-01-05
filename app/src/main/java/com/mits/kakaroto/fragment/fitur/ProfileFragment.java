package com.mits.kakaroto.fragment.fitur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        ((NavDrawerActivity) getActivity()).setActionBarTitle("Profile");
        ((NavDrawerActivity) getActivity()).setActivePage(NavDrawerActivity.PAGE_PROFILE);
    }

}
