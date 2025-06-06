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
 * 表示由于达到系统限制，无法执行该操作的异常。
 *
 * @author 胡海星
 */
public class LimitationReachedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -5211555151213607048L;

  private final String entity;

  private final String operation;

  private final Integer limit;

  public LimitationReachedException(final Class<?> entityClass, final String operation, final Integer limit) {
    super(ErrorCode.LIMITATION_REACHED,
        new KeyValuePair("entity", getEntityName(entityClass)),
        new KeyValuePair("operation", operation),
        new KeyValuePair("limit", limit));
    this.entity = getEntityName(entityClass);
    this.operation = operation;
    this.limit = limit;
  }

  public LimitationReachedException(final String entity, final String operation, final Integer limit) {
    super(ErrorCode.LIMITATION_REACHED,
      new KeyValuePair("entity", entity),
      new KeyValuePair("operation", operation),
      new KeyValuePair("limit", limit));
    this.entity = entity;
    this.operation = operation;
    this.limit = limit;
  }

  public String getEntity() {
    return entity;
  }

  public String getOperation() {
    return operation;
  }

  public Integer getLimit() {
    return limit;
  }
}