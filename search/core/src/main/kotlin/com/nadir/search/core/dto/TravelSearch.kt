package com.nadir.search.core.dto

sealed class TravelSearch(val product: Int) {
    data class HotelSearch(val checkInDate: String, val checkoutDate: String): TravelSearch(5)
    data class OneWaySearch(val departureDate: String, val departureAirport: String, val arrivalAirport: String): TravelSearch(1)
    data class RoundTripSearch(val departureDate: String, val returnDate: String, val departureAirport: String, val arrivalAirport: String): TravelSearch(1)
}