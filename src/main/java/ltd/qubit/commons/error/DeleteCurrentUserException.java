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
 * 表示当前登录用户试图删除自己的异常。
 *
 * @author 胡海星
 */
public class DeleteCurrentUserException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 1516336901328899608L;

  private final String username;

  /**
   * 构造一个 {@link DeleteCurrentUserException} 对象。
   *
   * @param username
   *     当前登录用户的用户名。
   */
  public DeleteCurrentUserException(final String username) {
    super(ErrorCode.DELETE_CURRENT_USER, new KeyValuePair("username", username));
    this.username = username;
  }

  /**
   * 获取当前登录用户的用户名。
   *
   * @return
   *     当前登录用户的用户名。
   */
  public String getUsername() {
    return username;
  }

}
