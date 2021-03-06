package com.nadir.search.core.repository

import com.nadir.networking.ServiceGeneratorImpl

class HotelSearchRepository{

    private val serviceGenerator: ServiceGeneratorImpl = ServiceGeneratorImpl()

    fun searchLocation(location: String): List<String> {
        val locationResult = serviceGenerator.execute("www.api.priceline.com/lookup?search=$location")

        return listOf(locationResult)
    }
}