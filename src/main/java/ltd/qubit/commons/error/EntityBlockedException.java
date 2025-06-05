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
 * 表示实体被屏蔽的异常。
 *
 * @author 胡海星
 */
public class EntityBlockedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -1108519606772346395L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link EntityBlockedException} 对象。
   *
   * @param entityType
   *     被屏蔽的实体的类对象。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   */
  public EntityBlockedException(final Class<?> entityType,
      final String key, final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityBlockedException} 对象。
   *
   * @param entity
   *     被屏蔽的实体的名称。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   */
  public EntityBlockedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.BLOCKED, new KeyValuePair("entity", entity),
        new KeyValuePair("key", getFieldName(key)),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取被屏蔽的实体的名称。
   *
   * @return 被屏蔽的实体的名称 (通常是 lower_underscore 格式)。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识实体的键的名称。
   *
   * @return 用于标识实体的键的名称 (通常是 lower_underscore 格式)。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识实体的键的值。
   *
   * @return 用于标识实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
