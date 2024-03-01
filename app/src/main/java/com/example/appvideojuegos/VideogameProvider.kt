package com.example.appvideojuegos

import com.example.appvideojuegos.Entities.Videogame

class VideogameProvider {
    companion object{
        var videogameLis = mutableListOf(
            Videogame(
                1,
                "California Games",
                "Megadrive",
                1987,
                "Estados Unidos",
                37.7749,
                -122.4194,
                R.drawable.california

            ),
            Videogame(
                3,
                "Columns",
                "Megadrive",
                1990,
                "Japón",
                35.6895,
                139.6917,
                R.drawable.columns_cftj
            ),
            Videogame(
                4,
                "Comix Zone",
                "Megadrive",
                1995,
                "Estados Unidos",
                37.7749,
                -122.4194,
                R.drawable.comix_zone
            ),
            Videogame(
                5,
                "Exhumed",
                "Sega Saturn",
                1996,
                "Reino Unido",
                51.509865,
                -0.118092,
                R.drawable.exhumed_cftj
            ),
            Videogame(
                6,
                "FIFA 97",
                "Sega Saturn",
                1996,
                "Canadá",
                45.4215,
                -75.6993,
                R.drawable.fifa_97peq
            ),
            Videogame(
                7,
                "Ghostbusters",
                "Megadrive",
                1990,
                "Estados Unidos",
                37.7749,
                -122.4194,
                R.drawable.ghostbusters
            ),
            Videogame(
                8,
                "Ghouls n Ghosts",
                "Megadrive",
                1988,
                "Japón",
                35.6895,
                139.6917,
                R.drawable.ghouls_n_ghosts
            ),
            Videogame(
                9,
                "Phantasy Star II",
                "Megadrive",
                1989,
                "Japón",
                35.6895,
                139.6917,
                R.drawable.phantasy_star_ii_cftj
            ),
            Videogame(
                10,
                "Populous",
                "Megadrive",
                1989,
                "Reino Unido",
                51.509865,
                -0.118092,
                R.drawable.populous
            ),
            Videogame(
                11,
                "Resident Evil",
                "Sega Saturn",
                1996,
                "Japón",
                35.6895,
                139.6917,
                R.drawable.resident_evil_cftj
            ),
            Videogame(
                12,
                "Sonic the Hedgehog",
                "Megadrive",
                1991,
                "Estados Unidos",
                37.7749,
                -122.4194,
                R.drawable.sonic

            )
        )

    }
}