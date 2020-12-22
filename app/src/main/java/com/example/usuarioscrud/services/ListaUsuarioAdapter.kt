package com.example.usuarioscrud.services

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usuarioscrud.R
import com.example.usuarioscrud.dto.DtoUser

class ListaUsuarioAdapter : RecyclerView.Adapter<ListaUsuarioHolder>{
    var dados : List<DtoUser>? = null
    var geradorDeView : LayoutInflater? = null

    constructor(dados:List<DtoUser>?, contexto:Context?){
        this.dados = dados
        geradorDeView = LayoutInflater.from(contexto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaUsuarioHolder {
        return ListaUsuarioHolder(geradorDeView!!.inflate(R.layout.item_layout_listar_usuarios,parent,false))
    }

    override fun getItemCount() = dados!!.size

    override fun onBindViewHolder(holder: ListaUsuarioHolder, position: Int) {
        holder.nome!!.text = dados!![position].name
        holder.email!!.text = dados!![position].email
        holder.telefone!!.text = dados!![position].phone
    }


}