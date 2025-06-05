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
 * 此错误表示消息的数字签名错误。
 *
 * @author 胡海星
 */
public class InvalidSignatureException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 96191141516422229L;

  private final String message;

  private final String signature;

  /**
   * 使用指定的消息和签名构造一个 {@link InvalidSignatureException} 对象。
   *
   * @param message
   *     签名无效的消息。
   * @param signature
   *     无效的签名。
   */
  public InvalidSignatureException(final String message, final String signature) {
    super(ErrorCode.INVALID_SIGNATURE, new KeyValuePair("message", message),
        new KeyValuePair("signature", signature));
    this.message = message;
    this.signature = signature;
  }

  @Override
  public final String getMessage() {
    return message;
  }

  /**
   * 获取无效的签名。
   *
   * @return 无效的签名。
   */
  public final String getSignature() {
    return signature;
  }
}
