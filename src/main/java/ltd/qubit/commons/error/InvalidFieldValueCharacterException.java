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
 * 表示字段值的字符无效的异常。
 *
 * @author 胡海星
 */
public class InvalidFieldValueCharacterException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 8790807160943844485L;

  private final String field;
  private final String value;

  /**
   * 使用指定的属性名称和无效值构造一个
   * {@link InvalidFieldValueCharacterException} 对象。
   *
   * @param property
   *     字符无效的字段的属性名称 (通常是 lowerCamelCase 格式)。
   * @param value
   *     包含无效字符的字段值。
   */
  public InvalidFieldValueCharacterException(final String property, final String value) {
    super(ErrorType.REQUEST_ERROR, ErrorCode.INVALID_FIELD_VALUE_CHARACTER);
    this.field = getFieldName(property);
    this.value = value;
    this.addParam("field", this.field);
    this.addParam("value", this.value);
  }

  /**
   * 获取字符无效的字段的名称。
   *
   * @return 字符无效的字段的名称 (通常是 lower_underscore 格式)。
   */
  public String getField() {
    return field;
  }

  /**
   * 获取包含无效字符的字段值。
   *
   * @return 包含无效字符的字段值。
   */
  public String getValue() {
    return value;
  }

}
