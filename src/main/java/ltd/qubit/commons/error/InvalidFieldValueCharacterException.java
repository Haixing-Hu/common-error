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
 * The exception thrown to indicate that the characters of the value of a field
 * is invalid.
 *
 * @author Haixing Hu
 */
public class InvalidFieldValueCharacterException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 8790807160943844485L;

  private final String field;
  private final String value;

  public InvalidFieldValueCharacterException(final String property, final String value) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.INVALID_FIELD_VALUE_CHARACTER);
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
  public String getValue() {
    return value;
  }

}
