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
 * 表示要修改的实体是只读的异常。
 * 
 * @author 胡海星
 */
public class ReadonlyEntityException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5742840366996760375L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link ReadonlyEntityException} 对象。
   *
   * @param entityType
   *     只读实体的类对象。
   * @param key
   *     用于标识只读实体的键的名称。
   * @param value
   *     用于标识只读实体的键的值。
   */
  public ReadonlyEntityException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link ReadonlyEntityException} 对象。
   *
   * @param entity
   *     只读实体的名称。
   * @param key
   *     用于标识只读实体的键的名称。
   * @param value
   *     用于标识只读实体的键的值。
   */
  private ReadonlyEntityException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.READONLY,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取只读实体的名称。
   *
   * @return 只读实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识只读实体的键的名称。
   *
   * @return 用于标识只读实体的键的名称。
   */
  public String getKey() {
    return key;
  }

  /**
   * 获取用于标识只读实体的键的值。
   *
   * @return 用于标识只读实体的键的值。
   */
  public Object getValue() {
    return value;
  }
}
