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
 * 表示实体已被锁定的异常。
 *
 * @author 胡海星
 */
public class EntityLockedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3093538447692567629L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link EntityLockedException} 对象。
   *
   * @param entityType
   *     被锁定实体的类对象。
   * @param key
   *     用于标识被锁定实体的键的名称。
   * @param value
   *     用于标识被锁定实体的键的值。
   */
  public EntityLockedException(final Class<?> entityType,
      final String key, final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityLockedException} 对象。
   *
   * @param entity
   *     被锁定实体的名称。
   * @param key
   *     用于标识被锁定实体的键的名称。
   * @param value
   *     用于标识被锁定实体的键的值。
   */
  public EntityLockedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.LOCKED, new KeyValuePair("entity", entity),
        new KeyValuePair("key", getFieldName(key)),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取被锁定实体的名称。
   *
   * @return
   *     被锁定实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识被锁定实体的键的名称。
   *
   * @return
   *     用于标识被锁定实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识被锁定实体的键的值。
   *
   * @return
   *     用于标识被锁定实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
