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
 * 表示密码格式无效的异常。
 *
 * @author 胡海星
 */
public class InvalidPasswordFormatException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5267750209553035561L;

  private final String requirement;
  private final int minLength;
  private final int maxLength;

  /**
   * 使用指定的格式要求、最小长度和最大长度构造一个
   * {@link InvalidPasswordFormatException} 对象。
   *
   * @param requirement
   *     对密码格式的描述性要求。
   * @param minLength
   *     密码的最小长度。
   * @param maxLength
   *     密码的最大长度。
   */
  public InvalidPasswordFormatException(final String requirement,
      final int minLength, final int maxLength) {
    super(ErrorCode.INVALID_PASSWORD_FORMAT);
    this.requirement = requirement;
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.addParam("requirement", requirement);
    this.addParam("min_length", minLength);
    this.addParam("max_length", maxLength);
  }

  /**
   * 获取对密码格式的描述性要求。
   *
   * @return 对密码格式的描述性要求。
   */
  public String getRequirement() {
    return requirement;
  }

  /**
   * 获取密码的最小长度。
   *
   * @return 密码的最小长度。
   */
  public int getMinLength() {
    return minLength;
  }

  /**
   * 获取密码的最大长度。
   *
   * @return 密码的最大长度。
   */
  public int getMaxLength() {
    return maxLength;
  }
}
