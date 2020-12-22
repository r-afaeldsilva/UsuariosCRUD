package com.example.usuarioscrud.services

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usuarioscrud.R

class ListaUsuarioHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val nome: TextView?= itemView.findViewById(R.id.tv_listar_nome)
    val email: TextView?= itemView.findViewById(R.id.tv_listar_email)
    val telefone: TextView?= itemView.findViewById(R.id.tv_listar_telefone)


}