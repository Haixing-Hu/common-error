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
 * 用于指示实体已被标记为已删除的异常。
 *
 * @author 胡海星
 */
public class EntityDeletedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 4862483627407054307L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类、getter方法和值构造一个 {@link EntityDeletedException} 对象。
   *
   * @param entityType
   *     被删除的实体的类对象。
   * @param getter
   *     用于从实体对象获取键值的getter方法。
   * @param value
   *     用于标识被删除的实体的键的值。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  public <T, P> EntityDeletedException(final Class<T> entityType,
      final GetterMethod<T, P> getter, final P value) {
    this(entityType, FieldUtils.getFieldName(entityType, getter), value);
  }

  /**
   * 使用指定的实体类、键和值构造一个 {@link EntityDeletedException} 对象。
   *
   * @param entityType
   *     被删除的实体的类对象。
   * @param key
   *     用于标识被删除的实体的键的名称。
   * @param value
   *     用于标识被删除的实体的键的值。
   */
  public EntityDeletedException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  private EntityDeletedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.DELETED,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取被删除的实体的名称。
   *
   * @return 被删除的实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识被删除的实体的键的名称。
   *
   * @return 用于标识被删除的实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识被删除的实体的键的值。
   *
   * @return 用于标识被删除的实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
