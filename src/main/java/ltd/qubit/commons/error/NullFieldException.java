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
import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示字段为空（null）的异常。
 *
 * @author 胡海星
 */
public class NullFieldException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7810826919743040553L;

  private final String field;

  /**
   * 使用指定的属性名称构造一个 {@link NullFieldException} 对象。
   *
   * @param property
   *     为空的属性的名称 (通常是 lowerCamelCase 格式)。
   */
  public NullFieldException(final String property) {
    super(ErrorCode.EMPTY_FIELD, new KeyValuePair("field", getFieldName(property)));
    this.field = getFieldName(property);
  }

  /**
   * 使用指定的类和字段的 getter 方法构造一个 {@link NullFieldException} 对象。
   *
   * @param type
   *     包含空字段的对象的类。
   * @param getter
   *     用于获取空字段值的 getter 方法。
   * @param <T>
   *     包含空字段的对象的类型。
   * @param <P>
   *     空字段的类型。
   */
  public <T, P> NullFieldException(final Class<T> type, final GetterMethod<T, P> getter) {
    this(FieldUtils.getFieldName(type, getter));
  }

  /**
   * 获取为空的字段的名称。
   *
   * @return 为空的字段的名称 (通常是 lower_underscore 格式)。
   */
  public String getField() {
    return field;
  }

}
