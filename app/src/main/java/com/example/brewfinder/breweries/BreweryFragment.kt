package com.example.brewfinder.breweries

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brewfinder.MainActivity
import com.example.brewfinder.R
import com.example.brewfinder.databinding.BreweryRecyclerBinding
import com.example.brewfinder.pub.PubItemView
import com.example.brewfinder.pub.PubViewModel
import com.example.brewfinder.pub.PubViewModelFactory
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class BreweryFragment : Fragment() {

    private lateinit var binding: BreweryRecyclerBinding
    private val viewModel: BreweryViewModel by viewModels()
    private lateinit var pubViewModel: PubViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BreweryRecyclerBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findLocation()
        val itemAdapter = ItemAdapter<BreweryItem>()
        val fastAdapter = FastAdapter.with(itemAdapter)
        viewModel.viewState.observe(this, Observer { state ->
            itemAdapter.clear()
            binding.listRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = fastAdapter
                itemAdapter.add(state)
            }
        })
        fastAdapter.onClickListener = { _, _, item, _ ->
            navigateToDetails(item.model.breweryId)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
        val searchItem = menu.findItem(R.id.search).actionView as SearchView
        searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.listRecycler.isVisible = query?.isNotEmpty() ?: false
                searchItem.clearFocus()
                searchItem.setQuery(query, false)
                query?.let { viewModel.searchBreweries(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?) = false
        })
    }

    private fun findLocation() {
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
        })
    }

    private fun navigateToDetails(item: Int): Boolean {
        val action =
            BreweryFragmentDirections.actionBreweryFragmentToBreweryDetailFragment2(item)
        findNavController().navigate(action)
        return false
    }
}