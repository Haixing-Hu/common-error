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
 * 表示应用的访问令牌已过期。
 *
 * @author Haixing Hu
 */
public class AccessTokenExpiredException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3711402466521132328L;

  private final String entity;
  private final String token;

  public AccessTokenExpiredException(final Class<?> entityType, final String token) {
    this(getEntityName(entityType), token);
  }

  private AccessTokenExpiredException(final String entity, final String token) {
    super(ErrorType.AUTHENTICATION_ERROR,
        ErrorCode.TOKEN_EXPIRED,
        new KeyValuePair("entity", entity),
        new KeyValuePair("token", token));
    this.entity = entity;
    this.token = token;
  }

  public String getEntity() {
    return entity;
  }

  public String getToken() {
    return token;
  }
}
