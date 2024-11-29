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
 * An exception thrown to indicates the user login failed too many times.
 *
 * @author Haixing Hu
 */
public class TooManyLoginFailuresException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -885058974515170735L;

  private final String username;
  private final long duration;

  public TooManyLoginFailuresException(final String username, final long expiredSeconds) {
    super(ErrorType.AUTHENTICATION_ERROR,
        ErrorCode.TOO_MANY_LOGIN_FAILURES,
        new KeyValuePair("username", username),
        new KeyValuePair("duration", expiredSeconds));
    this.username  = username;
    this.duration = expiredSeconds;
  }

  public final String getUsername() {
    return username;
  }

  public long getDuration() {
    return duration;
  }
}
