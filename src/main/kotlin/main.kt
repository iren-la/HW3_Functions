fun main() {
    //homework 1
    val secondsFromLastLogin = 10800
    agoToText(secondsFromLastLogin)
    println()

    //homework 2
    //общие параметры переводов между картами
    val typeCard = "Mastercard"
    val limitPerDay = 150_000
    val limitPerMonth = 600_000
    val amount = 150_000
    val amountForDay = 0
    val amountForMonth = 0

    //проверка на дневной и месячный лимит вне зависимости от типа карты
    if (amount + amountForDay <= limitPerDay && amount + amountForMonth <= limitPerMonth) {
        println("Комиссия за перевод составит " + calculatedCommission(typeCard, amountForMonth, amount) + " руб.")
    } else {
        println("Перевод невозможен. Превышены установленные лимиты.")
    }

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

fun calculatedCommission (typeCard: String, amountForMonth: Int = 0, amount: Int) : Int {
    //параметры коммиссий и лимитов по типам кард
    val commissionMastercard = 0.006
    val fixCommissionMastercard = 20
    val sumWithoutCommissionMastercard = 75_000
    val commissionVisa = 0.0075
    val minCommissionVisa = 35

    //расчет коммиссии в зависимости от типа карты
    when (typeCard) {
        "Mastercard" -> return when {
            amountForMonth >= sumWithoutCommissionMastercard -> (amount * commissionMastercard + fixCommissionMastercard).toInt()
            amount + amountForMonth > sumWithoutCommissionMastercard -> ((amount + amountForMonth - sumWithoutCommissionMastercard) * commissionMastercard + fixCommissionMastercard).toInt()
            else -> 0
        }
        "Visa" -> return if (amount * commissionVisa > minCommissionVisa) (amount * commissionVisa).toInt() else minCommissionVisa
        else -> return 0
    }
}