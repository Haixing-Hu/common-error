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
 * Thrown to indicate an entity was marked as failed.
 *
 * @author Haixing Hu
 */
public class EntityCompletedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7304656020521042047L;

  private final String entity;
  private final String key;
  private final Object value;

  public EntityCompletedException(final Class<?> entityClass,
      final String key, final Object value) {
    this(getEntityName(entityClass), key, value);
  }

  public <T, R> EntityCompletedException(final Class<T> entityClass,
      final T object, final GetterMethod<T, R> getter) {
    this(getEntityName(entityClass), FieldUtils.getFieldName(entityClass, getter),
        getter.invoke(object));
  }

  public EntityCompletedException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.ENTITY_COMPLETED, new KeyValuePair("entity", entity),
        new KeyValuePair("key", getFieldName(key)),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = getFieldName(key);
    this.value = value;
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
