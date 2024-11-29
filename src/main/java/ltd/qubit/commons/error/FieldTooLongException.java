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
 * Thrown to indicate that a field value is too long.
 *
 * @author Haixing Hu
 */
public class FieldTooLongException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 3651542010755649520L;

  private final String field;

  public FieldTooLongException(final String property) {
    super(ErrorCode.FIELD_TOO_LONG);
    this.field = getFieldName(property);
    this.addParam("field", this.field);
  }

  public String getField() {
    return field;
  }
}
