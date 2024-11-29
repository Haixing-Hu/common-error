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
 * Thrown to indicate that the format of username is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidUsernameFormatException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -1543906267261960741L;

  private final String requirement;
  private final int minLength;
  private final int maxLength;

  public InvalidUsernameFormatException(final String requirement,
      final int minLength, final int maxLength) {
    super(ErrorCode.INVALID_USERNAME_FORMAT);
    this.requirement = requirement;
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.addParam("requirement", requirement);
    this.addParam("min_length", minLength);
    this.addParam("max_length", maxLength);
  }

  public String getRequirement() {
    return requirement;
  }

  public int getMinLength() {
    return minLength;
  }

  public int getMaxLength() {
    return maxLength;
  }
}
