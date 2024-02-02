////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * Thrown to indicte that the format of the password is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidIdentityCardFormatException extends BusinessLogicException {

  private static final long serialVersionUID = 5267750209553035561L;

  public InvalidIdentityCardFormatException(final String number) {
    super(ErrorCode.INVALID_IDENTITY_CARD_FORMAT,
        new KeyValuePair("number", number));
  }
}
