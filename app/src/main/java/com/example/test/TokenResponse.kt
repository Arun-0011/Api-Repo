package com.example.test

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("tokendetail") var tokendetail: ArrayList<TokenDetail> = arrayListOf()
)

data class TokenDetail(
    @SerializedName("token") var token: String? = null,
    @SerializedName("current_token") var currentToken: String? = null,
    @SerializedName("token_price") var tokenPrice: String? = null,
    @SerializedName("token_image") var tokenImage: String? = null,
    @SerializedName("token_value") var tokenValue: Int? = null,
    @SerializedName("token_id") var tokenId: String? = null,
    @SerializedName("stake") var stake: Int? = null,
    @SerializedName("fees") var fees: Double? = null,
    @SerializedName("fees_type") var feesType: String? = null
)