package com.dicoding.toekangku1.data.datathreadforseeker

import com.dicoding.toekangku1.data.datathreadsforworker.Worker

object SeekerData {
    val threads = listOf(
        Worker(
            id = 1,
            userId = 2,
            banned = 0,
            closed = 0,
            bannedReason = null,
            type = "Pelanggan",
            title = "Test Postingan",
            description = "Description Postingan",
            payment = "100000",
            paymentType = "Hari",
            jobStartDate = "2023-12-30",
            locationProvince = "DKI Jakarta",
            locationCity = "Jakarta Timur",
            locationSubdistrict = "Ciracas",
            locationVillage = "Ciracas",
            locationZipcode = "13882",
            locationDetail = "Jl. Kemana hayooo",
            createdAt = "2023-12-20T12:39:23.000000Z",
            updatedAt = "2023-12-20T12:39:23.000000Z",
            professions = "Pembantu, Tukang Bangunan",
            totalInterest = 0
        ),
        Worker(
            id = 2,
        userId = 3,
        banned = 0,
        closed = 0,
        bannedReason = null,
        type = "Pelanggan",
        title = "Cari Tukang Kebun",
        description = "Membutuhkan jasa tukang kebun berpengalaman",
        payment = "150000",
        paymentType = "Hari",
        jobStartDate = "2023-12-25",
        locationProvince = "Bali",
        locationCity = "Denpasar",
        locationSubdistrict = "Denpasar Barat",
        locationVillage = "Padangsambian",
        locationZipcode = "80119",
        locationDetail = "Jl. Raya Padangsambian No. 10",
        createdAt = "2023-12-15T10:00:00.000000Z",
        updatedAt = "2023-12-15T10:00:00.000000Z",
        professions = "Tukang Kebun",
        totalInterest = 5
    ),
    Worker(
    id = 3,
    userId = 4,
    banned = 0,
    closed = 1,
    bannedReason = null,
    type = "Pelanggan",
    title = "Pekerjaan Renovasi Rumah",
    description = "Dicari kontraktor untuk renovasi rumah dua lantai",
    payment = "5000000",
    paymentType = "Proyek",
    jobStartDate = "2024-01-10",
    locationProvince = "Jawa Barat",
    locationCity = "Bandung",
    locationSubdistrict = "Coblong",
    locationVillage = "Dago",
    locationZipcode = "40135",
    locationDetail = "Jl. Ir. H.Djuanda No. 100",
    createdAt = "2023-11-30T09:20:00.000000Z",
    updatedAt = "2023-12-01T08:15:00.000000Z",
    professions = "Kontraktor, Tukang Cat",
    totalInterest = 10
    )
    )
}