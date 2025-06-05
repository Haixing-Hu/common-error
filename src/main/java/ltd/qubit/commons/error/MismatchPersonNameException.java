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
 * @author 胡海星
 */
public class MismatchPersonNameException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5970828760534220946L;

  private final String expectedName;
  private final String actualName;

  /**
   * 使用预期的姓名和实际的姓名构造一个 {@link MismatchPersonNameException} 对象。
   *
   * @param expectedName
   *     预期的姓名。
   * @param actualName
   *     实际的姓名。
   */
  public MismatchPersonNameException(final String expectedName, final String actualName) {
    super(ErrorCode.MISMATCH_PERSON_NAME);
    this.expectedName = expectedName;
    this.actualName = actualName;
    this.addParam("expected_name", expectedName);
    this.addParam("actual_name", actualName);
  }

  /**
   * 获取预期的姓名。
   *
   * @return 预期的姓名。
   */
  public String getExpectedName() {
    return expectedName;
  }

  /**
   * 获取实际的姓名。
   *
   * @return 实际的姓名。
   */
  public String getActualName() {
    return actualName;
  }
}
