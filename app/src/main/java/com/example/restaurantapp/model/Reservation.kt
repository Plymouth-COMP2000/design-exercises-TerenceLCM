package com.example.restaurantapp.model

data class Reservation(
    val id: String,
    val customerName: String,
    val partySize: Int,
    val date: String,
    val time: String,
    val status: ReservationStatus,
    val email: String? = null,
    val phone: String? = null
)

enum class ReservationStatus {
    PENDING,
    CONFIRMED,
    CANCELLED
}

