package com.nadir.search.hotel.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.nadir.search.core.dto.TravelSearch
import com.nadir.search.hotel.R
import com.nadir.search.hotel.viewmodel.HotelSearchViewModel
import kotlinx.coroutines.flow.collect

class HotelSearchFragment: Fragment() {

    private val viewModel = HotelSearchViewModel(
        lifecycleOwner = this
    )

    private val location: EditText by lazy {
        requireView().findViewById(R.id.location)
    }

    private val checkIn: TextView by lazy {
        requireView().findViewById(R.id.check_in)
    }

    private val checkOut: TextView by lazy {
        requireView().findViewById(R.id.check_out)
    }

    private val searchButton: Button by lazy {
        requireView().findViewById(R.id.search)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel_search, container)
    }

    override fun onResume() {
        super.onResume()

        location.doOnTextChanged { text, _, _, _ ->
            onUserSearchChange(text.toString())
        }

        checkIn.setOnClickListener {
            DatePickerDialog(requireContext())
                .show()
        }

        checkOut.setOnClickListener {
            DatePickerDialog(requireContext())
                .show()
        }

        searchButton.setOnClickListener {
            viewModel.navigateToSearch(
                TravelSearch.HotelSearch(
                    location = location.text.toString(),
                    checkInDate = checkIn.text.toString(),
                    checkoutDate = checkOut.text.toString()
                )
            )
        }
    }

    private fun onUserSearchChange(query: String) {
        lifecycleScope.launchWhenResumed {
            viewModel.lookupLocation(query)
                .collect {
                    Toast.makeText(requireContext(), "Locations For: $query", Toast.LENGTH_SHORT).show()
                }
        }
    }
}