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
 * The exception thrown to indicate the mismatch of password.
 *
 * @author Haixing Hu
 */
public class SecurityKeyMismatchException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 6497054624698434844L;

  private final String entity;
  private final String key;
  private final Object value;

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

  public String getEntity() {
    return entity;
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }
}
