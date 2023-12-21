package com.dicoding.toekangku1.data.datathreadsforworker

data class Worker(
    val id: Int,
    val userId: Int,
    val banned: Int,
    val closed: Int,
    val bannedReason: String?,
    val type: String,
    val title: String,
    val description: String,
    val payment: String?,
    val paymentType: String?,
    val jobStartDate: String?,
    val locationProvince: String?,
    val locationCity: String?,
    val locationSubdistrict: String?,
    val locationVillage: String?,
    val locationZipcode: String?,
    val locationDetail: String?,
    val createdAt: String,
    val updatedAt: String,
    val professions: String,
    val totalInterest: Int
)