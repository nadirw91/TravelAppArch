package com.nadir.search.hotel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.nadir.search.hotel.R
import com.nadir.search.hotel.viewmodel.HotelSearchViewModel
import kotlinx.coroutines.flow.collect

class HotelSearchFragment: Fragment() {

    private val viewModel = HotelSearchViewModel(
        lifecycleOwner = this
    )

    companion object {
        fun newInstance() = HotelSearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel_search, container)
    }

    private fun onUserSearchChange(query: String) {
        lifecycleScope.launchWhenResumed {
            viewModel.lookupLocation(query)
                .collect {
                    // update recycler view
                }
        }
    }
}