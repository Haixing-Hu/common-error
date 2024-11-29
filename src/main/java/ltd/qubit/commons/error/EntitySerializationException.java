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
 * Thrown to indicate a serialization error.
 *
 * @author Haixing Hu
 */
public class EntitySerializationException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -4103007173690364857L;

  public EntitySerializationException(final Throwable cause) {
    super(ErrorType.SERVER_ERROR, ErrorCode.SERIALIZATION_ERROR, cause);
  }

  public EntitySerializationException(final String message) {
    super(ErrorType.SERVER_ERROR, ErrorCode.SERIALIZATION_ERROR,
        new KeyValuePair("message", message));
  }
}
