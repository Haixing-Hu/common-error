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
 * 表示该操作是不必要的异常。
 *
 * @author 胡海星
 */
public class UnnecessaryOperationException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7506298572264317714L;

  private final String entity;

  private final String operation;

  public UnnecessaryOperationException(final Class<?> entityClass, final String operation) {
    super(ErrorCode.UNNECESSARY_OPERATION,
        new KeyValuePair("entity", getEntityName(entityClass)),
        new KeyValuePair("operation", operation));
    this.entity = getEntityName(entityClass);
    this.operation = operation;
  }

  public UnnecessaryOperationException(final String entity, final String operation) {
    super(ErrorCode.UNNECESSARY_OPERATION,
        new KeyValuePair("entity", entity),
        new KeyValuePair("operation", operation));
    this.entity = entity;
    this.operation = operation;
  }

  public String getEntity() {
    return entity;
  }

  public String getOperation() {
    return operation;
  }
}