package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.adapter.MyAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.fragment.HomeScreenFragment
import com.example.movieapp.fragment.MovieScreenFragment


class MainActivity : AppCompatActivity(), MyAdapter.GoToMovieFragment {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeScreen()

    }

    private fun homeScreen() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, HomeScreenFragment())
            .commit()
    }

    override fun goToMovieFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MovieScreenFragment())
            .commit()
    }
}