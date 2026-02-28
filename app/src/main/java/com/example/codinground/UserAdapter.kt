package com.example.codinground.adapter

import android.content.Context
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codinground.R
import com.example.codinground.model.User

class UserAdapter(
    private val list: List<User>,
    private val context: Context
) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(v: View) :
        RecyclerView.ViewHolder(v) {

        val name: TextView =
            v.findViewById(R.id.name)

        val img: ImageView =
            v.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(context)
            .inflate(
                R.layout.item_user,
                parent,
                false
            )

        return ViewHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val user = list[position]

        holder.name.text =
            user.firstName + " " + user.lastName

        Glide.with(context)
            .load(user.image)
            .into(holder.img)
    }
}