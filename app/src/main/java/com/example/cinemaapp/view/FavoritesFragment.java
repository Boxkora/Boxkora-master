package com.example.cinemaapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cinemaapp.R;
import com.example.cinemaapp.adapters.FavoriteFilmAdapter;


public class FavoritesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        //Add recyclerView
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view_favorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);

        final FavoriteFilmAdapter adapter = new FavoriteFilmAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }
}
