package com.dicoding.toekangku1.data.dataworkerlocal

object UserData {
    val users = listOf(
        UserLocal(
            id = 1,
            type = "Pekerja",
            name = "John Doe",
            email = "john.doe@example.com",
            emailVerifiedAt = "2023-01-10T08:20:55.000000Z",
            nik = "3201010101010001",
            phone = "081234567890",
            gender = "Laki-Laki",
            birthDate = "1990-01-01",
            addressProvince = "Jawa Barat",
            addressCity = "Bandung",
            addressSubdistrict = "Regol",
            addressVillage = "Cibaduyut",
            addressZipcode = "40235",
            addressDetail = "Jalan Sukajadi No. 10",
            locationProvince = "Jawa Barat",
            locationCity = "Bandung",
            locationSubdistrict = "Regol",
            locationVillage = "Cibaduyut",
            profesion = "Tukang Kayu",
            startYear = 2010,
            createdAt = "2023-01-10T08:20:55.000000Z",
            updatedAt = "2023-01-10T08:20:55.000000Z",
            pictureUrl = "https://drive.google.com/file/d/13kH6qfA0s1L6WMwGj_lCfQtWLPci6FT8/view?usp=drive_link"
        ),
        UserLocal(
            id = 2,
            type = "Pelanggan",
            name = "Jane Smith",
            email = "jane.smith@example.com",
            emailVerifiedAt = "2023-02-14T09:30:22.000000Z",
            nik = "3201020202020002",
            phone = "082345678901",
            gender = "Perempuan",
            birthDate = "1985-02-14",
            addressProvince = "Jakarta",
            addressCity = "Jakarta Pusat",
            addressSubdistrict = "Menteng",
            addressVillage = "Cikini",
            addressZipcode = "10330",
            addressDetail = "Jalan MH Thamrin No. 5",
            locationProvince = "Jakarta",
            locationCity = "Jakarta Pusat",
            locationSubdistrict = "Menteng",
            locationVillage = "Cikini",
            profesion = "Pengusaha",
            startYear = 2015,
            createdAt = "2023-02-14T09:30:22.000000Z",
            updatedAt = "2023-02-14T09:30:22.000000Z",
            pictureUrl = "https://example.com/images/jane.jpg"
        ),
        )
}