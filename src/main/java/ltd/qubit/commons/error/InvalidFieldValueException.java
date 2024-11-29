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
 * The exception thrown to indicate that the value of a field is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidFieldValueException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -9185610086465952665L;

  private final String field;
  private final Object value;

  public InvalidFieldValueException(final String property, final Object value) {
    super(ErrorCode.INVALID_FIELD_VALUE);
    this.field = getFieldName(property);
    this.value = value;
    this.addParam("field", this.field);
    this.addParam("value", this.value);
  }

  /**
   * Gets the field.
   *
   * @return the field.
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the value.
   *
   * @return the value.
   */
  public Object getValue() {
    return value;
  }

}
