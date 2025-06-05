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

import ltd.qubit.commons.reflect.FieldUtils;
import ltd.qubit.commons.reflect.impl.GetterMethod;
import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 用于指示实体已被标记为已完成的异常。
 *
 * @author 胡海星
 */
public class EntityCompletedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7304656020521042047L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类、键和值构造一个 {@link EntityCompletedException} 对象。
   *
   * @param entityClass
   *     已完成的实体的类对象。
   * @param key
   *     用于标识已完成实体的键的名称。
   * @param value
   *     用于标识已完成实体的键的值。
   */
  public EntityCompletedException(final Class<?> entityClass,
      final String key, final Object value) {
    this(getEntityName(entityClass), key, value);
  }

  /**
   * 使用指定的实体类、对象和getter方法构造一个 {@link EntityCompletedException} 对象。
   *
   * @param entityClass
   *     已完成的实体的类对象。
   * @param object
   *     已完成的实体对象。
   * @param getter
   *     用于从实体对象获取键值的getter方法。
   * @param <T>
   *     实体对象的类型。
   * @param <R>
   *     实体对象键值的类型。
   */
  public <T, R> EntityCompletedException(final Class<T> entityClass,
      final T object, final GetterMethod<T, R> getter) {
    this(getEntityName(entityClass), FieldUtils.getFieldName(entityClass, getter),
        getter.invoke(object));
  }

  /**
   * 使用指定的实体名称、键和值构造一个 {@link EntityCompletedException} 对象。
   *
   * @param entity
   *     已完成的实体的名称。
   * @param key
   *     用于标识已完成实体的键的名称。
   * @param value
   *     用于标识已完成实体的键的值。
   */
  public EntityCompletedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.ENTITY_COMPLETED, new KeyValuePair("entity", entity),
        new KeyValuePair("key", getFieldName(key)),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = getFieldName(key);
    this.value = value;
  }

  /**
   * 获取已完成的实体的名称。
   *
   * @return 已完成的实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识已完成实体的键的名称。
   *
   * @return 用于标识已完成实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识已完成实体的键的值。
   *
   * @return 用于标识已完成实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
