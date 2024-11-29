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
 * An exception thrown to indicate the permission of the operation was denied.
 *
 * @author Haixing Hu
 */
public class OperationForbiddenException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -5998273591305882106L;

  private final String operation;
  private final String entity;

  private OperationForbiddenException(final String operation,
          @Nullable final String entity) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.OPERATION_FORBIDDEN);
    this.operation = operation;
    this.entity = entity;
    this.addParam("operation", operation);
    this.addParam("entity", entity);
  }

  private OperationForbiddenException(final String operation,
      @Nullable final String entity, final KeyValuePair ... params) {
    super(ErrorType.AUTHORIZATION_ERROR, ErrorCode.OPERATION_FORBIDDEN);
    this.operation = operation;
    this.entity = entity;
    this.addParam("operation", operation);
    this.addParam("entity", entity);
    this.addParams(params);
  }

  public OperationForbiddenException(final String operation,
      @Nullable final Class<?> entityType) {
    this(getOperationName(operation), getEntityName(entityType));
  }

  public OperationForbiddenException(final String operation,
      @Nullable final Class<?> entityType, final KeyValuePair ... params) {
    this(getOperationName(operation), getEntityName(entityType), params);
  }

  public <O extends Enum<O>> OperationForbiddenException(final O operation,
      @Nullable final Class<?> entityType) {
    this(getOperationName(operation.name()), getEntityName(entityType));
  }

  public <O extends Enum<O>> OperationForbiddenException(final O operation,
      @Nullable final Class<?> entityType, final KeyValuePair ... params) {
    this(getOperationName(operation.name()), getEntityName(entityType), params);
  }

  public String getOperation() {
    return operation;
  }

  public final String getEntity() {
    return entity;
  }
}
