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
 * Thrown to indicate that the file format is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidFileFormatException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -3517828093133105010L;

  private final String reason;

  public InvalidFileFormatException() {
    this("");
  }

  public InvalidFileFormatException(final String message) {
    super(ErrorType.IO_ERROR, ErrorCode.INVALID_FILE_FORMAT);
    this.reason = message;
    this.addParam("reason", message);
  }

  public String getReason() {
    return reason;
  }
}
