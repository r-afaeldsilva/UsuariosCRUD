package com.example.usuarioscrud.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.usuarioscrud.R
import com.example.usuarioscrud.dto.DtoUser
import com.example.usuarioscrud.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroDeUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_de_usuario)
    }

    fun cadastrar(view: View) {
        val nomeUsuario = findViewById<TextView>(R.id.et_cadastro_usuario_nome)
        val emailUsuario = findViewById<TextView>(R.id.et_cadastro_usuario_email)
        val senhaUsuario = findViewById<TextView>(R.id.et_cadastro_usuario_senha)
        val phoneUsuario = findViewById<TextView>(R.id.et_cadastro_usuario_telefone)
        val usuario = DtoUser(email = emailUsuario.text.toString(), name =  nomeUsuario.text.toString(), phone = phoneUsuario.text.toString(), password = senhaUsuario.text.toString())

        nomeUsuario.text  =""
        emailUsuario.text =""
        senhaUsuario.text =""
        phoneUsuario.text =""


        val servicoRetrofit = RetrofitService()
        servicoRetrofit.api?.postDtoUser(usuario)?.enqueue(object : Callback<DtoUser> {
            override fun onFailure(call: Call<DtoUser>, t: Throwable) {
                Toast.makeText(
                    this@CadastroDeUsuarioActivity,
                    "Usuário não cadastrado!!",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(call: Call<DtoUser>, response: Response<DtoUser>) {
                Log.d("Teste", response.body()?.id.toString())
                if (response.code() == 201) Toast.makeText(
                    this@CadastroDeUsuarioActivity,
                    "Usuário cadastrado com sucesso!!",
                    Toast.LENGTH_LONG
                ).show()
                else Toast.makeText(
                    this@CadastroDeUsuarioActivity,
                    "Usuário não cadastrado!!",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}