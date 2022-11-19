package com.example.mviapp.presention

sealed interface Event {
    object fetchUser:Event
    object Retry:Event
    object Navigate:Event
    object RequestThrownException :Event

}