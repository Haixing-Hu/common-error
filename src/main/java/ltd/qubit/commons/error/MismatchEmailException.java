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
 * 表示电子邮箱不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchEmailException extends BusinessLogicException {

  private static final long serialVersionUID = -415242668412153893L;

  private final String name;
  private final String expected;
  private final String actual;

  public MismatchEmailException(final String name, final String expected,
          final String actual) {
    super(ErrorCode.MISMATCH_EMAIL,
        new KeyValuePair("name", name),
        new KeyValuePair("expected_email", expected),
        new KeyValuePair("actual_email", actual));
    this.name = name;
    this.expected = expected;
    this.actual = actual;
  }

  public String getName() {
    return name;
  }

  public String getExpected() {
    return expected;
  }

  public String getActual() {
    return actual;
  }
}
