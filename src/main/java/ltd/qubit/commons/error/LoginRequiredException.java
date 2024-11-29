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
 * Indicates that the operation should be performed by logged-in users.
 *
 * @author Haixing Hu
 */
public class LoginRequiredException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 5527219095032159842L;

  public LoginRequiredException() {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.LOGIN_REQUIRED);
  }
}
