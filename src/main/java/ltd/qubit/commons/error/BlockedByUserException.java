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

  public BlockedByUserException(final String username) {
    super(ErrorCode.BLOCKED_BY_USER);
    this.username = username;
    this.addParam("username", username);
  }

  public String getUsername() {
    return username;
  }
}
