////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * An exception thrown to indicate the authentication failed too many times.
 *
 * @author Haixing Hu
 */
public class TooManyAuthenticationFailuresException extends
    ServerSideException {

  private static final long serialVersionUID = -885058974515170735L;

  private final String entity;
  private final String key;
  private final Object value;
  private final long waitSeconds;

  public TooManyAuthenticationFailuresException(final Class<?> entityType,
      final String key, final Object value, final long waitSeconds) {
    super(ErrorType.AUTHENTICATION_ERROR,
        ErrorCode.TOO_MANY_AUTHENTICATION_FAILURES,
        new KeyValuePair("entity", getEntityName(entityType)),
        new KeyValuePair("key", getFieldName(key)),
        new KeyValuePair("value", value),
        new KeyValuePair("duration", waitSeconds));
    this.entity = getEntityName(entityType);
    this.key = getFieldName(key);
    this.value = value;
    this.waitSeconds = waitSeconds;
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

  public long getWaitSeconds() {
    return waitSeconds;
  }
}
