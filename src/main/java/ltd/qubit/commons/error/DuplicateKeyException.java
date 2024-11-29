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

import ltd.qubit.commons.lang.ObjectUtils;

/**
 * Thrown to indicate a key is duplicated.
 *
 * @author Haixing Hu
 */
public class DuplicateKeyException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8047771735232234641L;

  private final String field;
  private final String value;

  public DuplicateKeyException(final String field, final Object value) {
    super(getErrorCodeImpl(field));
    this.field = getFieldName(field);
    this.value = ObjectUtils.toString(value, null);
    this.addParam("field", this.field);
    this.addParam("value", this.value);
  }

  private static ErrorCode getErrorCodeImpl(final String field) {
    if ("username".equalsIgnoreCase(field)) {
      return ErrorCode.USERNAME_OCCUPIED;
    } else {
      return ErrorCode.DUPLICATE_KEY;
    }
  }

  public String getField() {
    return field;
  }

  public String getValue() {
    return value;
  }
}
