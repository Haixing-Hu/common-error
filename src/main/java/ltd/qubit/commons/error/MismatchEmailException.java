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
 * @author 胡海星
 */
public class MismatchEmailException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -415242668412153893L;

  private final String name;
  private final String expectedEmail;
  private final String actualEmail;

  /**
   * 使用指定的名称、预期电子邮箱和实际电子邮箱构造一个 {@link MismatchEmailException} 对象。
   *
   * @param name
   *     发生电子邮箱不匹配的实体的名称或描述。
   * @param expectedEmail
   *     预期的电子邮箱地址。
   * @param actualEmail
   *     实际的电子邮箱地址。
   */
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

  /**
   * 获取发生电子邮箱不匹配的实体的名称或描述。
   *
   * @return 发生电子邮箱不匹配的实体的名称或描述。
   */
  public String getName() {
    return name;
  }

  /**
   * 获取预期的电子邮箱地址。
   *
   * @return 预期的电子邮箱地址。
   */
  public String getExpectedEmail() {
    return expectedEmail;
  }

  /**
   * 获取实际的电子邮箱地址。
   *
   * @return 实际的电子邮箱地址。
   */
  public String getActualEmail() {
    return actualEmail;
  }
}
