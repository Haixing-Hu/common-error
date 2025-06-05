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
import java.sql.SQLException;

import javax.annotation.Nullable;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 用于指示服务器端数据库错误的异常。
 * <p>
 * 此异常包装了一个 {@link SQLException}，并且可以在不声明方法签名的情况下抛出。
 *
 * @author 胡海星
 */
public class ServerSideDatabaseException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -7756366273738562547L;

  private final SQLException cause;

  /**
   * 使用指定的 {@link SQLException} 作为根本原因构造一个
   * {@link ServerSideDatabaseException} 对象。
   *
   * @param cause
   *     作为此异常根本原因的 {@link SQLException}。
   */
  public ServerSideDatabaseException(final SQLException cause) {
    super(ErrorType.DATABASE_ERROR, ErrorCode.DATABASE_ERROR,
        new KeyValuePair("message", cause.getMessage()));
    this.cause = cause;
  }

  /**
   * 使用指定的错误消息构造一个 {@link ServerSideDatabaseException} 对象。
   *
   * @param message
   *     指定的错误消息。
   */
  public ServerSideDatabaseException(final String message) {
    super(ErrorType.DATABASE_ERROR, ErrorCode.DATABASE_ERROR,
        new KeyValuePair("message", message));
    this.cause = new SQLException(message);
  }

  /**
   * 返回此异常的原因。
   *
   * @return 此异常的 {@link SQLException} 原因；如果原因不存在或未知，则返回 {@code null}。
   */
  @Nullable
  @Override
  public SQLException getCause() {
    return cause;
  }
}
