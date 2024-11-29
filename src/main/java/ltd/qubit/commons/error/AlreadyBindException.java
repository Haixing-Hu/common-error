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

import javax.annotation.Nullable;

import ltd.qubit.commons.reflect.FieldUtils;
import ltd.qubit.commons.reflect.impl.GetterMethod;

/**
 * 表示指定的对象已绑定了另一个指定的对象。
 *
 * @author 胡海星
 */
public class AlreadyBindException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 3370461319845255402L;

  private final String entity;
  private final String key;
  private final Object value;
  @Nullable
  private final String targetEntity;
  @Nullable
  private final String targetKey;
  @Nullable
  private final Object targetValue;

  private AlreadyBindException(final String entity, final String key,
      final Object value, @Nullable final String targetEntity,
      @Nullable final String targetKey, @Nullable final Object targetValue) {
    super(ErrorCode.ALREADY_BIND);
    this.entity = entity;
    this.key = key;
    this.value = value;
    this.targetEntity = targetEntity;
    this.targetKey = targetKey;
    this.targetValue = targetValue;
    this.addParam("entity", entity);
    this.addParam("key", key);
    this.addParam("value", value);
    this.addParam("target_entity", targetEntity);
    this.addParam("target_key", targetKey);
    this.addParam("target_value", targetValue);
  }

  public AlreadyBindException(final Class<?> entityType, final String key,
      final Object value, final  Class<?> targetEntityType, final String targetKey,
      final Object targetValue) {
    this(getEntityName(entityType), getFieldName(key), value,
        getEntityName(targetEntityType), getFieldName(targetKey), targetValue);
  }

  public AlreadyBindException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value, null, null, null);
  }

  public <T, P> AlreadyBindException(final Class<T> entityType,
      final GetterMethod<T, P> keyGetter, final P keyValue) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter), keyValue,
        null, null, null);
  }

  public <T1, P1, T2, P2> AlreadyBindException(final Class<T1> entityType,
      final GetterMethod<T1, P1> keyGetter, final P1 keyValue,
      final Class<T2> targetEntityType,
      final GetterMethod<T2, P2> targetKeyGetter, final P2 targetKeyValue) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter), keyValue,
        targetEntityType, FieldUtils.getFieldName(targetEntityType, targetKeyGetter),
        targetKeyValue);
  }

  @SuppressWarnings("unchecked")
  public <T, P> AlreadyBindException(final T obj, final GetterMethod<T, P> keyGetter) {
    this(obj.getClass(),
        FieldUtils.getFieldName((Class<T>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj), null, null, null);
  }

  @SuppressWarnings("unchecked")
  public <T1, P1, T2, P2> AlreadyBindException(final T1 obj,
      final GetterMethod<T1, P1> keyGetter,
      final T2 targetObj,
      final GetterMethod<T2, P2> targetKeyGetter) {
    this(obj.getClass(),
        FieldUtils.getFieldName((Class<T1>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj),
        targetObj.getClass(),
        FieldUtils.getFieldName((Class<T2>) targetObj.getClass(), targetKeyGetter),
        targetKeyGetter.invoke(targetObj));
  }

  public String getEntity() {
    return entity;
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }

  @Nullable
  public String getTargetEntity() {
    return targetEntity;
  }

  @Nullable
  public String getTargetKey() {
    return targetKey;
  }

  @Nullable
  public Object getTargetValue() {
    return targetValue;
  }
}
