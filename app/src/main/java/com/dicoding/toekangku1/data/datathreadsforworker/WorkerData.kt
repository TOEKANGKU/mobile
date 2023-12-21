package com.dicoding.toekangku1.data.datathreadsforworker

object WorkerData {
    val workers = listOf(
        Worker(
            id = 3,
            userId = 2,
            banned = 0,
            closed = 0,
            bannedReason = null,
            type = "Pekerja",
            title = "Test Postingan 2",
            description = "Description Postingan",
            payment = "",
            paymentType = "",
            jobStartDate = null,
            locationProvince = "Banten",
            locationCity = "Tangerang Selatan",
            locationSubdistrict = "CIputat",
            locationVillage = "Ciputat Timur",
            locationZipcode = "15412",
            locationDetail = null,
            createdAt = "2023-12-21T04:38:35.000000Z",
            updatedAt = "2023-12-21T04:38:35.000000Z",
            professions = "Pembantu, Tukang Bangunan",
            totalInterest = 0
        ),
        Worker(
            id = 2,
            userId = 2,
            banned = 0,
            closed = 0,
            bannedReason = null,
            type = "Pekerja",
            title = "Test Postingan",
            description = "Description Postingan",
            payment = null,
            paymentType = null,
            jobStartDate = null,
            locationProvince = null,
            locationCity = null,
            locationSubdistrict = null,
            locationVillage = null,
            locationZipcode = null,
            locationDetail = null,
            createdAt = "2023-12-20T13:29:32.000000Z",
            updatedAt = "2023-12-20T13:29:32.000000Z",
            professions = "Pembantu, Tukang Bangunan",
            totalInterest = 0
        )
        // Add other workers as needed
    )
}