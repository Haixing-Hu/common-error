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

/**
 * 表示身份验证失败次数过多的异常。
 *
 * @author 胡海星
 */
public class TooManyAuthenticationFailuresException extends
    ServerSideException {

  @Serial
  private static final long serialVersionUID = -885058974515170735L;

  private final String entity;
  private final String key;
  private final Object value;
  private final long duration;

  /**
   * 使用指定的实体类型、键、值和等待时间构造一个
   * {@link TooManyAuthenticationFailuresException} 对象。
   *
   * @param entityType
   *     相关实体的类对象。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   * @param waitSeconds
   *     需要等待的持续时间，单位为秒。
   */
  public TooManyAuthenticationFailuresException(final Class<?> entityType,
      final String key, final Object value, final long waitSeconds) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.TOO_MANY_AUTHENTICATION_FAILURES);
    this.entity = getEntityName(entityType);
    this.key = getFieldName(key);
    this.value = value;
    this.duration = waitSeconds;
    this.addParam("entity", entity);
    this.addParam("key", key);
    this.addParam("value", value);
    this.addParam("duration", waitSeconds);
  }

  /**
   * 使用指定的对象、键的getter方法和等待时间构造一个
   * {@link TooManyAuthenticationFailuresException} 对象。
   *
   * @param obj
   *     相关的实体对象。
   * @param keyGetter
   *     用于从实体对象获取键值的getter方法。
   * @param waitSeconds
   *     需要等待的持续时间，单位为秒。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  public <T, P> TooManyAuthenticationFailuresException(final T obj,
      final GetterMethod<T, P> keyGetter, final long waitSeconds) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.TOO_MANY_AUTHENTICATION_FAILURES);
    @SuppressWarnings("unchecked")
    final Class<T> cls = (Class<T>) obj.getClass();
    final String keyName = FieldUtils.getFieldName(cls, keyGetter);
    final P keyValue = keyGetter.invoke(obj);
    this.entity = getEntityName(cls);
    this.key = getFieldName(keyName);
    this.value = keyValue;
    this.duration = waitSeconds;
    this.addParam("entity", this.entity);
    this.addParam("key", this.key);
    this.addParam("value", this.value);
    this.addParam("duration", this.duration);
  }

  /**
   * 获取相关实体的名称。
   *
   * @return 相关实体的名称。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识实体的键的名称。
   *
   * @return 用于标识实体的键的名称。
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

  /**
   * 获取需要等待的持续时间。
   *
   * @return 需要等待的持续时间，单位为秒。
   */
  public long getDuration() {
    return duration;
  }
}
