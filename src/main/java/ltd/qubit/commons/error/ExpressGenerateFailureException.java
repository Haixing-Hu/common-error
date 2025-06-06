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
 * 表示快递系统调用失败的异常。
 *
 * @author 胡海星
 */
public class ExpressGenerateFailureException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -2514181826276057917L;

  public ExpressGenerateFailureException() {
    super(ErrorCode.EXPRESS_GENERATE_FAILURE);
  }
}