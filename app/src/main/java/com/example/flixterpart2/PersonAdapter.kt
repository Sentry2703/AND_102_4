package com.example.flixterpart2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val PERSON_EXTRA = "PERSON_EXTRA"
class PersonAdapter(private val context: Context, private val people: List<Person>):
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_people, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person)
    }

    override fun getItemCount() = people.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val personImageView = itemView.findViewById<ImageView>(R.id.personImage)
        private val nameTextView = itemView.findViewById<TextView>(R.id.name)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(person: Person) {
            nameTextView.text = person.name
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/"+person.image)
                .into(personImageView)
        }

        override fun onClick(v: View?) {
            val person = people[absoluteAdapterPosition]

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PERSON_EXTRA, person)
            context.startActivity(intent)
        }

    }
}