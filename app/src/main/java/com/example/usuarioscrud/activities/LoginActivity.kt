package com.example.usuarioscrud.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.usuarioscrud.R
import com.example.usuarioscrud.dto.DtoLogin
import com.example.usuarioscrud.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun logar(view: View) {
        val emailUsuario = findViewById<TextView>(R.id.et_login_email)
        val senhaUsuario = findViewById<TextView>(R.id.et_login_senha)
        val login = DtoLogin(emailUsuario.text.toString(), senhaUsuario.text.toString())


        val servicoRetrofit = RetrofitService()

        servicoRetrofit.api?.postDtoLogin(login)?.enqueue(object : Callback<DtoLogin> {
            override fun onResponse(call: Call<DtoLogin>, response: Response<DtoLogin>) {
                Log.d("Teste", response.body()?.email.toString())
                if (response.code() == 200) Toast.makeText(
                    this@LoginActivity,
                    "Seja bem-vindo!",
                    Toast.LENGTH_LONG
                ).show()
                else Toast.makeText(
                    this@LoginActivity,
                    "Erro ao fazer login!",
                    Toast.LENGTH_LONG
                ).show()
                val sp = getSharedPreferences("dados", 0)
                val editor = sp.edit()
                editor.putString("token", response.body()?.token)
                editor.apply()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))

            }

            override fun onFailure(call: Call<DtoLogin>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    "Erro ao fazer login",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        }
    }