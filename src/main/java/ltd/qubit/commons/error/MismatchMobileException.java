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
 * @author Haixing Hu
 */
public class MismatchMobileException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3171777375509325949L;

  private final String name;
  private final Phone expectedMobile;
  private final Phone actualMobile;

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

  public String getName() {
    return name;
  }

  public Phone getExpectedMobile() {
    return expectedMobile;
  }

  public Phone getActualMobile() {
    return actualMobile;
  }
}
