package com.example.usuarioscrud.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.usuarioscrud.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_login -> {
                startActivity(Intent(this, LoginActivity::class.java))
                true
            }R.id.action_cadastro_de_usuario-> {
                startActivity(Intent(this, CadastroDeUsuarioActivity::class.java))
                true
            }R.id.action_lista_usuario -> {
                startActivity(Intent(this, ListaUsuarioActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}