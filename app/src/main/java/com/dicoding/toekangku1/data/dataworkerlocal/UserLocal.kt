package com.dicoding.toekangku1.data.dataworkerlocal

data class UserLocal (
    val id: Int,
    val type: String,
    val name: String,
    val email: String,
    val emailVerifiedAt: String?,
    val nik: String,
    val phone: String,
    val gender: String,
    val birthDate: String,
    val addressProvince: String,
    val addressCity: String,
    val addressSubdistrict: String,
    val addressVillage: String,
    val addressZipcode: String,
    val addressDetail: String?,
    val locationProvince: String,
    val locationCity: String,
    val locationSubdistrict: String,
    val locationVillage: String,
    val profesion: String,
    val startYear: Int,
    val createdAt: String,
    val updatedAt: String,
    val pictureUrl: String?
)