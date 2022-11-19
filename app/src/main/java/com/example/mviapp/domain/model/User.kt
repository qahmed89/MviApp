package com.example.mviapp.domain.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mviapp.data.model.UserDto
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import kotlin.math.roundToInt

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int
)

@RequiresApi(Build.VERSION_CODES.O)
fun UserDto.toUser():User =

     User(
        firstName = this.firstName,
        lastName= lastName,
        age = LocalDate.now().year -Instant.ofEpochSecond(age)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime().year
    )
