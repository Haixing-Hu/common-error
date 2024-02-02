////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

/**
 * Thrown to indicates the session has expired.
 *
 * @author Haixing Hu
 */
public class SessionExpiredException  extends ServerSideException {

  private static final long serialVersionUID = 3646435083629016975L;

  public SessionExpiredException() {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.SESSION_EXPIRED);
  }
}
