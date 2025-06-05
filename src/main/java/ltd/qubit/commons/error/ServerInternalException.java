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
 * 此错误表示服务器内部错误。
 *
 * @author 胡海星
 */
public class ServerInternalException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 4119326191506464723L;

  /**
   * 使用指定的错误代码和参数构造一个 {@link ServerInternalException} 对象。
   *
   * @param code
   *     错误代码。
   * @param params
   *     与此错误相关的参数。
   */
  public ServerInternalException(final ErrorCode code, final KeyValuePair... params) {
    super(ErrorType.SERVER_ERROR, code, params);
  }

  /**
   * 使用指定的错误代码和根本原因构造一个 {@link ServerInternalException} 对象。
   *
   * @param code
   *     错误代码。
   * @param cause
   *     导致此错误的根本原因。
   */
  public ServerInternalException(final ErrorCode code, final Throwable cause) {
    super(ErrorType.SERVER_ERROR, code, cause);
  }
}
