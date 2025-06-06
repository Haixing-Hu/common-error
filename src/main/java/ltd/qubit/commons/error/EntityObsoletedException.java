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
 * 表示实体已被标记为过时的异常。
 *
 * @author 胡海星
 */
public class EntityObsoletedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -4212190211186219958L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link EntityObsoletedException} 对象。
   *
   * @param entityType
   *     过时实体的类对象。
   * @param key
   *     用于标识过时实体的键的名称。
   * @param value
   *     用于标识过时实体的键的值。
   */
  public EntityObsoletedException(final Class<?> entityType,
      final String key, final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  private EntityObsoletedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.OBSOLETED,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取过时实体的名称。
   *
   * @return
   *     过时实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识过时实体的键的名称。
   *
   * @return
   *     用于标识过时实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识过时实体的键的值。
   *
   * @return
   *     用于标识过时实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
