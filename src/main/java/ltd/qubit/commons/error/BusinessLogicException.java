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

  public BusinessLogicException(final ErrorCode code, final KeyValuePair... params) {
    super(ErrorType.LOGIC_ERROR, code, params);
  }

  public BusinessLogicException(final ErrorType type, final ErrorCode code,
      final KeyValuePair... params) {
    super(type, code, params);
  }
}
