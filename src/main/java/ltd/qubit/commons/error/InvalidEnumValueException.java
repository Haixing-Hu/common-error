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
 * 表示枚举值无效的异常。
 *
 * @author 胡海星
 */
public class InvalidEnumValueException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7802717543992308170L;

  private final String entity;

  private final String value;

  /**
   * 使用指定的枚举类和无效值构造一个 {@link InvalidEnumValueException} 对象。
   *
   * @param enumClass
   *     相关的枚举类。
   * @param value
   *     无效的枚举值字符串。
   */
  public InvalidEnumValueException(final Class<?> enumClass, final String value) {
    super(ErrorCode.INVALID_ENUM_VALUE);
    this.entity = getEntityName(enumClass);
    this.value = value;
    this.addParam("entity", this.entity);
    this.addParam("value", this.value);
  }

  /**
   * 获取相关的枚举类的名称。
   *
   * @return 相关的枚举类的名称 (通常是 lower_underscore 格式)。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取无效的枚举值字符串。
   *
   * @return 无效的枚举值字符串。
   */
  public String getValue() {
    return value;
  }
}
