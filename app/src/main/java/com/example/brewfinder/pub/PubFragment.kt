package com.example.brewfinder.pub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brewfinder.MainActivity
import com.example.brewfinder.databinding.RecyclerGenericBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class PubFragment: Fragment() {

    private lateinit var binding: RecyclerGenericBinding
    private lateinit var pubViewModel: PubViewModel

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
    }

    private fun findLocation() {
        binding.progressCircular.visibility = View.VISIBLE
        pubViewModel =
            ViewModelProvider(this, PubViewModelFactory(activity as MainActivity)).get(
                PubViewModel::class.java
            )
        pubViewModel.viewState.observe(this, Observer { state ->
            val itemAdapter = ItemAdapter<PubItemView>()
            val fastAdapter = FastAdapter.with(itemAdapter)
            binding.listRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = fastAdapter
                itemAdapter.add(state)
            }
            binding.progressCircular.visibility = View.GONE
        })
    }
}