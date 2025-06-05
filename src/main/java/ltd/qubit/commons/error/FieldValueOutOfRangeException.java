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

import ltd.qubit.commons.reflect.FieldUtils;
import ltd.qubit.commons.reflect.impl.GetterMethod;

/**
 * 表示字段值超出其允许范围的异常。
 *
 * @author 胡海星
 */
public class FieldValueOutOfRangeException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -4510924126536171314L;

  private final String field;

  /**
   * 使用指定的属性名称构造一个 {@link FieldValueOutOfRangeException} 对象。
   *
   * @param property
   *     值超出范围的字段的属性名称 (通常是 lowerCamelCase 格式)。
   */
  public FieldValueOutOfRangeException(final String property) {
    super(ErrorCode.FIELD_OUT_OF_RANGE);
    this.field = getFieldName(property);
    this.addParam("field", this.field);
  }

  /**
   * 使用指定的类和字段的 getter 方法构造一个 {@link FieldValueOutOfRangeException} 对象。
   *
   * @param type
   *     包含值超出范围字段的对象的类。
   * @param getter
   *     用于获取字段值的 getter 方法。
   * @param <T>
   *     包含值超出范围字段的对象的类型。
   * @param <P>
   *     值超出范围字段的类型。
   */
  public <T, P> FieldValueOutOfRangeException(final Class<T> type,
      final GetterMethod<T, P> getter) {
    this(FieldUtils.getFieldName(type, getter));
  }

  /**
   * 获取值超出范围的字段的名称。
   *
   * @return 值超出范围的字段的名称 (通常是 lower_underscore 格式)。
   */
  public String getField() {
    return field;
  }
}
