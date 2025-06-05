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
 * 此错误表示对消息编码时失败。
 *
 * @author 胡海星
 */
public class EncodingMessageException extends ServerInternalException {

  @Serial
  private static final long serialVersionUID = 8426242742998906287L;

  private final String reason;

  /**
   * 构造一个 {@link EncodingMessageException} 对象。
   */
  public EncodingMessageException() {
    this("");
  }

  /**
   * 使用指定的错误消息构造一个 {@link EncodingMessageException} 对象。
   *
   * @param message
   *     描述编码错误的详细消息。
   */
  public EncodingMessageException(final String message) {
    super(ErrorCode.ENCODING_MESSAGE_FAILED);
    this.reason = message;
    this.addParam("reason", message);
  }

  /**
   * 使用指定的根本原因构造一个 {@link EncodingMessageException} 对象。
   *
   * @param e
   *     编码错误的根本原因。
   */
  public EncodingMessageException(final Throwable e) {
    this(e.getMessage());
  }

  /**
   * 获取描述编码错误原因的字符串。
   *
   * @return 描述编码错误原因的字符串。
   */
  public String getReason() {
    return reason;
  }
}
