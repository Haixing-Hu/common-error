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

import ltd.qubit.model.contact.Phone;

/**
 * 表示手机号码不匹配。
 *
 * @author 胡海星
 */
public class MismatchMobileException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3171777375509325949L;

  private final String name;
  private final Phone expectedMobile;
  private final Phone actualMobile;

  /**
   * 使用指定的名称、预期手机号码和实际手机号码构造一个 {@link MismatchMobileException} 对象。
   *
   * @param name
   *     发生手机号码不匹配的实体的名称或描述。
   * @param expectedMobile
   *     预期的手机号码。
   * @param actualMobile
   *     实际的手机号码。
   */
  public MismatchMobileException(final String name, final Phone expectedMobile,
      final Phone actualMobile) {
    super(ErrorCode.MISMATCH_MOBILE);
    this.name = name;
    this.expectedMobile = expectedMobile;
    this.actualMobile = actualMobile;
    this.addParam("name", name);
    this.addParam("expected_mobile", expectedMobile);
    this.addParam("actual_mobile", actualMobile);
  }

  /**
   * 获取发生手机号码不匹配的实体的名称或描述。
   *
   * @return 发生手机号码不匹配的实体的名称或描述。
   */
  public String getName() {
    return name;
  }

  /**
   * 获取预期的手机号码。
   *
   * @return 预期的手机号码。
   */
  public Phone getExpectedMobile() {
    return expectedMobile;
  }

  /**
   * 获取实际的手机号码。
   *
   * @return 实际的手机号码。
   */
  public Phone getActualMobile() {
    return actualMobile;
  }
}
