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
 * 表示验证码已过期的异常。
 *
 * @author 胡海星
 */
public class VerifyCodeExpiredException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3445682897108257543L;

  /**
   * 构造一个 {@link VerifyCodeExpiredException} 对象。
   */
  public VerifyCodeExpiredException() {
    super(ErrorCode.VERIFY_CODE_EXPIRED);
  }

}
