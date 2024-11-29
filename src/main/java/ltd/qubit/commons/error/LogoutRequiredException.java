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
 * Indicates that the operation should be performed by anonymous users.
 *
 * @author Haixing Hu
 */
public class LogoutRequiredException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -6379576131252730952L;

  public LogoutRequiredException() {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.LOGOUT_REQUIRED);
  }
}
