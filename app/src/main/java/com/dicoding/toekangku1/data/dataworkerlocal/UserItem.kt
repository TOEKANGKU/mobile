package com.dicoding.toekangku1.data.dataworkerlocal

import com.dicoding.toekangku1.response.userdata

data class UserItem(
    val item: UserLocal,
    val count: Int,
    val limit: Int
)