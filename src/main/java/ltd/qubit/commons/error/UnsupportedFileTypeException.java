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
 * Thrown to indicate that the attachment type is not supported.
 *
 * @author Haixing Hu
 */
public class UnsupportedFileTypeException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 44405759363592068L;

  private final String contentType;

  public UnsupportedFileTypeException(final String contentType) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.UNSUPPORTED_FILE_TYPE);
    this.contentType = contentType;
    this.addParam("content_type", contentType);
  }

  public String getContentType() {
    return contentType;
  }
}
