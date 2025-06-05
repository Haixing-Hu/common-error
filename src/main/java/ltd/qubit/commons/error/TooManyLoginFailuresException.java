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

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示用户登录失败次数过多的异常。
 *
 * @author 胡海星
 */
public class TooManyLoginFailuresException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -885058974515170735L;

  private final String username;
  private final long duration;

  /**
   * 使用指定的用户名和锁定持续时间构造一个 {@link TooManyLoginFailuresException} 对象。
   *
   * @param username
   *     登录失败次数过多的用户名。
   * @param durationSeconds
   *     账户被锁定的持续时间，单位为秒。
   */
  public TooManyLoginFailuresException(final String username, final long durationSeconds) {
    super(ErrorType.AUTHENTICATION_ERROR,
        ErrorCode.TOO_MANY_LOGIN_FAILURES,
        new KeyValuePair("username", username),
        new KeyValuePair("duration", durationSeconds));
    this.username  = username;
    this.duration = durationSeconds;
  }

  /**
   * 获取登录失败次数过多的用户名。
   *
   * @return 登录失败次数过多的用户名。
   */
  public final String getUsername() {
    return username;
  }

  /**
   * 获取账户被锁定的持续时间。
   *
   * @return 账户被锁定的持续时间，单位为秒。
   */
  public long getDuration() {
    return duration;
  }
}
