////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.reflect.FieldUtils;
import ltd.qubit.commons.reflect.impl.GetterMethod;
import ltd.qubit.model.person.User;

/**
 * 表示指定的用户不存在。
 *
 * @author Haixing Hu
 */
public class UserNotExistException extends DataNotExistException {

  private static final long serialVersionUID = -3981649814276525676L;

  public UserNotExistException(final String key, final Object value) {
    super(User.class, key, value);
  }

  public <T, P> UserNotExistException(final Class<T> type,
      final GetterMethod<T, P> getter, final P value) {
    this(FieldUtils.getFieldName(type, getter), value);
  }
}
