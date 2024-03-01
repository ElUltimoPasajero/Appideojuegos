package com.example.appvideojuegos.Entities

import android.content.Context
import android.database.Cursor
import com.example.appvideojuegos.DB.DBOpenHelper

class VideogameDAO {

    fun loadList(context: Context?): MutableList<Videogame> {

        lateinit var result: MutableList<Videogame>
        lateinit var v: Cursor

        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase

            val sql = "SELECT * FROM videogames"

            v = db.rawQuery(sql, null)

            result = mutableListOf()

            while (v.moveToNext()) {

                val new = Videogame(
                    v.getInt(0), v.getString(1),
                    v.getString(2), v.getInt(3), v.getString(4),
                    v.getDouble(5), v.getDouble(6), v.getInt(7)
                )

                //CUIDADO! Si el id es autoincrementad el 0 se reserva para el id!!
                result.add(new)
            }


        } finally {
            v?.close()
        }
        return result

    }

    fun uploadVideogame(context: Context?, v: Videogame, index: Int) {

        val db = DBOpenHelper.getInstance(context)!!.writableDatabase
        db.execSQL(
            "UPDATE VIDEOGAMES " +
                    "SET name='${v.name}', image=${v.image} " +
                    "WHERE ID=$index;"
        )

    }


    fun deleteVideogame(context: Context?, name: String) {

        val db = DBOpenHelper.getInstance(context)!!.writableDatabase

        db.execSQL("DELETE FROM videogames WHERE name='$name';")


    }

    fun loadEmpty(context: Context?): MutableList<Videogame> {

        var result = mutableListOf<Videogame>()

        return result
    }

}