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
 * 表示字段值无效的异常。
 *
 * @author 胡海星
 */
public class InvalidFieldValueException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -9185610086465952665L;

  private final String field;
  private final Object value;

  /**
   * 使用指定的属性名称和无效值构造一个 {@link InvalidFieldValueException} 对象。
   *
   * @param property
   *     值无效的字段的属性名称 (通常是 lowerCamelCase 格式)。
   * @param value
   *     无效的字段值。
   */
  public InvalidFieldValueException(final String property, final Object value) {
    super(ErrorCode.INVALID_FIELD_VALUE);
    this.field = getFieldName(property);
    this.value = value;
    this.addParam("field", this.field);
    this.addParam("value", this.value);
  }

  /**
   * 获取值无效的字段的名称。
   *
   * @return 值无效的字段的名称 (通常是 lower_underscore 格式)。
   */
  public String getField() {
    return field;
  }

  /**
   * 获取无效的字段值。
   *
   * @return 无效的字段值。
   */
  public Object getValue() {
    return value;
  }

}
