package com.nadir.search.hotel.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.nadir.search.core.dto.TravelSearch
import com.nadir.search.core.repository.HotelSearchRepository
import com.nadir.search.core.repository.SearchRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class HotelSearchViewModel constructor(
    private val lifecycleOwner: LifecycleOwner,
    private val hotelSearchRepository: HotelSearchRepository = HotelSearchRepository(),
    private val searchRepository: SearchRepository = SearchRepository()
) {
    private var job: Job? = null

    fun navigateToSearch(search: TravelSearch) {
        searchRepository.saveSearch(search)
        // navigate to integrated listings
    }

    fun lookupLocation(query: String): Flow<List<String>> {
        job?.cancel()

        val locationFlow = MutableStateFlow<List<String>>(emptyList())

        job = lifecycleOwner.lifecycleScope.launchWhenResumed {
            val searchLocation = hotelSearchRepository.searchLocation(query)

            locationFlow.value = searchLocation
        }

        return locationFlow
    }
}