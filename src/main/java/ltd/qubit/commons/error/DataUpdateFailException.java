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

import javax.annotation.Nullable;

import org.springframework.dao.NonTransientDataAccessException;

import ltd.qubit.commons.util.pair.KeyValuePairList;

import static ltd.qubit.commons.error.ServerSideException.getTableName;

/**
 * 表示数据更新失败的异常。
 *
 * @author 胡海星
 */
public class DataUpdateFailException extends NonTransientDataAccessException
    implements ErrorInfoConvertable {

  @Serial
  private static final long serialVersionUID = - 7930770879084494863L;

  private final String table;

  private final String reason;

  /**
   * 构造一个 {@link DataUpdateFailException} 对象。
   *
   * @param entityType
   *     更新失败的实体类型。
   */
  public DataUpdateFailException(final Class<?> entityType) {
    this(getTableName(entityType), null);
  }

  /**
   * 构造一个 {@link DataUpdateFailException} 对象。
   *
   * @param entityType
   *     更新失败的实体类型。
   * @param cause
   *     导致更新失败的根本原因。
   */
  public DataUpdateFailException(final Class<?> entityType,
      @Nullable final Throwable cause) {
    this(getTableName(entityType), cause);
  }

  private DataUpdateFailException(final String table,
      @Nullable final Throwable cause) {
    super("Failed to update the database table '" + table
        + (cause == null ? "" : "': " + cause.getMessage()));
    this.table = table;
    this.reason = (cause == null ? "" : "': " + cause.getMessage());
  }

  /**
   * 获取更新失败的表的名称。
   *
   * @return 更新失败的表的名称。
   */
  public String getTable() {
    return table;
  }

  /**
   * 获取更新失败的原因。
   *
   * @return 更新失败的原因。
   */
  public String getReason() {
    return reason;
  }

  @Override
  public ErrorInfo toErrorInfo() {
    return new ErrorInfo(ErrorType.DATABASE_ERROR,
        ErrorCode.DATABASE_ERROR,
        KeyValuePairList.of("table", table, "reason", reason));
  }
}
