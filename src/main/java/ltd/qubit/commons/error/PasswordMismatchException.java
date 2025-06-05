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

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示密码不匹配的异常。
 *
 * @author 胡海星
 */
public class PasswordMismatchException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 6497054624698434844L;

  private final String username;

  /**
   * 使用指定的用户名构造一个 {@link PasswordMismatchException} 对象。
   *
   * @param username
   *     密码不匹配的用户名。
   */
  public PasswordMismatchException(final String username) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.PASSWORD_MISMATCH,
        new KeyValuePair("username", username));
    this.username = username;
  }

  /**
   * 获取密码不匹配的用户名。
   *
   * @return 密码不匹配的用户名。
   */
  public final String getUsername() {
    return username;
  }
}
