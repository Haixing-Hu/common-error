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

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param entity
   *     已绑定对象的实体名称。
   * @param key
   *     用于标识已绑定对象的键的名称。
   * @param value
   *     用于标识已绑定对象的键的值。
   * @param targetEntity
   *     被绑定对象的实体名称。
   * @param targetKey
   *     用于标识被绑定对象的键的名称。
   * @param targetValue
   *     用于标识被绑定对象的键的值。
   */
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

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param entityType
   *     已绑定对象的实体类型。
   * @param key
   *     用于标识已绑定对象的键的名称。
   * @param value
   *     用于标识已绑定对象的键的值。
   * @param targetEntityType
   *     被绑定对象的实体类型。
   * @param targetKey
   *     用于标识被绑定对象的键的名称。
   * @param targetValue
   *     用于标识被绑定对象的键的值。
   */
  public AlreadyBindException(final Class<?> entityType, final String key,
      final Object value, final  Class<?> targetEntityType, final String targetKey,
      final Object targetValue) {
    this(getEntityName(entityType), getFieldName(key), value,
        getEntityName(targetEntityType), getFieldName(targetKey), targetValue);
  }

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param entityType
   *     已绑定对象的实体类型。
   * @param key
   *     用于标识已绑定对象的键的名称。
   * @param value
   *     用于标识已绑定对象的键的值。
   */
  public AlreadyBindException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value, null, null, null);
  }

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param entityType
   *     已绑定对象的实体类型。
   * @param keyGetter
   *     用于获取已绑定对象键的getter方法。
   * @param keyValue
   *     已绑定对象的键的值。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  public <T, P> AlreadyBindException(final Class<T> entityType,
      final GetterMethod<T, P> keyGetter, final P keyValue) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter), keyValue,
        null, null, null);
  }

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param entityType
   *     已绑定对象的实体类型。
   * @param keyGetter
   *     用于获取已绑定对象键的getter方法。
   * @param keyValue
   *     已绑定对象的键的值。
   * @param targetEntityType
   *     被绑定对象的实体类型。
   * @param targetKeyGetter
   *     用于获取被绑定对象键的getter方法。
   * @param targetKeyValue
   *     被绑定对象的键的值。
   * @param <T1>
   *     已绑定实体对象的类型。
   * @param <P1>
   *     已绑定实体对象键值的类型。
   * @param <T2>
   *     被绑定实体对象的类型。
   * @param <P2>
   *     被绑定实体对象键值的类型。
   */
  public <T1, P1, T2, P2> AlreadyBindException(final Class<T1> entityType,
      final GetterMethod<T1, P1> keyGetter, final P1 keyValue,
      final Class<T2> targetEntityType,
      final GetterMethod<T2, P2> targetKeyGetter, final P2 targetKeyValue) {
    this(entityType, FieldUtils.getFieldName(entityType, keyGetter), keyValue,
        targetEntityType, FieldUtils.getFieldName(targetEntityType, targetKeyGetter),
        targetKeyValue);
  }

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param obj
   *     已绑定的实体对象。
   * @param keyGetter
   *     用于从实体对象获取键值的getter方法。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  @SuppressWarnings("unchecked")
  public <T, P> AlreadyBindException(final T obj, final GetterMethod<T, P> keyGetter) {
    this(obj.getClass(),
        FieldUtils.getFieldName((Class<T>) obj.getClass(), keyGetter),
        keyGetter.invoke(obj), null, null, null);
  }

  /**
   * 构造一个 {@link AlreadyBindException} 对象。
   *
   * @param obj
   *     已绑定的实体对象。
   * @param keyGetter
   *     用于从已绑定的实体对象获取键值的getter方法。
   * @param targetObj
   *     被绑定的实体对象。
   * @param targetKeyGetter
   *     用于从被绑定的实体对象获取键值的getter方法。
   * @param <T1>
   *     已绑定实体对象的类型。
   * @param <P1>
   *     已绑定实体对象键值的类型。
   * @param <T2>
   *     被绑定实体对象的类型。
   * @param <P2>
   *     被绑定实体对象键值的类型。
   */
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

  /**
   * 获取已绑定对象的实体名称。
   *
   * @return 已绑定对象的实体名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识已绑定对象的键的名称。
   *
   * @return 用于标识已绑定对象的键的名称。
   */
  public String getKey() {
    return key;
  }

  /**
   * 获取用于标识已绑定对象的键的值。
   *
   * @return 用于标识已绑定对象的键的值。
   */
  public Object getValue() {
    return value;
  }

  /**
   * 获取被绑定对象的实体名称。
   *
   * @return 被绑定对象的实体名称。
   */
  @Nullable
  public String getTargetEntity() {
    return targetEntity;
  }

  /**
   * 获取用于标识被绑定对象的键的名称。
   *
   * @return 用于标识被绑定对象的键的名称。
   */
  @Nullable
  public String getTargetKey() {
    return targetKey;
  }

  /**
   * 获取用于标识被绑定对象的键的值。
   *
   * @return 用于标识被绑定对象的键的值。
   */
  @Nullable
  public Object getTargetValue() {
    return targetValue;
  }
}