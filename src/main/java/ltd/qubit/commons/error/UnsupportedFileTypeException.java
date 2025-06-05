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
 * 表示不支持指定文件类型的异常。
 *
 * @author 胡海星
 */
public class UnsupportedFileTypeException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 44405759363592068L;

  private final String contentType;

  /**
   * 使用指定的内容类型构造一个 {@link UnsupportedFileTypeException} 对象。
   *
   * @param contentType
   *     不被支持的内容类型字符串。
   */
  public UnsupportedFileTypeException(final String contentType) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.UNSUPPORTED_FILE_TYPE);
    this.contentType = contentType;
    this.addParam("content_type", contentType);
  }

  /**
   * 获取不被支持的内容类型。
   *
   * @return 不被支持的内容类型字符串。
   */
  public String getContentType() {
    return contentType;
  }
}
