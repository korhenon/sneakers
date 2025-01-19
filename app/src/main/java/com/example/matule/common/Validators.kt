package com.example.matule.common


fun String.isValidEmail(): Boolean {
    val regex = """^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}${'$'}""".toRegex()
    return regex.matches(this)
}

fun String.isPasswordValid(): Boolean {
    val regex = """^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@${'$'}%^&*-]).{8,}${'$'}""".toRegex()
    return regex.matches(this)
}