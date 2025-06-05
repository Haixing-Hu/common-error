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
 * 表示当前操作需要用户登出（即匿名用户）。
 *
 * @author 胡海星
 */
public class LogoutRequiredException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -6379576131252730952L;

  /**
   * 构造一个 {@link LogoutRequiredException} 对象。
   */
  public LogoutRequiredException() {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.LOGOUT_REQUIRED);
  }
}
