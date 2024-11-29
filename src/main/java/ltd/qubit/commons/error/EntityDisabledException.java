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

/**
 * Thrown to indicate an entity was marked as disabled.
 *
 * @author Haixing Hu
 */
public class EntityDisabledException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2209357679589045163L;

  private final String entity;
  private final String key;
  private final Object value;

  public EntityDisabledException(final Class<?> entityType,
      final String key, final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  private EntityDisabledException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.DISABLED);
    this.entity = entity;
    this.key = key;
    this.value = value;
    this.addParam("entity", entity);
    this.addParam("key", key);
    this.addParam("value", value);
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
