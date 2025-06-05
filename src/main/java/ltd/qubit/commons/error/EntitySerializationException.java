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
 * 表示序列化错误的异常。
 *
 * @author 胡海星
 */
public class EntitySerializationException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -4103007173690364857L;

  /**
   * 使用指定的根本原因构造一个 {@link EntitySerializationException} 对象。
   *
   * @param cause
   *     序列化错误的根本原因。
   */
  public EntitySerializationException(final Throwable cause) {
    super(ErrorType.SERVER_ERROR, ErrorCode.SERIALIZATION_ERROR, cause);
  }

  /**
   * 使用指定的错误消息构造一个 {@link EntitySerializationException} 对象。
   *
   * @param message
   *     描述序列化错误的详细消息。
   */
  public EntitySerializationException(final String message) {
    super(ErrorType.SERVER_ERROR, ErrorCode.SERIALIZATION_ERROR,
        new KeyValuePair("message", message));
  }
}
