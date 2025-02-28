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
 * 表示第三方服务的访问令牌已过期的异常。
 *
 * @author 胡海星
 */
public class ThirdPartyAccessTokenExpiredException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = -7118847823013943097L;

  public ThirdPartyAccessTokenExpiredException() {
    super(ErrorCode.THIRD_PARTY_ACCESS_TOKEN_EXPIRED);
  }

  public ThirdPartyAccessTokenExpiredException(final String message) {
    super(ErrorCode.THIRD_PARTY_ACCESS_TOKEN_EXPIRED, message);
  }
}
