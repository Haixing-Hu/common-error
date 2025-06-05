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
 * 表示实体状态错误。
 *
 * @author 胡海星
 */
public class InvalidStatusException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7935755877026564378L;

  private final String entity;
  private final Class<?> statusClass;
  private final String status;

  /**
   * 使用指定的实体类型和状态枚举构造一个 {@link InvalidStatusException} 对象。
   *
   * @param entityType
   *     具有无效状态的实体的类对象。
   * @param status
   *     无效的状态枚举常量。
   * @param <S>
   *     状态枚举的类型。
   */
  public <S extends Enum<S>> InvalidStatusException(final Class<?> entityType,
      final S status) {
    this(getEntityName(entityType), status.getClass(), status.name());
  }

  private InvalidStatusException(final String entity, final Class<?> statusClass,
      final String status) {
    super(ErrorCode.INVALID_STATUS,
        new KeyValuePair("entity", entity),
        new KeyValuePair("status_class", statusClass.getName()),
        new KeyValuePair("status", status));
    this.entity = getEntityName(entity);
    this.statusClass = statusClass;
    this.status = getFieldName(status);
  }

  /**
   * 获取具有无效状态的实体的名称。
   *
   * @return 具有无效状态的实体的名称 (通常是 lower_underscore 格式)。
   */
  public final String getEntity() {
    return entity;
  }

  /**
   * 获取状态枚举的类对象。
   *
   * @return 状态枚举的类对象。
   */
  public Class<?> getStatusClass() {
    return statusClass;
  }

  /**
   * 获取无效状态的名称。
   *
   * @return 无效状态的名称 (通常是 lower_underscore 格式)。
   */
  public final String getStatus() {
    return status;
  }
}
