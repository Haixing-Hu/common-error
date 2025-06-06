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
 * 表示当前用户阻止另一个用户的异常。
 *
 * @author 胡海星
 */
public class BlockUserException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2981344543870559115L;

  private final String username;

  /**
   * 构造一个 {@link BlockUserException} 对象。
   *
   * @param username
   *     被阻止的用户的用户名。
   */
  public BlockUserException(final String username) {
    super(ErrorCode.BLOCK_USER);
    this.username = username;
    this.addParam("username", username);
  }

  /**
   * 获取被阻止的用户的用户名。
   *
   * @return
   *     被阻止的用户的用户名。
   */
  public String getUsername() {
    return username;
  }
}
