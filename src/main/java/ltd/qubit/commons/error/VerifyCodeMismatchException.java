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
 * 表示验证码不匹配的异常。
 *
 * @author 胡海星
 */
public class VerifyCodeMismatchException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -1767662246498278604L;

  /**
   * 构造一个 {@link VerifyCodeMismatchException} 对象。
   */
  public VerifyCodeMismatchException() {
    super(ErrorCode.VERIFY_CODE_MISMATCH);
  }

}
