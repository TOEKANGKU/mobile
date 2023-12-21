package com.dicoding.toekangku1.response.main

import com.google.gson.annotations.SerializedName

data class GetWorkerResponse(

	@field:SerializedName("data")
	val data: getWorker? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class getWorker(

	@field:SerializedName("offset")
	val offset: String? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("limit")
	val limit: String? = null,

	@field:SerializedName("workers")
	val workers: List<Any?>? = null
)
