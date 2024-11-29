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
 * 表示姓名不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchPersonNameException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5970828760534220946L;

  private final String expectedName;
  private final String actualName;

  public MismatchPersonNameException(final String expectedName, final String actualName) {
    super(ErrorCode.MISMATCH_PERSON_NAME);
    this.expectedName = expectedName;
    this.actualName = actualName;
    this.addParam("expected_name", expectedName);
    this.addParam("actual_name", actualName);
  }

  public String getExpectedName() {
    return expectedName;
  }

  public String getActualName() {
    return actualName;
  }
}
