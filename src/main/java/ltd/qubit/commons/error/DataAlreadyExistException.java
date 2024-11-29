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

  public DataAlreadyExistException(final Class<?> entityType, final String key,
      final Object value) {
    this(entityType, key, value, new KeyValuePair[0]);
  }

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

  public <T, P> DataAlreadyExistException(final Class<T> entityType,
      final GetterMethod<T, P> keyGetter, final P value) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter),
        value, new KeyValuePair[0]);
  }

  public <T, P> DataAlreadyExistException(final Class<T> entityType,
      final GetterMethod<T, P> keyGetter, final P value,
      final KeyValuePair... params) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter),
        value, params);
  }

  @SuppressWarnings("unchecked")
  public <T, P> DataAlreadyExistException(final T obj, final GetterMethod<T, P> keyGetter) {
    this(obj.getClass(),
        FieldUtils.getFieldName((Class<T>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj),
        new KeyValuePair[0]);
  }

  @SuppressWarnings("unchecked")
  public <T, P> DataAlreadyExistException(final T obj,
      final GetterMethod<T, P> keyGetter, final KeyValuePair... params) {
    this(obj.getClass(), FieldUtils.getFieldName((Class<T>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj), params);
  }

  public String getEntity() {
    return entity;
  }

  public final String getKey() {
    return key;
  }

  public final Object getValue() {
    return value;
  }
}
