package com.example.movieapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapter.MyAdapter
import com.example.movieapp.const.Constants.Companion.API_KEY
import com.example.movieapp.repository.Repository
import com.example.movieapp.viewmodel.MainViewModel
import com.example.movieapp.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_home_screen.view.*

class HomeScreenFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var myAdapter: MyAdapter
    private lateinit var myRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)


        myAdapter = MyAdapter()
        myRecyclerView = view.movie_recyclerView
        myRecyclerView.adapter = myAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getMovie(API_KEY)
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {

            Log.d("Response", "${it.body()}")
        })

        return view
    }


}

