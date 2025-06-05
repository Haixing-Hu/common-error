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
 * 表示操作的目标是当前用户自身的异常。
 *
 * @author 胡海星
 */
public class TargetIsSelfException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -5348011388689198924L;

  private final String operation;
  private final String entity;

  /**
   * 使用指定的操作名称和实体类型构造一个 {@link TargetIsSelfException} 对象。
   *
   * @param operation
   *     操作的名称。
   * @param entityType
   *     目标实体的类对象。
   */
  public TargetIsSelfException(final String operation, final Class<?> entityType) {
    this(getOperationName(operation), getEntityName(entityType));
  }

  /**
   * 使用指定的操作名称和实体名称构造一个 {@link TargetIsSelfException} 对象。
   *
   * @param operation
   *     操作的名称。
   * @param entity
   *     目标实体的名称。
   */
  private TargetIsSelfException(final String operation, final String entity) {
    super(ErrorCode.TARGET_IS_SELF,
        new KeyValuePair("operation", operation),
        new KeyValuePair("entity", entity));
    this.operation = operation;
    this.entity = entity;
  }

  /**
   * 获取操作的名称。
   *
   * @return 操作的名称。
   */
  public final String getOperation() {
    return operation;
  }

  /**
   * 获取目标实体的名称。
   *
   * @return 目标实体的名称。
   */
  public final String getEntity() {
    return entity;
  }
}
