package com.example.brewfinder.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.example.brewfinder.R
import com.example.brewfinder.databinding.BeerDetailFragmentBinding

class BeerFragment : Fragment() {

    private val args: BeerFragmentArgs by navArgs()
    private lateinit var viewModel: BeerViewModel
    private lateinit var binding: BeerDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BeerDetailFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            BeerViewModelFactory(args.breweryId)
        ).get(BeerViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewScope.observe(this, Observer {
            binding.beerImage.load(it.beerLabel) {
                placeholder(R.drawable.ic_photo)
            }
            binding.beerName.text = it.beerName
            binding.beerDescription.text = it.description
            binding.beerStyle.text = it.beerStyle
            binding.beerAbv.text = String.format("%.1f%c", it.beerAbv, '%')
            binding.beerIbu.text = String.format("%d IBU", it.beerIbu)
        })
    }
}