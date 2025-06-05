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
 * 表示字段值过长的异常。
 *
 * @author 胡海星
 */
public class FieldTooLongException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 3651542010755649520L;

  private final String field;

  /**
   * 使用指定的属性名称构造一个 {@link FieldTooLongException} 对象。
   *
   * @param property
   *     值过长的字段的属性名称 (通常是 lowerCamelCase 格式)。
   */
  public FieldTooLongException(final String property) {
    super(ErrorCode.FIELD_TOO_LONG);
    this.field = getFieldName(property);
    this.addParam("field", this.field);
  }

  /**
   * 获取值过长的字段的名称。
   *
   * @return 值过长的字段的名称 (通常是 lower_underscore 格式)。
   */
  public String getField() {
    return field;
  }
}
