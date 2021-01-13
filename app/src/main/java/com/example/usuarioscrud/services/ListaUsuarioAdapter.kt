package com.example.usuarioscrud.services

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usuarioscrud.R
import com.example.usuarioscrud.activities.AlteracaoDeUsuarioActivity
import com.example.usuarioscrud.dto.DtoUser

class ListaUsuarioAdapter (val context : Context, val dados: List<DtoUser>?):
    RecyclerView.Adapter<ListaUsuarioAdapter.UsuarioViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        return UsuarioViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout_listar_usuarios,parent,false))
    }

    override fun getItemCount() = dados!!.size

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.nome!!.text = dados!![position].name
        holder.email!!.text = dados!![position].email
        holder.telefone!!.text = dados!![position].phone
    }

    inner class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val nome = itemView.findViewById<TextView>(R.id.tv_listar_nome)
        val email: TextView?= itemView.findViewById(R.id.tv_listar_email)
        val telefone: TextView?= itemView.findViewById(R.id.tv_listar_telefone)

        init {
            itemView.setOnClickListener(this);
        }

        override fun onClick(v: View?) {
            val user = dados?.get(layoutPosition)
            val intent = Intent(context, AlteracaoDeUsuarioActivity::class.java)
            intent.putExtra("id", user?.id)
            intent.putExtra("nome", user?.name)
            intent.putExtra("email", user?.email)
            intent.putExtra("tel", user?.phone)
            context.startActivity(intent)
        }
    }
}