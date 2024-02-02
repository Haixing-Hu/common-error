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

/**
 * 表示姓名不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchPersonNameException extends BusinessLogicException {

  private static final long serialVersionUID = 5970828760534220946L;

  private final String expected;
  private final String actual;

  public MismatchPersonNameException(final String expected, final String actual) {
    super(ErrorCode.MISMATCH_PERSON_NAME,
        new KeyValuePair("expected_name", expected),
        new KeyValuePair("actual_name", actual));
    this.expected = expected;
    this.actual = actual;
  }

  public String getExpected() {
    return expected;
  }

  public String getActual() {
    return actual;
  }
}
