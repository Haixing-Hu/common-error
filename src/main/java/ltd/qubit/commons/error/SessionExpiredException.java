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
 * 表示会话已过期的异常。
 *
 * @author 胡海星
 */
public class SessionExpiredException  extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 3646435083629016975L;

  private final String entity;

  /**
   * 使用指定的实体类构造一个 {@link SessionExpiredException} 对象。
   *
   * @param entityClass
   *     会话已过期的实体的类对象。
   */
  public SessionExpiredException(final Class<?> entityClass) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.SESSION_EXPIRED);
    this.entity = getEntityName(entityClass);
    this.addParam("entity", this.entity);
  }

  /**
   * 获取会话已过期的实体的名称。
   *
   * @return 会话已过期的实体的名称。
   */
  public String getEntity() {
    return entity;
  }
}
