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
import java.util.HashMap;
import java.util.Map;

import ltd.qubit.commons.reflect.FieldUtils;
import ltd.qubit.commons.reflect.impl.GetterMethod;

/**
 * 表示字段格式无效的异常。
 *
 * @author 胡海星
 */
public class InvalidFieldFormatException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2423251503350099649L;

  private static final Map<String, ErrorCode> ERROR_CODE_MAP;

  static {
    ERROR_CODE_MAP = new HashMap<>();
    // ERROR_CODE_MAP.put("password", ErrorCode.INVALID_PASSWORD_FORMAT);
    // ERROR_CODE_MAP.put("username", ErrorCode.INVALID_USERNAME_FORMAT);
    ERROR_CODE_MAP.put("email", ErrorCode.INVALID_EMAIL_FORMAT);
    ERROR_CODE_MAP.put("mobile", ErrorCode.INVALID_PHONE_FORMAT);
    ERROR_CODE_MAP.put("phone", ErrorCode.INVALID_PHONE_FORMAT);
  }

  private final String field;
  private final Object value;

  /**
   * 使用指定的属性名称和无效值构造一个 {@link InvalidFieldFormatException} 对象。
   *
   * @param property
   *     格式无效的字段的属性名称 (通常是 lowerCamelCase 格式)。
   * @param value
   *     无效的字段值。
   */
  public InvalidFieldFormatException(final String property, final Object value) {
    super(getErrorCode(property));
    this.field = getFieldName(property);
    this.value = value;
    this.addParam("field", this.field);
    this.addParam("value", this.value);
  }

  /**
   * 使用指定的类、字段的 getter 方法和无效值构造一个
   * {@link InvalidFieldFormatException} 对象。
   *
   * @param type
   *     包含格式无效字段的对象的类。
   * @param getter
   *     用于获取字段值的 getter 方法。
   * @param value
   *     无效的字段值。
   * @param <T>
   *     包含格式无效字段的对象的类型。
   * @param <P>
   *     格式无效字段的类型。
   */
  public <T, P> InvalidFieldFormatException(final Class<T> type,
      final GetterMethod<T, P> getter, final P value) {
    this(FieldUtils.getFieldName(type, getter), value);
  }

  private static ErrorCode getErrorCode(final String property) {
    final ErrorCode code = ERROR_CODE_MAP.get(property);
    return (code != null ? code : ErrorCode.INVALID_FIELD_FORMAT);
  }

  /**
   * 获取格式无效的字段的名称。
   *
   * @return 格式无效的字段的名称 (通常是 lower_underscore 格式)。
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
