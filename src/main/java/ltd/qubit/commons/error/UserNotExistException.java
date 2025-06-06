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

import ltd.qubit.commons.reflect.FieldUtils;
import ltd.qubit.commons.reflect.impl.GetterMethod;
import ltd.qubit.model.person.User;

/**
 * 表示指定的用户不存在。
 *
 * @author 胡海星
 */
public class UserNotExistException extends DataNotExistException {

  @Serial
  private static final long serialVersionUID = -8666989228083592763L;

  /**
   * 使用指定的键和值构造一个 {@link UserNotExistException} 对象。
   *
   * @param key
   *     用于标识用户的键的名称。
   * @param value
   *     用于标识用户的键的值。
   */
  public UserNotExistException(final String key, final Object value) {
    super(User.class, key, value);
  }

  /**
   * 使用指定的类、getter方法和值构造一个 {@link UserNotExistException} 对象。
   *
   * @param type
   *     用户的类对象。
   * @param getter
   *     用于从用户对象获取键值的getter方法。
   * @param value
   *     用于标识用户的键的值。
   * @param <T>
   *     用户对象的类型。
   * @param <P>
   *     用户对象键值的类型。
   */
  public <T, P> UserNotExistException(final Class<T> type,
      final GetterMethod<T, P> getter, final P value) {
    this(FieldUtils.getFieldName(type, getter), value);
  }
}