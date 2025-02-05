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
import java.sql.SQLException;

import javax.annotation.Nullable;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * Thrown to indicate a server side database error.
 * <p>
 * This exception wraps a {@link SQLException} and it can be thrown without
 * declaring in the method signature.
 *
 * @author Haixing Hu
 */
public class ServerSideDatabaseException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -7756366273738562547L;

  private final SQLException cause;

  public ServerSideDatabaseException(final SQLException cause) {
    super(ErrorType.DATABASE_ERROR, ErrorCode.DATABASE_ERROR,
        new KeyValuePair("message", cause.getMessage()));
    this.cause = cause;
  }

  public ServerSideDatabaseException(final String message) {
    super(ErrorType.DATABASE_ERROR, ErrorCode.DATABASE_ERROR,
        new KeyValuePair("message", message));
    this.cause = new SQLException(message);
  }

  @Nullable
  @Override
  public SQLException getCause() {
    return cause;
  }
}
