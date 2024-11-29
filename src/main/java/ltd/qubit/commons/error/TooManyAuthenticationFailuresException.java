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
 * An exception thrown to indicate the authentication failed too many times.
 *
 * @author Haixing Hu
 */
public class TooManyAuthenticationFailuresException extends
    ServerSideException {

  @Serial
  private static final long serialVersionUID = -885058974515170735L;

  private final String entity;
  private final String key;
  private final Object value;
  private final long duration;

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

  public String getEntity() {
    return entity;
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }

  public long getDuration() {
    return duration;
  }
}
