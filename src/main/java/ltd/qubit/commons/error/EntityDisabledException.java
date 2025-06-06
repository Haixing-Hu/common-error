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
 * 表示实体已被禁用的异常。
 *
 * @author 胡海星
 */
public class EntityDisabledException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2209357679589045163L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类、键和值构造一个 {@link EntityDisabledException} 对象。
   *
   * @param entityType
   *     被禁用的实体的类对象。
   * @param key
   *     用于标识被禁用的实体的键的名称。
   * @param value
   *     用于标识被禁用的实体的键的值。
   */
  public EntityDisabledException(final Class<?> entityType,
      final String key, final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityDisabledException} 对象。
   *
   * @param entity
   *     被禁用的实体的名称。
   * @param key
   *     用于标识被禁用的实体的键的名称。
   * @param value
   *     用于标识被禁用的实体的键的值。
   */
  private EntityDisabledException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.DISABLED);
    this.entity = entity;
    this.key = key;
    this.value = value;
    this.addParam("entity", entity);
    this.addParam("key", key);
    this.addParam("value", value);
  }

  /**
   * 获取被禁用的实体的名称。
   *
   * @return 被禁用的实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识被禁用的实体的键的名称。
   *
   * @return 用于标识被禁用的实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识被禁用的实体的键的值。
   *
   * @return 用于标识被禁用的实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
