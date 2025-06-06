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
 * 表示键重复的异常。
 *
 * @author 胡海星
 */
public class DuplicateKeyException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8047771735232234641L;

  private final String field;
  private final String value;

  /**
   * 使用指定的字段和值构造一个 {@link DuplicateKeyException} 对象。
   *
   * @param field
   *     重复键的字段名。
   * @param value
   *     重复键的值。
   */
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

  /**
   * 获取重复键的字段名。
   *
   * @return 重复键的字段名。
   */
  public String getField() {
    return field;
  }

  /**
   * 获取重复键的值。
   *
   * @return 重复键的值。
   */
  public String getValue() {
    return value;
  }
}
