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
 * @author 胡海星
 */
public class InvalidAccessTokenException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 1104426671154959092L;

  private final String entity;

  private final String token;

  /**
   * 使用指定的实体类和令牌构造一个 {@link InvalidAccessTokenException} 对象。
   *
   * @param entity
   *     访问令牌所属的实体的类对象。
   * @param token
   *     无效的访问令牌。
   */
  public InvalidAccessTokenException(final Class<?> entity, final String token) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.INVALID_TOKEN);
    this.entity = getEntityName(entity);
    this.token = token;
    this.addParam("entity", this.entity);
    this.addParam("token", token);
  }

  /**
   * 获取访问令牌所属的实体的名称。
   *
   * @return 访问令牌所属的实体的名称 (通常是 lower_underscore 格式)。
   */
  public String getEntity() {
    return entity;
  }

  /**
   * 获取无效的访问令牌。
   *
   * @return 无效的访问令牌。
   */
  public String getToken() {
    return token;
  }
}
