package com.example.flixterpart2

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity: AppCompatActivity() {

    private lateinit var mediaImage: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var descriptionTextView : TextView
    private lateinit var titleTextView: TextView
    private lateinit var posterImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mediaImage = findViewById(R.id.imageView)
        nameTextView = findViewById(R.id.name)
        descriptionTextView = findViewById(R.id.description)
        titleTextView = findViewById(R.id.title)
        posterImage = findViewById(R.id.poster)

        val person = intent.getSerializableExtra(PERSON_EXTRA) as Person

        nameTextView.text = person.name
        descriptionTextView.text = person.descriptionT

        if (person.titleT != "BlankA") {
            titleTextView.text = person.titleT
        } else if (person.titleU != "BlankB") {
            titleTextView.text = person.titleU
        } else if (person.titleV != "BlankC") {
            titleTextView.text = person.titleV
        }else {
            titleTextView.text = person.titleW
        }

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + person.image)
            .into(mediaImage)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + person.poster)
            .into(posterImage)
    }

}