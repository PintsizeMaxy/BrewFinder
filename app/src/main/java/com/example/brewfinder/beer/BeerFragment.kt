package com.example.brewfinder.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.databinding.FragmentBeerDetailsBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class BeerFragment : Fragment() {

    private val args: BeerFragmentArgs by navArgs()
    private lateinit var viewModel: BeerViewModel
    private lateinit var binding: FragmentBeerDetailsBinding
    private val itemAdapter = ItemAdapter<BeerCheckInItemView>()
    private val fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeerDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            BeerViewModelFactory(args.breweryId)
        ).get(BeerViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkinRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = fastAdapter
        }
        viewModel.viewScope.observe(this, Observer {
            binding.beerImage.load(it.beerLabel) {
                placeholder(R.drawable.ic_photo)
            }
            itemAdapter.setNewList(it.checkins.items.map { BeerCheckInItemView(it) })
            binding.beerName.text = it.beerName
            binding.beerStyle.text = it.beerStyle
            binding.beerAbv.text = String.format("%.1f%c", it.beerAbv, '%')
            binding.beerIbu.text = String.format("%d IBU", it.beerIbu)
        })
    }
}