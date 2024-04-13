package com.example.android_homework_1

class Counter(var countMax: Int) {
    var count: Int = 0

    fun counterMinus() {
        if (count > 0) {
            this.count -= 1
        }
    }

    fun counterPlus() {
        if (count < countMax+1) {
            this.count += 1
        }
    }

    fun printCount(): String {
        return count.toString()
    }

    fun status(): Int {
        if (count == 0) {
            return 0
        }
        if (count < countMax && count > 0) {
            return 1
        }
        else {
            return 2
        }
    }
}