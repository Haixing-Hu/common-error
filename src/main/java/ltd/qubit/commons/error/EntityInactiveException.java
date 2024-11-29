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
 * Thrown to indicate an entity was marked as inactive.
 *
 * @author Haixing Hu
 */
public class EntityInactiveException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 170359584234170968L;

  private final String entity;
  private final String key;
  private final Object value;

  public EntityInactiveException(final Class<?> entityType,
      final String key, final Object value) {
    this(entityType.getSimpleName(), key, value);
  }

  public EntityInactiveException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.INACTIVE);
    this.entity = getEntityName(entity);
    this.key = getFieldName(key);
    this.value = value;
    this.addParam("entity", this.entity);
    this.addParam("key", this.key);
    this.addParam("value", this.value);
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
