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
 * 表示应用的访问令牌错误。
 *
 * @author Haixing Hu
 */
public class InvalidAccessTokenException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 1104426671154959092L;

  private final String entity;

  private final String token;

  public InvalidAccessTokenException(final Class<?> entity, final String token) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.INVALID_TOKEN);
    this.entity = getEntityName(entity);
    this.token = token;
    this.addParam("entity", this.entity);
    this.addParam("token", token);
  }

  public String getEntity() {
    return entity;
  }

  public String getToken() {
    return token;
  }
}
