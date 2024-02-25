fun main() {
    //homework 1
    val secondsFromLastLogin = 10800
    agoToText(secondsFromLastLogin)
    println()

    //homework 2


}

fun agoToText (seconds: Int) {
    when {
        seconds < 60 -> println("был(а) только что")
        seconds >= 60 && seconds < 60*60 -> println("был(а) " + seconds/60 + correctWordForMinutes(seconds) + " назад")
        seconds >= 60*60 && seconds < 24*60*60 -> println("был(а) " + seconds/3600 + correctWordForHours(seconds) + " назад")
        24*60*60 <= seconds && seconds < 24*60*60*2 -> println("был(а) вчера")
        24*60*60*2 <= seconds && seconds < 24*60*60*3 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

fun correctWordForMinutes (seconds: Int) : String {
    val minutes = seconds / 60 //количество секунд в минуте
    return when (minutes) {
        1, 21, 31, 41, 51 -> " минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> " минуты"
        else -> " минут"
    }
}

fun correctWordForHours (seconds: Int) : String {
    val hours = seconds / 3600  //количество секунд в часе
    return when (hours) {
        1, 21 -> " час"
        2, 3, 4, 22, 23, 24 -> " часа"
        else -> " часов"
    }
}