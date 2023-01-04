package travelator.money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money {
  private final BigDecimal amount;
  private final Currency currency;

  private Money(BigDecimal amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public static Money of(BigDecimal amount, Currency currency) {
    return new Money(
        amount.setScale(currency.getDefaultFractionDigits()),
        currency
    );
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Money money)) {
      return false;
    }
    return amount.equals(money.getAmount()) && currency.equals(money.getCurrency());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAmount(), getCurrency());
  }

  @Override
  public String toString() {
    return amount.toString() + " " + currency.getCurrencyCode();
  }

  public Money add(Money that) {
    if (!this.currency.equals(that.currency)) {
      throw new IllegalArgumentException(
          "can not add Money values of different currencies"
      );
    }
    return new Money(that.amount.add(that.amount), that.currency);
  }

}
