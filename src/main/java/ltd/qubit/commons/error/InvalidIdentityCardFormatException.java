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
 * 表示身份证号码错误。
 *
 * @author 胡海星
 */
public class InvalidIdentityCardFormatException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5267750209553035561L;

  private final String number;

  public InvalidIdentityCardFormatException(final String number) {
    super(ErrorCode.INVALID_IDENTITY_CARD_FORMAT);
    this.number = number;
    this.addParam("number", number);
  }

  public String getNumber() {
    return number;
  }
}
