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
 * 表示实体已被审核，因此无法更改的异常。
 *
 * @author 胡海星
 */
public class EntityReviewedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -724279655142624484L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link EntityReviewedException} 对象。
   *
   * @param entityType
   *     已被审核的实体的类对象。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   */
  public EntityReviewedException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityReviewedException} 对象。
   *
   * @param entity
   *     已被审核的实体的名称。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   */
  public EntityReviewedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.REVIEWED,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取已被审核的实体的名称。
   *
   * @return 已被审核的实体的名称 (通常是 lower_underscore 格式)。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识实体的键的名称。
   *
   * @return 用于标识实体的键的名称 (通常是 lower_underscore 格式)。
   */
  public String getKey() {
    return key;
  }

  /**
   * 获取用于标识实体的键的值。
   *
   * @return 用于标识实体的键的值。
   */
  public Object getValue() {
    return value;
  }
}
