package com.example.cliptest.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cliptest.R
import com.example.cliptest.domain.model.Result
import com.squareup.picasso.Picasso

class UserAdapter(var users: Array<Result>? = null) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    interface AdapterClickListener{
        fun onItemSelected(user: Result?)
    }

    var listener: AdapterClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = users?.get(position)
        holder.run {
            this.name.text = "${item?.name?.first?:""} ${item?.name?.last?:""}".trim()
            this.username.text = item?.login?.username?.trim()
            this.phone.text = item?.cell
            Picasso.get().load(item?.picture?.thumbnail)
                .into(this.thumb)

            this.itemView.setOnClickListener {
                listener?.onItemSelected(item)
            }
        }
    }

    override fun getItemCount() = users?.size?:0

    fun updateInfo(users: Array<Result>?){
        this.users = users
        notifyDataSetChanged()
    }

    fun setClickListener(listener: AdapterClickListener?){
        this.listener = listener
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val username = itemView.findViewById(R.id.userName) as TextView
        val name= itemView.findViewById(R.id.name) as TextView
        val phone = itemView.findViewById(R.id.phone) as TextView
        val thumb = itemView.findViewById(R.id.thumbnail) as ImageView

    }

}