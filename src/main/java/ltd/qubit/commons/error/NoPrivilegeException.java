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

import javax.annotation.Nullable;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * The exception to thrown if the user has no privilege to perform the
 * operation.
 *
 * @author Haixing Hu
 */
public class NoPrivilegeException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = 2804481438240205724L;

  private final String operation;
  private final String entity;

  private NoPrivilegeException(final String operation,
      @Nullable final String entity,
      final KeyValuePair[] params) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.NO_PRIVILEGE);
    this.operation = getOperationName(operation);
    this.entity = getEntityName(entity);
    this.addParams(new KeyValuePair("operation", this.operation));
    this.addParams(new KeyValuePair("entity", this.entity));
    this.addParams(params);
  }

  public NoPrivilegeException(final String operation,
      @Nullable final Class<?> entityType) {
    this(operation, entityType, new KeyValuePair[0]);
  }

  public NoPrivilegeException(final String operation,
      @Nullable final Class<?> entityType, final KeyValuePair ... params) {
    this(operation, entityType == null ? null : entityType.getSimpleName(), params);
  }

  public String getOperation() {
    return operation;
  }

  public final String getEntity() {
    return entity;
  }
}
