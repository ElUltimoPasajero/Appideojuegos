package com.example.appvideojuegos.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.appvideojuegos.Entities.Videogame
import com.example.appvideojuegos.Entities.VideogameDAO
import com.example.appvideojuegos.R
import com.example.appvideojuegos.VideogameAdapter
import com.example.appvideojuegos.VideogameProvider
import com.example.appvideojuegos.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var emptyVideogameList: List<Videogame>
    private lateinit var videogameList: List<Videogame>
    private lateinit var videogameAdapter: VideogameAdapter
    lateinit var videoGameToEdit: Videogame
    private var videoGameNewname = "Default"
    private lateinit var intentLaunch: ActivityResultLauncher<Intent>


    lateinit var videogameDAO: VideogameDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        videogameDAO = VideogameDAO()
        binding.rvVideogames.layoutManager = LinearLayoutManager(this)
        videogameList = videogameDAO.loadList(this)

        binding.rvVideogames.adapter = VideogameAdapter(videogameList){
            videogame -> onItemSelected(videogame)
        }


        intentLaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {

                result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {

                //Nos traemos la devolucion de los datos a una variable
                videoGameNewname = result.data?.extras?.getString("name").toString()
            }

            videoGameToEdit.name = videoGameNewname

            val index = videogameList.indexOf(videoGameToEdit)

            videogameDAO.uploadVideogame(this, videoGameToEdit, index + 1)

            videogameList = videogameDAO.loadList(this)

            binding.rvVideogames.adapter!!.notifyItemChanged(index)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        setTitle("VideoGames")
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Clean -> {
                cleanList()
                true
            }

            R.id.Reload -> {
                reload()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun reload() {
        //Recargamos la lista de la base de datos
        videogameList = videogameDAO.loadList(this)

        //Se la asignamos actualizada al adaptador
        binding.rvVideogames.adapter = VideogameAdapter(videogameList) { videogame -> onItemSelected(videogame) }
    }


    private fun cleanList() {


        emptyVideogameList = videogameDAO.loadEmpty(this)
        binding.rvVideogames.adapter = VideogameAdapter(emptyVideogameList){videogame -> onItemSelected(videogame)

        }


    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        lateinit var videgameAffected: Videogame
        lateinit var newIntent: Intent

        videgameAffected = videogameList[item.groupId]

        when (item.itemId) {

            0 -> {

                val alert =
                    AlertDialog.Builder(this).setTitle("Edit ${videgameAffected.name}")
                        .setMessage("¿Are you sure to edit this Game?:  ${videgameAffected.name}")
                        .setNeutralButton("Close", null).setPositiveButton("Accept") { _, _ ->

                            videoGameToEdit = videgameAffected

                            binding.rvVideogames.adapter = VideogameAdapter(videogameList){videogame -> onItemSelected(videogame) }

                            newIntent = Intent(this, EditVideogameActivity::class.java)

                            newIntent.putExtra("name", videoGameNewname)
                            newIntent.putExtra("img", videgameAffected.image)
                            newIntent.putExtra("videogameName", videgameAffected.name)

                            intentLaunch.launch(newIntent)


                        }.create()
                alert.show()


            }
        }
        return true


    }

    private fun sneacker(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    fun onItemSelected(videogame: Videogame) {
        Toast.makeText(
            this,
            "${videogame.name}",
            Toast.LENGTH_SHORT
        ).show()
    }
}





