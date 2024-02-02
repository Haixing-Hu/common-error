////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.commons.Currency;

/**
 * 表示货币单位不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchCurrencyException extends BusinessLogicException {

  private static final long serialVersionUID = 8021373779863352893L;

  private final Currency expected;
  private final Currency actual;

  public MismatchCurrencyException(final Currency expected, final Currency actual) {
    super(ErrorCode.MISMATCH_CURRENCY,
        new KeyValuePair("expected_currency", expected),
        new KeyValuePair("actual_currency", actual));
    this.expected = expected;
    this.actual = actual;
  }

  public Currency getExpected() {
    return expected;
  }

  public Currency getActual() {
    return actual;
  }
}
