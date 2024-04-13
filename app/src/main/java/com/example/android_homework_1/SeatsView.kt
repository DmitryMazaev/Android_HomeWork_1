package com.example.android_homework_1

class SeatsView {
    var seats: Int = 0
    fun seatsView(count: Int, countMax: Int):String {
        if (count == 0) {
            return "Все места свободны"
        }
        if (count <= countMax && count > 0) {
            seats = countMax-count
            return "Осталось мест: $seats"
        }
        else {
            return "Пассажиров слишком много"
        }
    }
}