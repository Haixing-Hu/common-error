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
 * Thrown to indicate that the SQL syntax is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidSqlSyntaxException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -5151306626067986677L;

  public InvalidSqlSyntaxException() {
    super(ErrorType.DATABASE_ERROR, ErrorCode.INVALID_SQL_SYNTAX);
  }
}
