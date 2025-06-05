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
 * 表示安全密钥不匹配的异常。
 *
 * @author 胡海星
 */
public class SecurityKeyMismatchException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 6497054624698434844L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link SecurityKeyMismatchException} 对象。
   *
   * @param entityType
   *     相关实体的类对象。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   */
  public SecurityKeyMismatchException(final Class<?> entityType,
      final String key, final Object value) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.SECURITY_KEY_MISMATCH,
        new KeyValuePair("entity", getEntityName(entityType)),
        new KeyValuePair("key", getFieldName(key)),
        new KeyValuePair("value", value));
    this.entity = getEntityName(entityType);
    this.key = key;
    this.value = value;
  }

  /**
   * 使用指定的对象和键的getter方法构造一个 {@link SecurityKeyMismatchException} 对象。
   *
   * @param obj
   *     相关的实体对象。
   * @param keyGetter
   *     用于从实体对象获取键值的getter方法。
   * @param <T>
   *     实体对象的类型。
   * @param <P>
   *     实体对象键值的类型。
   */
  public <T, P> SecurityKeyMismatchException(final T obj,
      final GetterMethod<T, P> keyGetter) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.SECURITY_KEY_MISMATCH);
    @SuppressWarnings("unchecked")
    final Class<T> cls = (Class<T>) obj.getClass();
    final String keyName = FieldUtils.getFieldName(cls, keyGetter);
    final P keyValue = keyGetter.invoke(obj);
    this.entity = getEntityName(cls);
    this.key = getFieldName(keyName);
    this.value = keyValue;
    this.setParams(new KeyValuePair("entity",entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
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
}
