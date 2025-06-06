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
 * 表示指定的对象已存在。
 *
 * @author 胡海星
 */
public class DataAlreadyExistException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -7946725149423667129L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 构造一个 {@link DataAlreadyExistException} 对象。
   *
   * @param entityType
   *     已存在实体的类对象。
   * @param key
   *     用于标识已存在实体的键的名称。
   * @param value
   *     用于标识已存在实体的键的值。
   */
  public DataAlreadyExistException(final Class<?> entityType, final String key,
      final Object value) {
    this(entityType, key, value, new KeyValuePair[0]);
  }

  /**
   * 构造一个 {@link DataAlreadyExistException} 对象。
   *
   * @param entityType
   *     已存在实体的类对象。
   * @param key
   *     用于标识已存在实体的键的名称。
   * @param value
   *     用于标识已存在实体的键的值。
   * @param params
   *     与此异常相关的附加参数。
   */
  public DataAlreadyExistException(final Class<?> entityType, final String key,
      final Object value, final KeyValuePair... params) {
    super(ErrorCode.ALREADY_EXIST);
    this.entity = getEntityName(entityType);
    this.key = getFieldName(key);
    this.value = value;
    this.addParam(new KeyValuePair("entity", this.entity));
    this.addParam(new KeyValuePair("key", this.key));
    this.addParam(new KeyValuePair("value", this.value));
    this.addParams(params);
  }

  /**
   * 构造一个 {@link DataAlreadyExistException} 对象。
   *
   * @param entityType
   *     已存在实体的类对象。
   * @param keyGetter
   *     用于从实体对象获取键值的 getter 方法。
   * @param value
   *     用于标识已存在实体的键的值。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  public <T, P> DataAlreadyExistException(final Class<T> entityType,
      final GetterMethod<T, P> keyGetter, final P value) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter),
        value, new KeyValuePair[0]);
  }

  /**
   * 构造一个 {@link DataAlreadyExistException} 对象。
   *
   * @param entityType
   *     已存在实体的类对象。
   * @param keyGetter
   *     用于从实体对象获取键值的 getter 方法。
   * @param value
   *     用于标识已存在实体的键的值。
   * @param params
   *     与此异常相关的附加参数。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  public <T, P> DataAlreadyExistException(final Class<T> entityType,
      final GetterMethod<T, P> keyGetter, final P value,
      final KeyValuePair... params) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter),
        value, params);
  }

  /**
   * 构造一个 {@link DataAlreadyExistException} 对象。
   *
   * @param obj
   *     已存在的实体对象。
   * @param keyGetter
   *     用于从实体对象获取键值的 getter 方法。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  @SuppressWarnings("unchecked")
  public <T, P> DataAlreadyExistException(final T obj, final GetterMethod<T, P> keyGetter) {
    this(obj.getClass(),
        FieldUtils.getFieldName((Class<T>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj),
        new KeyValuePair[0]);
  }

  /**
   * 构造一个 {@link DataAlreadyExistException} 对象。
   *
   * @param obj
   *     已存在的实体对象。
   * @param keyGetter
   *     用于从实体对象获取键值的 getter 方法。
   * @param params
   *     与此异常相关的附加参数。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  @SuppressWarnings("unchecked")
  public <T, P> DataAlreadyExistException(final T obj,
      final GetterMethod<T, P> keyGetter, final KeyValuePair... params) {
    this(obj.getClass(), FieldUtils.getFieldName((Class<T>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj), params);
  }

  /**
   * 获取已存在实体的名称。
   *
   * @return 已存在实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识已存在实体的键的名称。
   *
   * @return 用于标识已存在实体的键的名称。
   */
  public final String getKey() {
    return key;
  }

  /**
   * 获取用于标识已存在实体的键的值。
   *
   * @return 用于标识已存在实体的键的值。
   */
  public final Object getValue() {
    return value;
  }
}
