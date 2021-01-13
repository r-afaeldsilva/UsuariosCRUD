package com.example.usuarioscrud.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.usuarioscrud.R
import com.example.usuarioscrud.dto.DtoUser
import com.example.usuarioscrud.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlteracaoDeUsuarioActivity : AppCompatActivity() {

    private lateinit var et_nome: EditText
    private lateinit var et_email: EditText
    private lateinit var et_tel: EditText
    private lateinit var et_pass: EditText
    private lateinit var dtoUser: DtoUser
    private var iduser: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_de_usuario)

        iduser = intent.getIntExtra("id", -1)
        var nome = intent.getStringExtra("nome")
        var email = intent.getStringExtra("email")
        var tel = intent.getStringExtra("tel")



        et_nome = findViewById(R.id.et_cadastro_usuario_nome)
        et_email = findViewById(R.id.et_cadastro_usuario_email)
        et_tel = findViewById(R.id.et_cadastro_usuario_telefone)
        et_pass = findViewById(R.id.et_cadastro_usuario_senha)



        et_nome.setText(nome)
        et_email.setText(email)
        et_tel.setText(tel)


    }

    fun cadastrar(view: View) {
        val nomeUsuario = et_nome.text.toString()
        val emailUsuario = et_email.text.toString()
        val senhaUsuario = et_pass.text.toString()
        val phoneUsuario = et_tel.text.toString()


        if (senhaUsuario.isEmpty())
            dtoUser = DtoUser(id = iduser, email = emailUsuario,name =  nomeUsuario, phone = phoneUsuario)
        else
            dtoUser = DtoUser(id = iduser, email = emailUsuario,name =  nomeUsuario, password =  senhaUsuario, phone =  phoneUsuario)

        val token: String = getToken()
        val servicoRetrofit = RetrofitService()
        dtoUser.id?.let {
            servicoRetrofit.api?.putDtoUser(dtoUser, iduser, "Bearer $token")
                ?.enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(
                            this@AlteracaoDeUsuarioActivity,
                            "Erro: ",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.code() == 200) Toast.makeText(
                            this@AlteracaoDeUsuarioActivity,
                            "Usuario alterado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                        else Toast.makeText(
                            this@AlteracaoDeUsuarioActivity,
                            "Erro: " +response.code(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
    }

    fun getToken(): String {

        val sp :SharedPreferences = getSharedPreferences("dados",0)
        return sp.getString("token",null)!!
    }

}