package travelator.money

import java.math.BigDecimal
import java.util.Currency
import java.util.Objects

/**
 * 자바와 비교해서 가독성이 좋다고 평가할 수 없다.
 * - 정적팩터리함수로만 생성 가능하게 열어두고 BigDecimal의 Scale(정밀도)에 제한을 두었다. 하지만 이 클래스를 데이터 클래스로
 * 변환하면 자동생성되는 copy 함수 때문에 불변성이 깨질 수 있다.
 */

class Money
private constructor(
    val amount: BigDecimal,
    val currency: Currency,
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val money = other as Money
        return amount == money.amount && currency == money.currency
    }

    override fun hashCode(): Int {
        return Objects.hash(amount, currency)
    }

    override fun toString(): String {
        return amount.toString() + " " + currency.currencyCode
    }

    fun add(that: Money): Money {
        require(currency == that.currency) {
            "cannot add Money values of different currencies"
        }
        return Money(amount.add(that.amount), currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency): Money {
            return Money(
                amount.setScale(currency.defaultFractionDigits),
                currency,
            )
        }
    }
}