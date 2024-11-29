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
 * Thrown to indicates the file is too large.
 *
 * @author Haixing Hu
 */
public class UploadFileTooLargeException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -3914760211691804752L;

  private final Long maxAllowedFileSize;
  private final Long actualFileSize;

  public UploadFileTooLargeException(final Long maxAllowedFileSize, final Long actualFileSize) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.UPLOAD_FILE_TOO_LARGE);
    this.maxAllowedFileSize = maxAllowedFileSize;
    this.actualFileSize = actualFileSize;
    this.addParam("max_allowed_file_size", maxAllowedFileSize);
    this.addParam("actual_file_size", actualFileSize);
  }

  public Long getMaxAllowedFileSize() {
    return maxAllowedFileSize;
  }

  public Long getActualFileSize() {
    return actualFileSize;
  }
}
