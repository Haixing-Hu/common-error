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
 * Thrown to indicates the session has expired.
 *
 * @author Haixing Hu
 */
public class SessionExpiredException  extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 3646435083629016975L;

  private final String entity;

  /**
   * Constructs a {@link SessionExpiredException} with the specified entity class.
   *
   * @param entityClass
   *     the class of the entity whose session has expired.
   */
  public SessionExpiredException(final Class<?> entityClass) {
    super(ErrorType.AUTHENTICATION_ERROR, ErrorCode.SESSION_EXPIRED);
    this.entity = getEntityName(entityClass);
    this.addParam("entity", this.entity);
  }

  public String getEntity() {
    return entity;
  }
}
