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
 * 表示实体未被删除的异常。
 *
 * @author 胡海星
 */
public class EntityNotDeletedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -731841457686311032L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类、键和值构造一个 {@link EntityNotDeletedException} 对象。
   *
   * @param entityType
   *     未被删除的实体的类对象。
   * @param key
   *     用于标识未被删除的实体的键的名称。
   * @param value
   *     用于标识未被删除的实体的键的值。
   */
  public EntityNotDeletedException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityNotDeletedException} 对象。
   *
   * @param entity
   *     未被删除的实体的名称。
   * @param key
   *     用于标识未被删除的实体的键的名称。
   * @param value
   *     用于标识未被删除的实体的键的值。
   */
  private EntityNotDeletedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.NOT_DELETED,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取未被删除的实体的名称。
   *
   * @return 未被删除的实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识未被删除的实体的键的名称。
   *
   * @return 用于标识未被删除的实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识未被删除的实体的键的值。
   *
   * @return 用于标识未被删除的实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
