////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.io.Serial;

import ltd.qubit.model.commons.Currency;

/**
 * 表示货币单位不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchCurrencyException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8021373779863352893L;

  private final Currency expectedCurrency;
  private final Currency actualCurrency;

  public MismatchCurrencyException(final Currency expectedCurrency, final Currency actualCurrency) {
    super(ErrorCode.MISMATCH_CURRENCY);
    this.expectedCurrency = expectedCurrency;
    this.actualCurrency = actualCurrency;
    this.addParam("expected_currency", expectedCurrency);
    this.addParam("actual_currency", actualCurrency);
  }

  public Currency getExpectedCurrency() {
    return expectedCurrency;
  }

  public Currency getActualCurrency() {
    return actualCurrency;
  }
}
