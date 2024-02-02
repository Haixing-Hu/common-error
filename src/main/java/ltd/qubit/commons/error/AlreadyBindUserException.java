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
 * 表示指定的对象已绑定了某个用户。
 *
 * @author 胡海星
 */
public class AlreadyBindUserException extends BusinessLogicException {

  private static final long serialVersionUID = 3370461319845255402L;

  private final String entity;
  private final String key;
  private final Object value;
  private final String username;

  public AlreadyBindUserException(final Class<?> entityType, final String key,
      final Object value, final String username) {
    this(getEntityName(entityType), getFieldName(key), value, username);
  }

  private AlreadyBindUserException(final String entity, final String key,
      final Object value, final String username) {
    super(ErrorCode.ALREADY_BIND_USER,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value),
        new KeyValuePair("username", username));
    this.entity = entity;
    this.key = key;
    this.value = value;
    this.username = username;
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

  public String getUsername() {
    return username;
  }
}
