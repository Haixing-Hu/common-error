////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import javax.annotation.Nullable;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * The exception to thrown if the user has no privilege to perform the
 * operation.
 *
 * @author Haixing Hu
 */
public class NoPrivilegeException extends ServerSideException {

  private static final long serialVersionUID = 2804481438240205724L;

  private final String operation;
  private final String entity;

  public NoPrivilegeException(final String operation, @Nullable final Class<?> entityType) {
    this(getOperationName(operation), getEntityName(entityType));
  }

  private NoPrivilegeException(final String operation, @Nullable final String entity) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.NO_PRIVILEGE,
        new KeyValuePair("operation", operation),
        new KeyValuePair("entity", entity));
    this.operation = operation;
    this.entity = entity;
  }

  public String getOperation() {
    return operation;
  }

  public final String getEntity() {
    return entity;
  }
}
