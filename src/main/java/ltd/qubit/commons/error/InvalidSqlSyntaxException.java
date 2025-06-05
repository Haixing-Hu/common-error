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
 * 用于指示SQL语法无效的异常。
 *
 * @author 胡海星
 */
public class InvalidSqlSyntaxException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -5151306626067986677L;

  /**
   * 构造一个 {@link InvalidSqlSyntaxException} 对象。
   */
  public InvalidSqlSyntaxException() {
    super(ErrorType.DATABASE_ERROR, ErrorCode.INVALID_SQL_SYNTAX);
  }
}
