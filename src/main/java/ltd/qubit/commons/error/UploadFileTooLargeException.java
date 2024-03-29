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
 * Thrown to indicates the file is too large.
 *
 * @author Haixing Hu
 */
public class UploadFileTooLargeException extends ServerSideException {

  private static final long serialVersionUID = -3914760211691804752L;

  public UploadFileTooLargeException(final Long maxAllowedSize, final Long actualSize) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.UPLOAD_FILE_TOO_LARGE,
        new KeyValuePair("max_allowed_file_size", maxAllowedSize.toString()),
        new KeyValuePair("actual_file_size", actualSize.toString()));
  }
}
