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
 * 表示实体已被标记为非活动状态的异常。
 *
 * @author 胡海星
 */
public class EntityInactiveException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 170359584234170968L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link EntityInactiveException} 对象。
   *
   * @param entityType
   *     非活动实体的类对象。
   * @param key
   *     用于标识非活动实体的键的名称。
   * @param value
   *     用于标识非活动实体的键的值。
   */
  public EntityInactiveException(final Class<?> entityType,
      final String key, final Object value) {
    this(entityType.getSimpleName(), key, value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityInactiveException} 对象。
   *
   * @param entity
   *     非活动实体的名称。
   * @param key
   *     用于标识非活动实体的键的名称。
   * @param value
   *     用于标识非活动实体的键的值。
   */
  public EntityInactiveException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.INACTIVE);
    this.entity = getEntityName(entity);
    this.key = getFieldName(key);
    this.value = value;
    this.addParam("entity", this.entity);
    this.addParam("key", this.key);
    this.addParam("value", this.value);
  }

  /**
   * 获取非活动实体的名称。
   *
   * @return
   *     非活动实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识非活动实体的键的名称。
   *
   * @return
   *     用于标识非活动实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识非活动实体的键的值。
   *
   * @return
   *     用于标识非活动实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
