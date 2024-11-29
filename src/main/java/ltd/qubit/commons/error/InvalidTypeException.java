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
 * 表示实体类型错误。
 *
 * @author Haixing Hu
 */
public class InvalidTypeException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -123788747327732451L;

  private final String entity;
  private final String expectedType;
  private final String actualType;

  public InvalidTypeException(final Class<?> entityType,
      final Enum<?> expectedType, final Enum<?> actualType) {
    this(getEntityName(entityType), expectedType.name(), actualType.name());
  }

  private InvalidTypeException(final String entity, final String expectedType,
      final String actualType) {
    super(ErrorCode.INVALID_TYPE);
    this.entity = entity;
    this.expectedType = expectedType;
    this.actualType = actualType;
    this.addParam("entity", entity);
    this.addParam("expected_type", expectedType);
    this.addParam("actual_type", actualType);
  }

  public final String getEntity() {
    return entity;
  }

  public final String getExpectedType() {
    return expectedType;
  }

  public final String getActualType() {
    return actualType;
  }
}
