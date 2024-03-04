import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculatedCommission_MasterCard_from75000() {
        val typeCard = "Mastercard"
        val amount = 50_000
        val amountForDay = 0
        val amountForMonth = 0

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(20, result)
    }

    @Test
    fun calculatedCommission_MasterCard_over50000() {
        val typeCard = "Mastercard"
        val amount = 50_000
        val amountForDay = 0
        val amountForMonth = 100_000

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(320, result)
    }

    @Test
    fun calculatedCommission_MasterCard_over75000() {
        val typeCard = "Mastercard"
        val amount = 80_000
        val amountForDay = 0
        val amountForMonth = 0

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(50, result)
    }

    @Test
    fun calculatedCommission_Visa_withoutMinCommission() {
        val typeCard = "Visa"
        val amount = 10_000
        val amountForDay = 0
        val amountForMonth = 0

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(75, result)
    }

    @Test
    fun calculatedCommission_Visa_MinCommission() {
        val typeCard = "Visa"
        val amount = 100
        val amountForDay = 0
        val amountForMonth = 0

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(35, result)
    }

    @Test
    fun calculatedCommission_MIR() {
        val typeCard = "Мир"
        val amount = 10_000
        val amountForDay = 0
        val amountForMonth = 0

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(0, result)
    }

    @Test
    fun calculatedCommission_overLimitsPerDay() {
        val typeCard = "Mastercard"
        val amount = 100_000
        val amountForDay = 150_000
        val amountForMonth = 200_000

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(-1, result)
    }

    @Test
    fun calculatedCommission_overLimitsPerMonth() {
        val typeCard = "Mastercard"
        val amount = 100_000
        val amountForDay = 0
        val amountForMonth = 550_000

        val result = calculatedCommission(
            typeCard = typeCard,
            amountForMonth = amountForMonth,
            amountForDay = amountForDay,
            amount = amount)

        assertEquals(-1, result)
    }
}