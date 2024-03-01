package com.example.appvideojuegos.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appvideojuegos.Entities.Videogame
import com.example.appvideojuegos.R
import com.example.appvideojuegos.VideogameProvider

class DBOpenHelper private constructor(context: Context?) :

    SQLiteOpenHelper(context, VideoGameContract.NAME_DB, null, VideoGameContract.VERSION) {
    override fun onCreate(sqLiteDataBase: SQLiteDatabase) {
        try {

            sqLiteDataBase.execSQL(

                "CREATE TABLE ${VideoGameContract.Companion.Insert.TABLE_NAME}"
                        + "(${VideoGameContract.Companion.Insert.COLUMN_ID} INTEGER NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_NAME} NVARCHAR (50) NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_PLATFORM} NVARCHAR (50) NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_YEAR} INTEGER NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_DEV_COUNTRY} NVARCHAR (50) NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_LATITUDE} REAL NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_LONGITUDE} REAL NOT NULL"
                        + ",${VideoGameContract.Companion.Insert.COLUMN_IMAGE} INTEGER NOT NULL);"
            )

            initializeDDBB(sqLiteDataBase)

        } catch (e: Exception) {

            e.printStackTrace()
        }

    }

    override fun onUpgrade(sqLiteDataBase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDataBase.execSQL("DROP TABLE IF EXISTS ${VideoGameContract.Companion.Insert.TABLE_NAME};")

        onCreate(sqLiteDataBase)
    }

    private fun initializeDDBB(db: SQLiteDatabase) {

        val list = loadVideogames()
        for (videogames in list) {
            db.execSQL(
                "INSERT INTO ${VideoGameContract.Companion.Insert.TABLE_NAME}(" +

                        "${VideoGameContract.Companion.Insert.COLUMN_ID}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_NAME}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_PLATFORM}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_YEAR}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_DEV_COUNTRY}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_LATITUDE}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_LONGITUDE}," +
                        "${VideoGameContract.Companion.Insert.COLUMN_IMAGE})" +
                        "VALUES (${videogames.id},'${videogames.name}','${videogames.platform}',${videogames.year},'${videogames.country}',${videogames.latitude},${videogames.longitude},${videogames.image});"

            )
        }
    }

    fun loadVideogames(): MutableList<Videogame> {


        return mutableListOf(
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

    companion object {

        private var dbOpen: DBOpenHelper? = null
        fun getInstance(context: Context?): DBOpenHelper? {
            if (dbOpen == null) dbOpen = DBOpenHelper(context)
            return dbOpen


        }

    }


}

