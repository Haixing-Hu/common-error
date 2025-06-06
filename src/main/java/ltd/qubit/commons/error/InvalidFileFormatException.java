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
 * 表示文件格式无效的异常。
 *
 * @author 胡海星
 */
public class InvalidFileFormatException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -3517828093133105010L;

  private final String reason;

  /**
   * 构造一个 {@link InvalidFileFormatException} 对象。
   */
  public InvalidFileFormatException() {
    this("");
  }

  /**
   * 使用指定的原由构造一个 {@link InvalidFileFormatException} 对象。
   *
   * @param reason
   *     描述文件格式无效原因的字符串。
   */
  public InvalidFileFormatException(final String reason) {
    super(ErrorType.IO_ERROR,
        ErrorCode.INVALID_FILE_FORMAT,
        new KeyValuePair("reason", reason));
    this.reason = reason;
  }

  /**
   * 获取描述文件格式无效原因的字符串。
   *
   * @return 描述文件格式无效原因的字符串。
   */
  public String getReason() {
    return reason;
  }
}
