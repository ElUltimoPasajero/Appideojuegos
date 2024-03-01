package com.example.appvideojuegos.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appvideojuegos.R
import com.example.appvideojuegos.databinding.ActivityEditVideogameBinding
import com.example.appvideojuegos.databinding.ActivityMainBinding

class EditVideogameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditVideogameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditVideogameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editName = binding.txtNewName
        val imageEdit = binding.imgEdit
        val img = intent.getIntExtra("img",0)
        Log.d("Prueba",img.toString())
        val videoGameName = intent.getStringExtra("videogameName")
        editName.hint=intent.getStringExtra("videogameName")

        imageEdit.setImageResource(img)

        val buttonCancel = binding.btnCancel
        val buttonEdit = binding.btnEdit

        buttonEdit.setOnClickListener {

            val intent = intent

            val name = editName.editText?.text.toString()

            intent.putExtra("name", name)

            setResult(RESULT_OK, intent)

            finish()

        }

        buttonCancel.setOnClickListener {
            finish()
        }
    }
}