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
 * 表示聊天服务器发生错误。
 *
 * @author 胡海星
 */
public class ChatServerError extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -4992332815374171121L;

  private final String reason;

  public ChatServerError(final String reason) {
    super(ErrorType.SERVER_ERROR, ErrorCode.CHAT_SERVER_ERROR);
    this.addParam("reason", reason);
    this.reason = reason;
  }

  public String getReason() {
    return reason;
  }
}
