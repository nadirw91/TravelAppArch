package com.nadir.search.core.dto

sealed class TravelSearch {
    data class HotelSearch(val checkInDate: String, val checkoutDate: String): TravelSearch()
    data class OneWaySearch(val departureDate: String, val departureAirport: String, val arrivalAirport: String): TravelSearch()
    data class RoundTripSearch(val departureDate: String, val returnDate: String, val departureAirport: String, val arrivalAirport: String): TravelSearch()
}