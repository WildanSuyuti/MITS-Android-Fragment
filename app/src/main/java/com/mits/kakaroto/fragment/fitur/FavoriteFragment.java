package com.mits.kakaroto.fragment.fitur;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mits.kakaroto.fragment.R;
import com.mits.kakaroto.fragment.adapter.MovieAdapter;
import com.mits.kakaroto.fragment.model.Movie;
import com.mits.kakaroto.fragment.utility.RecyclerTouchListener;
import com.mits.kakaroto.fragment.utility.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunari on 04/01/17.
 */

public class FavoriteFragment extends Fragment {
    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    private Context thisContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_viewFavorite);
        thisContext = container.getContext();

        initView();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Favorite");
        ((MainActivity) getActivity()).setActivePage(MainActivity.PAGE_FAVORITE);
    }

    private void initView() {

        List<Movie> list;
        list = new ArrayList<>();

        list.add(new Movie("Trolls", "Comedy", "2016", "USA", "1:30:55", R.drawable.comedy_trolls));
        list.add(new Movie("Baked in Brooklyn", "Comedy", "2016", "USA", "1:40:32", R.drawable.comedy_baked_in_brooklyn));
        list.add(new Movie("Bounty Hunter", "Action", "2016", "China", "1:40:21", R.drawable.action_bounty_hunters));
        list.add(new Movie("Dragon Ball", "Anime", "2015", "Japan", "1:33:57", R.drawable.anime_dragon_ball_resurrection_f));

        adapter = new MovieAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(thisContext));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(thisContext, R.dimen.space_5));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(thisContext, recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Movie movie = adapter.getItem(position);
                        ((MainActivity) getActivity())
                                .openFragment(DetailMovieFragment.newInstance(movie));
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

    }
}

