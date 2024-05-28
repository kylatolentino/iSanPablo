package com.app.isanpablo.ui.login
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("username") val username: String
)