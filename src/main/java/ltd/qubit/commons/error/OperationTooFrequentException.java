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
 * 表示操作过于频繁的异常。
 *
 * @author 胡海星
 */
public class OperationTooFrequentException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2608014197523974855L;

  private final String operation;
  private final String entity;

  /**
   * 使用指定的操作枚举构造一个 {@link OperationTooFrequentException} 对象。
   *
   * @param operation
   *     过于频繁的操作的枚举常量。
   * @param <E>
   *     操作枚举的类型。
   */
  public <E extends Enum<E>> OperationTooFrequentException(final E operation) {
    this(getOperationName(operation.name()), (String) null);
  }

  /**
   * 使用指定的操作名称构造一个 {@link OperationTooFrequentException} 对象。
   *
   * @param operation
   *     过于频繁的操作的名称 (通常是 UPPER_UNDERSCORE 格式)。
   */
  public OperationTooFrequentException(final String operation) {
    this(getOperationName(operation), (String) null);
  }

  /**
   * 使用指定的操作名称和实体类型构造一个 {@link OperationTooFrequentException} 对象。
   *
   * @param operation
   *     过于频繁的操作的名称 (通常是 UPPER_UNDERSCORE 格式)。
   * @param entityType
   *     操作相关的实体类型，可以为 null。
   */
  public OperationTooFrequentException(final String operation,
      @Nullable final Class<?> entityType) {
    this(getOperationName(operation), getEntityName(entityType));
  }

  private OperationTooFrequentException(final String operation,
          @Nullable final String entity) {
    super(ErrorCode.OPERATION_TOO_FREQUENT,
        new KeyValuePair("operation", operation),
        new KeyValuePair("entity", entity));
    this.operation = operation;
    this.entity = entity;
  }

  /**
   * 获取过于频繁的操作的名称。
   *
   * @return 过于频繁的操作的名称 (通常是 lower_underscore 格式)。
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
