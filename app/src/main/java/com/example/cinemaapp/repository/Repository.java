package com.example.cinemaapp.repository;

import com.example.cinemaapp.R;
import com.example.cinemaapp.model.Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    public static List<Film> favoriteList = new ArrayList<>();

    public static List<Film> getHardcodedList() {
        return Arrays.asList(
                new Film("Avatar: The Way of Water", "Action", "Jake Sully lives with his newfound family formed on the planet of Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their planet. ", 10.0, R.drawable.avatar),
                new Film("Black Panther: Wakanda Forever", "Action", "Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T'Challa's death. As the Wakandans strive to embrace their next chapter, the heroes must band together with Nakia and Everett Ross to forge a new path for their beloved kingdom. ", 9.0, R.drawable.wakanda),
                new Film("Spider-Man: No Way Home", "Action", "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man. ", 8.0, R.drawable.spiderman),
                new Film("Minions: The Rise of Gru", "Animation", "The untold story of one twelve-year-old's dream to become the world's greatest supervillain. ", 7.0, R.drawable.minion),
                new Film("Elemental", "Animation", "Follows Ember and Wade, in a city where fire-, water-, land- and air-residents live together. ", 6.0, R.drawable.elemental),
                new Film("Violet Evergarden: Eternity and the Auto Memory Doll", "Animation", "Violet Evergarden, a former soldier returned from war, comes to teach at a women's academy and changes a young girl's life. ", 5.0, R.drawable.violet),
                new Film("Hotel Transylvania 4: Transformania", "Animation", "After one experiment, Johnny turns into a monster and everyone else becomes human. Now it has to be seen whether they will be able to reverse this experiment. ", 4.0, R.drawable.hotel),
                new Film("The Watcher", "Horror", "A married couple moving into their dream home are threatened by terrifying letters from a stalker, signed - \"The Watcher.\". ", 3.0, R.drawable.thewatcher),
                new Film("Wish", "Animation", "17-year-old Asha and her goat Valentino navigate Rosas, the kingdom of wishes, where wishes can literally come true. ", 2.0, R.drawable.wish)
        );
    }

    public static void addToFavorites(Film film) {

        if (!searchInFavorites(film)) {

            favoriteList.add(film);
        }

    }

    public static boolean searchInFavorites(Film film) {

        for (Film f : favoriteList) {

            if (f.equals(film))
                return true;
        }
        return false;
    }

    public static void deleteFromFavorites(Film film) {

        for (Film f : favoriteList) {

            if (f.equals(film)) {
                favoriteList.remove(f);
                return;
            }
        }
    }
}

