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
 * Thrown to indicate the current logged-in user try to delete the user
 * of itself.
 *
 * @author Haixing Hu
 */
public class DeleteCurrentUserException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 1516336901328899608L;

  private final String username;

  public DeleteCurrentUserException(final String username) {
    super(ErrorCode.DELETE_CURRENT_USER, new KeyValuePair("username", username));
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

}
