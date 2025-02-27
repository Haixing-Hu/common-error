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

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示第三方服务的访问令牌已过期的异常。
 *
 * @author 胡海星
 */
public class ThirdPartyAccessTokenExpiredException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = -7118847823013943097L;

  private final String accessToken;

  public ThirdPartyAccessTokenExpiredException(final String accessToken) {
    super(ErrorCode.THIRD_PARTY_ACCESS_TOKEN_EXPIRED,
        new KeyValuePair("access_token", accessToken));
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
