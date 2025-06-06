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
 * 表示用户对某个实体的投诉已存在的异常。
 *
 * @author 胡海星
 */
public class ComplaintExistException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8973718969343993164L;

  private final String entity;

  public ComplaintExistException(final String entity) {
    super(ErrorCode.COMPLAINT_EXIST,
        new KeyValuePair("entity", entity));
    this.entity = entity;
  }

  public String getEntity() {
    return entity;
  }
}