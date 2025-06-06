////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

/**
 * 抛出此异常表示需要经过App认证才能访问指定的功能。
 *
 * @author 胡海星
 */
public class AppAuthenticationRequiredException extends BusinessLogicException {

  private static final long serialVersionUID = 999001183481586466L;

  /**
   * 构造一个 {@link AppAuthenticationRequiredException} 对象。
   */
  public AppAuthenticationRequiredException() {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.APP_AUTHENTICATION_REQUIRED);
  }
}
