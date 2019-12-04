package com.example.brewfinder.pub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brewfinder.MainActivity
import com.example.brewfinder.R
import com.example.brewfinder.databinding.RecyclerGenericBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class PubFragment: Fragment() {

    private lateinit var binding: RecyclerGenericBinding
    private lateinit var pubViewModel: PubViewModel
    private val itemAdapter = ItemAdapter<PubItemView>()
    private val fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecyclerGenericBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findLocation()
        pubViewModel.viewState.observe(this, Observer { state ->

            binding.listRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = fastAdapter
                itemAdapter.add(state)
            }
            binding.progressCircular.visibility = View.GONE
        })
    }

    private fun findLocation() {
        binding.progressCircular.visibility = View.VISIBLE
        pubViewModel =
            ViewModelProvider(this, PubViewModelFactory(activity as MainActivity)).get(
                PubViewModel::class.java
            )
    }
}