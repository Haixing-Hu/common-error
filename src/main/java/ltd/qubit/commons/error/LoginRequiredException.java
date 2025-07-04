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
 * 表示当前操作需要用户登录。
 *
 * @author 胡海星
 */
public class LoginRequiredException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 5527219095032159842L;

  /**
   * 构造一个 {@link LoginRequiredException} 对象。
   */
  public LoginRequiredException() {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.LOGIN_REQUIRED);
  }
}
