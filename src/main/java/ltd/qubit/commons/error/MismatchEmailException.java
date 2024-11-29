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

/**
 * 表示电子邮箱不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchEmailException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -415242668412153893L;

  private final String name;
  private final String expectedEmail;
  private final String actualEmail;

  public MismatchEmailException(final String name, final String expectedEmail,
          final String actualEmail) {
    super(ErrorCode.MISMATCH_EMAIL);
    this.name = name;
    this.expectedEmail = expectedEmail;
    this.actualEmail = actualEmail;
    this.addParam("name", name);
    this.addParam("expected_email", expectedEmail);
    this.addParam("actual_email", actualEmail);
  }

  public String getName() {
    return name;
  }

  public String getExpectedEmail() {
    return expectedEmail;
  }

  public String getActualEmail() {
    return actualEmail;
  }
}
