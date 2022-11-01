package com.example.cinemaapp.adapters;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Film;
import com.example.cinemaapp.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {
    private List<Film> filmlist = new ArrayList<>();
    private int mExpandedPosition = -1;

    public FilmAdapter() {
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_card, parent, false);
        return new FilmHolder(itemView);
    }

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    public void onBindViewHolder(@NonNull final FilmHolder holder, @SuppressLint("RecyclerView") final int position) {
        Film currentFilm = filmlist.get(position);
        holder.filmObject = currentFilm;
        holder.poster.setImageResource(currentFilm.getImagePath());
        holder.textViewTitle.setText(currentFilm.getTitle());
        holder.textViewGenre.setText(currentFilm.getGenre());
        holder.textViewRating.setText("  " + currentFilm.getRating());
        holder.textViewDescription.setText(currentFilm.getDescription());



        boolean isFavorite = Repository.searchInFavorites(currentFilm);
        if (isFavorite) {
            holder.favorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_favorite_red_35dp, 0);
        } else {
            holder.favorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_favorite_border_black_35dp, 0);
        }

        //expand card
        final boolean isExpanded = position == mExpandedPosition;
        holder.detailsOnExpand.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        int expandedIconId = isExpanded ? R.drawable.ic_keyboard_arrow_up_black_24dp : R.drawable.ic_keyboard_arrow_down_black_24dp;
        holder.expandIcon.setCompoundDrawablesWithIntrinsicBounds(0, 0, expandedIconId, 0);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(v -> {
            mExpandedPosition = isExpanded ? -1 : position;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(holder.detailsOnExpand);
            }
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return filmlist.size();
    }

    public void setFilmlist(List<Film> filmlist) {
        this.filmlist = filmlist;
    }

    static class FilmHolder extends RecyclerView.ViewHolder {
        private Film filmObject;

        private final ImageView poster;
        private final TextView textViewTitle;
        private final TextView textViewGenre;
        private final TextView textViewRating;
        private final TextView expandIcon;
        private final TextView textViewDescription;
        private final RelativeLayout detailsOnExpand;
        List<RadioButton> buttons = new ArrayList<>();
        private final Button favorite;


        public FilmHolder(final View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.film_poster);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewGenre = itemView.findViewById(R.id.text_view_genre);
            textViewRating = itemView.findViewById(R.id.text_view_rating);
            expandIcon = itemView.findViewById(R.id.expand_icon);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            detailsOnExpand = itemView.findViewById(R.id.details_on_expand);

            favorite = itemView.findViewById(R.id.heart);
            favorite.setOnClickListener(v -> {
                boolean isFavorite = Repository.searchInFavorites(filmObject);
                if (!isFavorite) {
                    favorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_favorite_red_35dp, 0);
                    filmObject.setFavorite();
                    Repository.addToFavorites(filmObject);
                } else {
                    favorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_favorite_border_black_35dp, 0);
                    filmObject.setFavorite();
                    Repository.deleteFromFavorites(filmObject);
                }
            });
        }
    }
}
