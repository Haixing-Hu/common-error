/// /////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.io.Serial;

/**
 * 表示调用第三方服务的访问令牌不正确。
 *
 * @author 胡海星
 */
public class ThirdPartyAccessTokenInvalidException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = -3019980777893906230L;

  /**
   * 构造一个 {@link ThirdPartyAccessTokenInvalidException} 对象。
   */
  public ThirdPartyAccessTokenInvalidException() {
    super(ErrorCode.THIRD_PARTY_ACCESS_TOKEN_INVALID);
  }

  /**
   * 使用指定的错误消息构造一个 {@link ThirdPartyAccessTokenInvalidException} 对象。
   *
   * @param message
   *     指定的错误消息。
   */
  public ThirdPartyAccessTokenInvalidException(final String message) {
    super(ErrorCode.THIRD_PARTY_ACCESS_TOKEN_INVALID, message);
  }
}
