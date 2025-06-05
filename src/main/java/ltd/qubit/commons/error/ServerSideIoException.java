////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.io.IOException;
import java.io.Serial;

import javax.annotation.Nullable;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 用于指示服务器端 I/O 错误的异常。
 *
 * <p>此异常包装了一个 {@link IOException}，并且可以在不声明方法签名的情况下抛出。</p>
 *
 * @author 胡海星
 */
public class ServerSideIoException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 476295550047450167L;

  private final IOException cause;

  /**
   * 使用指定的 {@link IOException} 作为根本原因构造一个
   * {@link ServerSideIoException} 对象。
   *
   * @param cause
   *     作为此异常根本原因的 {@link IOException}。
   */
  public ServerSideIoException(final IOException cause) {
    super(ErrorType.IO_ERROR, ErrorCode.IO_ERROR,
        new KeyValuePair("message", cause.getMessage()));
    this.cause = cause;
  }

  /**
   * 使用指定的错误消息构造一个 {@link ServerSideIoException} 对象。
   *
   * @param message
   *     指定的错误消息。
   */
  public ServerSideIoException(final String message) {
    super(ErrorType.IO_ERROR, ErrorCode.IO_ERROR,
        new KeyValuePair("message", message));
    this.cause = new IOException(message);
  }

  /**
   * 返回此异常的原因。
   *
   * @return 此异常的 {@link IOException} 原因；如果原因不存在或未知，则返回 {@code null}。
   */
  @Nullable
  @Override
  public IOException getCause() {
    return cause;
  }
}
