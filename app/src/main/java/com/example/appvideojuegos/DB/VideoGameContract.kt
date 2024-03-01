package com.example.appvideojuegos.DB

import android.provider.BaseColumns

class VideoGameContract {

    companion object {

        val NAME_DB = "videogames"
        val VERSION= 1
        class Insert : BaseColumns{
            companion object{

                const  val TABLE_NAME ="videogames"
                const  val COLUMN_ID="ID"
                const  val COLUMN_NAME="name"
                const  val COLUMN_PLATFORM="platform"
                const  val COLUMN_YEAR="year"
                const  val COLUMN_DEV_COUNTRY="country"
                const  val COLUMN_LATITUDE="latitude"
                const  val COLUMN_LONGITUDE="longitude"
                const  val COLUMN_IMAGE="image"


            }
        }

    }

}