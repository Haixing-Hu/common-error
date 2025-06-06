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
 * 此错误表示当前用户被另一个用户所屏蔽。
 *
 * @author 胡海星
 */
public class BlockedByUserException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -6606852043180373539L;

  private final String username;

  /**
   * 构造一个 {@link BlockedByUserException} 对象。
   *
   * @param username
   *     屏蔽当前用户的用户的用户名。
   */
  public BlockedByUserException(final String username) {
    super(ErrorCode.BLOCKED_BY_USER);
    this.username = username;
    this.addParam("username", username);
  }

  /**
   * 获取屏蔽当前用户的用户的用户名。
   *
   * @return
   *     屏蔽当前用户的用户的用户名。
   */
  public String getUsername() {
    return username;
  }
}
