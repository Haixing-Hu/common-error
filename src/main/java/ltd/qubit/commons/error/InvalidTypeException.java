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
 * 表示实体类型错误。
 *
 * @author 胡海星
 */
public class InvalidTypeException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -123788747327732451L;

  private final String entity;
  private final String expectedType;
  private final String actualType;

  /**
   * 使用指定的实体类型、预期类型和实际类型构造一个 {@link InvalidTypeException} 对象。
   *
   * @param entityType
   *     发生类型错误的实体的类对象。
   * @param expectedType
   *     预期的类型枚举常量。
   * @param actualType
   *     实际的类型枚举常量。
   */
  public InvalidTypeException(final Class<?> entityType,
      final Enum<?> expectedType, final Enum<?> actualType) {
    this(getEntityName(entityType), expectedType.name(), actualType.name());
  }

  private InvalidTypeException(final String entity, final String expectedType,
      final String actualType) {
    super(ErrorCode.INVALID_TYPE);
    this.entity = entity;
    this.expectedType = expectedType;
    this.actualType = actualType;
    this.addParam("entity", entity);
    this.addParam("expected_type", expectedType);
    this.addParam("actual_type", actualType);
  }

  /**
   * 获取发生类型错误的实体的名称。
   *
   * @return 发生类型错误的实体的名称 (通常是 lower_underscore 格式)。
   */
  public final String getEntity() {
    return entity;
  }

  /**
   * 获取预期的类型名称。
   *
   * @return 预期的类型名称。
   */
  public final String getExpectedType() {
    return expectedType;
  }

  /**
   * 获取实际的类型名称。
   *
   * @return 实际的类型名称。
   */
  public final String getActualType() {
    return actualType;
  }
}
