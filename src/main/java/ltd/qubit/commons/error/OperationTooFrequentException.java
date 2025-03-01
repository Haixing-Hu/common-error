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
 * An exception thrown to indicate the an operation is too frequent.
 *
 * @author Haixing Hu
 */
public class OperationTooFrequentException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2608014197523974855L;

  private final String operation;
  private final String entity;

  public <E extends Enum<E>> OperationTooFrequentException(final E operation) {
    this(getOperationName(operation.name()), (String) null);
  }

  public OperationTooFrequentException(final String operation) {
    this(getOperationName(operation), (String) null);
  }

  public OperationTooFrequentException(final String operation,
      @Nullable final Class<?> entityType) {
    this(getOperationName(operation), getEntityName(entityType));
  }

  private OperationTooFrequentException(final String operation,
          @Nullable final String entity) {
    super(ErrorCode.OPERATION_TOO_FREQUENT,
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
