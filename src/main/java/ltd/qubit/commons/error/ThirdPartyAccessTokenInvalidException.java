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
 * 表示调用第三方服务的访问令牌不正确。
 *
 * @author 胡海星
 */
public class ThirdPartyAccessTokenInvalidException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = -3019980777893906230L;

  private final String accessToken;

  public ThirdPartyAccessTokenInvalidException(final String accessToken) {
    super(ErrorCode.THIRD_PARTY_ACCESS_TOKEN_INVALID,
        new KeyValuePair("access_token", accessToken));
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
