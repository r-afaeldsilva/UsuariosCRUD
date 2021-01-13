package com.example.usuarioscrud.activities

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usuarioscrud.R
import com.example.usuarioscrud.dto.DtoUser
import com.example.usuarioscrud.services.ListaUsuarioAdapter
import com.example.usuarioscrud.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaUsuarioActivity : AppCompatActivity() {

    val listaDeContatos = ArrayList<DtoUser>()
    var recycler: RecyclerView? = null
    var adapter: ListaUsuarioAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuario)


        buscaDados()

    }

    private fun buscaDados() {
        val token = getSharedPreferences("dados",0).getString("token",null)
        RetrofitService().api?.getDtoListUser("Bearer $token")?.enqueue(object : Callback<List<DtoUser?>?> {
            override fun onResponse(
                call: Call<List<DtoUser?>?>,
                response: Response<List<DtoUser?>?>
            ) {
                recycler = findViewById((R.id.recycle))
                adapter = ListaUsuarioAdapter(this@ListaUsuarioActivity, response.body() as List<DtoUser>?)
                recycler?.layoutManager = LinearLayoutManager(this@ListaUsuarioActivity)
                recycler?.adapter = adapter
            }

            override fun onFailure(call: Call<List<DtoUser?>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
