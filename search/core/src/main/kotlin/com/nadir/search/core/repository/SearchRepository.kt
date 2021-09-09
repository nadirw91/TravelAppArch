package com.nadir.search.core.repository

import com.nadir.networking.ServiceGeneratorImpl
import com.nadir.search.core.dto.TravelSearch

class SearchRepository constructor(
    private val serviceGenerator: ServiceGeneratorImpl = ServiceGeneratorImpl()
) {

    fun saveSearch(search: TravelSearch) {
        serviceGenerator.execute("www.api.priceline.com/saveSearch?userId=123&product=${search.product}")
    }

}