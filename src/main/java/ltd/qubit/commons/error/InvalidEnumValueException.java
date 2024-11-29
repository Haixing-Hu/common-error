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
 * Thrown to indicate that the value of an enumeration is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidEnumValueException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7802717543992308170L;

  private final String entity;

  private final String value;

  public InvalidEnumValueException(final Class<?> enumClass, final String value) {
    super(ErrorCode.INVALID_ENUM_VALUE);
    this.entity = getEntityName(enumClass);
    this.value = value;
    this.addParam("entity", this.entity);
    this.addParam("value", this.value);
  }

  public String getEntity() {
    return entity;
  }

  public String getValue() {
    return value;
  }
}
