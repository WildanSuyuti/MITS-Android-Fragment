package com.mits.kakaroto.fragment.fitur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mits.kakaroto.fragment.R;
import com.mits.kakaroto.fragment.model.Movie;

/**
 * Created by sunari on 04/01/17.
 */

public class DetailMovieFragment extends Fragment {
    private TextView showTitle, showGenre, showYear, showCountry, showDuration;
    private ImageView showImage;

    public static Fragment newInstance(Movie data){
        Bundle bundle = new Bundle();
        bundle.putParcelable("movie", data);

        DetailMovieFragment fragment = new DetailMovieFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_movie, container, false);

        showTitle = (TextView) rootView.findViewById(R.id.tv_showTitle);
        showGenre = (TextView) rootView.findViewById(R.id.tv_showGenre);
        showYear = (TextView) rootView.findViewById(R.id.tv_showYear);
        showCountry = (TextView) rootView.findViewById(R.id.tv_showCountry);
        showDuration = (TextView) rootView.findViewById(R.id.tv_showDuration);
        showImage = (ImageView) rootView.findViewById(R.id.img_showImage);

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();

        if (bundle != null) {
            Movie movie = bundle.getParcelable("movie");
            assert movie != null;
            ((NavDrawerActivity) getActivity()).setActionBarTitle(movie.getTitle());

            showTitle.setText(movie.getTitle());
            showGenre.setText(movie.getGenre());
            showYear.setText(movie.getYear());
            showCountry.setText(movie.getCountry());
            showDuration.setText(movie.getDuration());
            showImage.setImageResource(movie.getImageAddrees());
        }

    }

}
