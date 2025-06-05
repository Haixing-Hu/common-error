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
 * 表示用户名格式无效的异常。
 *
 * @author 胡海星
 */
public class InvalidUsernameFormatException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -1543906267261960741L;

  private final String requirement;
  private final int minLength;
  private final int maxLength;

  /**
   * 使用指定的格式要求、最小长度和最大长度构造一个
   * {@link InvalidUsernameFormatException} 对象。
   *
   * @param requirement
   *     对用户名格式的描述性要求。
   * @param minLength
   *     用户名的最小长度。
   * @param maxLength
   *     用户名的最大长度。
   */
  public InvalidUsernameFormatException(final String requirement,
      final int minLength, final int maxLength) {
    super(ErrorCode.INVALID_USERNAME_FORMAT);
    this.requirement = requirement;
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.addParam("requirement", requirement);
    this.addParam("min_length", minLength);
    this.addParam("max_length", maxLength);
  }

  /**
   * 获取对用户名格式的描述性要求。
   *
   * @return 对用户名格式的描述性要求。
   */
  public String getRequirement() {
    return requirement;
  }

  /**
   * 获取用户名的最小长度。
   *
   * @return 用户名的最小长度。
   */
  public int getMinLength() {
    return minLength;
  }

  /**
   * 获取用户名的最大长度。
   *
   * @return 用户名的最大长度。
   */
  public int getMaxLength() {
    return maxLength;
  }
}
