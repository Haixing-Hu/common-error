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

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示用户没有权限执行操作的异常。
 *
 * @author 胡海星
 */
public class NoPrivilegeException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 2804481438240205724L;

  private final String operation;
  private final String entity;

  private NoPrivilegeException(final String operation,
      @Nullable final String entity,
      final KeyValuePair[] params) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.NO_PRIVILEGE);
    this.operation = getOperationName(operation);
    this.entity = getEntityName(entity);
    this.addParams(new KeyValuePair("operation", this.operation));
    this.addParams(new KeyValuePair("entity", this.entity));
    this.addParams(params);
  }

  /**
   * 使用指定的操作和实体类型构造一个 {@link NoPrivilegeException} 对象。
   *
   * @param operation
   *     用户尝试执行的操作的名称。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   */
  public NoPrivilegeException(final String operation,
      @Nullable final Class<?> entityType) {
    this(operation, entityType, new KeyValuePair[0]);
  }

  /**
   * 使用指定的操作、实体类型和附加参数构造一个 {@link NoPrivilegeException} 对象。
   *
   * @param operation
   *     用户尝试执行的操作的名称。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   * @param params
   *     与此异常相关的附加参数。
   */
  public NoPrivilegeException(final String operation,
      @Nullable final Class<?> entityType, final KeyValuePair ... params) {
    this(operation, entityType == null ? null : entityType.getSimpleName(), params);
  }

  /**
   * 获取用户尝试执行的操作的名称。
   *
   * @return 操作的名称。
   */
  public String getOperation() {
    return operation;
  }

  /**
   * 获取操作相关的实体名称。
   *
   * @return 实体名称，如果未指定则为 null。
   */
  public final String getEntity() {
    return entity;
  }
}
