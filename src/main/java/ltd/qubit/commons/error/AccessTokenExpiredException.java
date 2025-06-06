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
 * @author 胡海星
 */
public class AccessTokenExpiredException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3711402466521132328L;

  private final String entity;
  private final String token;

  /**
   * 构造一个 {@link AccessTokenExpiredException}。
   *
   * @param entityType
   *     拥有访问令牌的实体的类型。
   * @param token
   *     已过期的访问令牌。
   */
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

  /**
   * 获取拥有访问令牌的实体的名字。
   *
   * @return
   *     拥有访问令牌的实体的名字。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取已过期的访问令牌。
   *
   * @return
   *     已过期的访问令牌。
   */
  public String getToken() {
    return token;
  }
}
