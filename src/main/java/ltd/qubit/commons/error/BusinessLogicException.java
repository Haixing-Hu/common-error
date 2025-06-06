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
 * 此异常类是所有服务器端业务逻辑错误异常类的基类。
 *
 * @author 胡海星
 */
public class BusinessLogicException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 4119326191506464723L;

  /**
   * 使用指定的错误代码和参数构造一个 {@link BusinessLogicException} 对象。
   *
   * @param code
   *     错误代码。
   * @param params
   *     与此错误相关的参数。
   */
  public BusinessLogicException(final ErrorCode code, final KeyValuePair... params) {
    super(ErrorType.LOGIC_ERROR, code, params);
  }

  /**
   * 使用指定的错误类型、错误代码和参数构造一个 {@link BusinessLogicException} 对象。
   *
   * @param type
   *     错误类型。
   * @param code
   *     错误代码。
   * @param params
   *     与此错误相关的参数。
   */
  public BusinessLogicException(final ErrorType type, final ErrorCode code,
      final KeyValuePair... params) {
    super(type, code, params);
  }
}
