package com.example.submission1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter internal constructor(private val context: Context, private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(users[holder.adapterPosition])

        holder.itemView.setOnClickListener {
            val user = User(
                users.get(position).username,
                users.get(position).name,
                users.get(position).avatar,
                users.get(position).company,
                users.get(position).location,
                users.get(position).repository,
                users.get(position).follower,
                users.get(position).following
            )

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_USER, user)
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(user: User){
            with(itemView){
                photo.setImageResource(user.avatar)
                name.text = user.name
                company.text = user.company
                location.text = user.location

            }
        }
    }

}