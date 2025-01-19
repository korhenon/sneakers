package com.example.matule.common


fun String.isValidEmail(): Boolean {
    return this == "mail@mail.com"
}

fun String.isPasswordValid(): Boolean {
    return this == "Qw123%rty"
}