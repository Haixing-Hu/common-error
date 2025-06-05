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
 * 表示调用第三方服务产生的异常。
 *
 * @author 胡海星
 */
public class ThirdPartyServiceException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -7165213672754327853L;

  /**
   * 使用指定的根本原因构造一个 {@link ThirdPartyServiceException} 对象。
   *
   * @param e
   *     导致此错误的根本原因。
   */
  public ThirdPartyServiceException(final Throwable e) {
    this(ErrorCode.THIRD_PARTY_SERVICE_FAILURE, e.getMessage());
  }

  /**
   * 使用指定的错误消息构造一个 {@link ThirdPartyServiceException} 对象。
   *
   * @param message
   *     指定的错误消息。
   */
  public ThirdPartyServiceException(final String message) {
    this(ErrorCode.THIRD_PARTY_SERVICE_FAILURE, message);
  }

  /**
   * 使用指定的错误代码和错误消息构造一个 {@link ThirdPartyServiceException} 对象。
   *
   * @param errorCode
   *     错误代码。
   * @param message
   *     错误消息。
   */
  public ThirdPartyServiceException(final ErrorCode errorCode, final String message) {
    super(ErrorType.THIRD_PARTY_ERROR, errorCode, new KeyValuePair("message", message));
  }

  /**
   * 使用指定的错误代码和参数构造一个 {@link ThirdPartyServiceException} 对象。
   *
   * @param errorCode
   *     错误代码。
   * @param params
   *     与此错误相关的参数。
   */
  public ThirdPartyServiceException(final ErrorCode errorCode, final KeyValuePair ... params) {
    super(ErrorType.THIRD_PARTY_ERROR, errorCode, params);
  }
}
