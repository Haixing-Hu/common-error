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
 * 表示上传文件过大的异常。
 *
 * @author 胡海星
 */
public class UploadFileTooLargeException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -3914760211691804752L;

  private final Long maxAllowedFileSize;
  private final Long actualFileSize;

  /**
   * 使用允许的最大文件大小和实际文件大小构造一个 {@link UploadFileTooLargeException} 对象。
   *
   * @param maxAllowedFileSize
   *     允许的最大文件大小，单位为字节。如果为 null，则表示没有明确的限制。
   * @param actualFileSize
   *     实际上传的文件大小，单位为字节。如果为 null，则表示未知。
   */
  public UploadFileTooLargeException(final Long maxAllowedFileSize, final Long actualFileSize) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.UPLOAD_FILE_TOO_LARGE);
    this.maxAllowedFileSize = maxAllowedFileSize;
    this.actualFileSize = actualFileSize;
    this.addParam("max_allowed_file_size", maxAllowedFileSize);
    this.addParam("actual_file_size", actualFileSize);
  }

  /**
   * 获取允许的最大文件大小。
   *
   * @return 允许的最大文件大小，单位为字节。可能为 null。
   */
  public Long getMaxAllowedFileSize() {
    return maxAllowedFileSize;
  }

  /**
   * 获取实际上传的文件大小。
   *
   * @return 实际上传的文件大小，单位为字节。可能为 null。
   */
  public Long getActualFileSize() {
    return actualFileSize;
  }
}
