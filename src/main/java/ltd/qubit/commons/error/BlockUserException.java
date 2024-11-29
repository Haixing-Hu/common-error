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
 * Thrown to indicate that the current user blocks another user.
 *
 * @author Haixing Hu
 */
public class BlockUserException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2981344543870559115L;

  private final String username;

  public BlockUserException(final String username) {
    super(ErrorCode.BLOCK_USER);
    this.username = username;
    this.addParam("username", username);
  }

  public String getUsername() {
    return username;
  }
}
