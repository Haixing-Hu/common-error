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
  private static final long serialVersionUID = 5922714183999391937L;

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
   * @param reason
   *     描述编码错误的详细消息。
   */
  public EncodingMessageException(final String reason) {
    super(ErrorCode.ENCODING_MESSAGE_FAILED);
    this.reason = reason;
    this.addParam("reason", reason);
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