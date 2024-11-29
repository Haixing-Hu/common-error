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

  public EncodingMessageException() {
    this("");
  }

  public EncodingMessageException(final String message) {
    super(ErrorCode.ENCODING_MESSAGE_FAILED);
    this.reason = message;
    this.addParam("reason", message);
  }

  public EncodingMessageException(final Throwable e) {
    this(e.getMessage());
  }

  public String getReason() {
    return reason;
  }
}
