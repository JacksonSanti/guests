package com.example.convidados.view.viewholder

import android.content.DialogInterface
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel
import com.example.convidados.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {

        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim", object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, p1: Int) {
                        listener.onDelete(guest.id)
                    }
                })
                .setNegativeButton("Não", object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, p1: Int) {
                        val s = ""
                    }
                })
                .create()
                .show()


            true
        }


    }

}