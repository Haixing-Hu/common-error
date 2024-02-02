////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示应用的访问令牌错误。
 *
 * @author Haixing Hu
 */
public class InvalidAccessTokenException extends ServerSideException {

  private static final long serialVersionUID = 1104426671154959092L;

  private final Class<?> entityType;

  private final String token;

  public InvalidAccessTokenException(final Class<?> entityType, final String token) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.INVALID_TOKEN,
        new KeyValuePair("entity", getEntityName(entityType)),
        new KeyValuePair("token", token));
    this.entityType = entityType;
    this.token = token;
  }

  public Class<?> getEntityType() {
    return entityType;
  }

  public String getToken() {
    return token;
  }
}
