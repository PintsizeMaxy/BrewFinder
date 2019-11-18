package com.example.brewfinder.userbeers

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brewfinder.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.scroll.EndlessRecyclerOnScrollListener
import com.mikepenz.fastadapter.ui.items.ProgressItem
import kotlinx.android.synthetic.main.fragment_user_beers.*

class UserBeersFragment : Fragment() {

    private val viewModel: UserBeersViewModel by viewModels()
    private val itemAdapter = ItemAdapter<UserBeersItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_user_beers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fastAdapter = FastAdapter.with(itemAdapter)
        viewModel.viewState.observe(this, Observer { state ->
            user_beers.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = fastAdapter
                itemAdapter.add(state)
            }
            progress.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
        val searchItem = menu.findItem(R.id.search).actionView as SearchView
        searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                progress.visibility = View.VISIBLE
                searchItem.clearFocus()
                searchItem.setQuery(query, false)
                query?.let { viewModel.findUserBeers(it) }
                itemAdapter.clear()
                return true
            }
            override fun onQueryTextChange(newText: String?) = false
        })
    }
}