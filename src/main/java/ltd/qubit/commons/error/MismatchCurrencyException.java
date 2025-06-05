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
 * @author 胡海星
 */
public class MismatchCurrencyException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8021373779863352893L;

  private final Currency expectedCurrency;
  private final Currency actualCurrency;

  /**
   * 使用预期的货币单位和实际的货币单位构造一个 {@link MismatchCurrencyException} 对象。
   *
   * @param expectedCurrency
   *     预期的货币单位。
   * @param actualCurrency
   *     实际的货币单位。
   */
  public MismatchCurrencyException(final Currency expectedCurrency, final Currency actualCurrency) {
    super(ErrorCode.MISMATCH_CURRENCY);
    this.expectedCurrency = expectedCurrency;
    this.actualCurrency = actualCurrency;
    this.addParam("expected_currency", expectedCurrency);
    this.addParam("actual_currency", actualCurrency);
  }

  /**
   * 获取预期的货币单位。
   *
   * @return 预期的货币单位。
   */
  public Currency getExpectedCurrency() {
    return expectedCurrency;
  }

  /**
   * 获取实际的货币单位。
   *
   * @return 实际的货币单位。
   */
  public Currency getActualCurrency() {
    return actualCurrency;
  }
}
