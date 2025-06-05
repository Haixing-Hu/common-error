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
 * 表示执行操作的权限被拒绝的异常。
 *
 * @author 胡海星
 */
public class OperationForbiddenException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -5998273591305882106L;

  private final String operation;
  private final String entity;

  private OperationForbiddenException(final String operation,
          @Nullable final String entity) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.OPERATION_FORBIDDEN);
    this.operation = operation;
    this.entity = entity;
    this.addParam("operation", operation);
    this.addParam("entity", entity);
  }

  private OperationForbiddenException(final String operation,
      @Nullable final String entity, final KeyValuePair ... params) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.OPERATION_FORBIDDEN);
    this.operation = operation;
    this.entity = entity;
    this.addParam("operation", operation);
    this.addParam("entity", entity);
    this.addParams(params);
  }

  /**
   * 使用指定的操作名称和实体类型构造一个 {@link OperationForbiddenException} 对象。
   *
   * @param operation
   *     被禁止的操作的名称 (通常是 UPPER_UNDERSCORE 格式)。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   */
  public OperationForbiddenException(final String operation,
      @Nullable final Class<?> entityType) {
    this(getOperationName(operation), getEntityName(entityType));
  }

  /**
   * 使用指定的操作名称、实体类型和附加参数构造一个 {@link OperationForbiddenException} 对象。
   *
   * @param operation
   *     被禁止的操作的名称 (通常是 UPPER_UNDERSCORE 格式)。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   * @param params
   *     与此异常相关的附加参数。
   */
  public OperationForbiddenException(final String operation,
      @Nullable final Class<?> entityType, final KeyValuePair ... params) {
    this(getOperationName(operation), getEntityName(entityType), params);
  }

  /**
   * 使用指定的操作枚举和实体类型构造一个 {@link OperationForbiddenException} 对象。
   *
   * @param operation
   *     被禁止的操作的枚举常量。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   * @param <O>
   *     操作枚举的类型。
   */
  public <O extends Enum<O>> OperationForbiddenException(final O operation,
      @Nullable final Class<?> entityType) {
    this(getOperationName(operation.name()), getEntityName(entityType));
  }

  /**
   * 使用指定的操作枚举、实体类型和附加参数构造一个 {@link OperationForbiddenException} 对象。
   *
   * @param operation
   *     被禁止的操作的枚举常量。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   * @param params
   *     与此异常相关的附加参数。
   * @param <O>
   *     操作枚举的类型。
   */
  public <O extends Enum<O>> OperationForbiddenException(final O operation,
      @Nullable final Class<?> entityType, final KeyValuePair ... params) {
    this(getOperationName(operation.name()), getEntityName(entityType), params);
  }

  /**
   * 获取被禁止的操作的名称。
   *
   * @return 被禁止的操作的名称 (通常是 lower_underscore 格式)。
   */
  public String getOperation() {
    return operation;
  }

  /**
   * 获取操作相关的实体名称。
   *
   * @return 实体名称 (通常是 lower_underscore 格式)，如果未指定则为 null。
   */
  public final String getEntity() {
    return entity;
  }
}
