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
 * The exception thrown to indicate the mismatch of password.
 *
 * @author Haixing Hu
 */
public class PasswordMismatchException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 6497054624698434844L;

  private final String username;

  public PasswordMismatchException(final String username) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.PASSWORD_MISMATCH,
        new KeyValuePair("username", username));
    this.username = username;
  }

  public final String getUsername() {
    return username;
  }
}
