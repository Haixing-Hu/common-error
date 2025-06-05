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
 * 表示不支持指定类的异常。
 *
 * @author 胡海星
 */
public class UnsupportedClassException extends ServerInternalException {

  @Serial
  private static final long serialVersionUID = 3558672511597342482L;

  /**
   * 构造一个 {@link UnsupportedClassException} 对象。
   */
  public UnsupportedClassException() {
    super(ErrorCode.UNSUPPORTED_CLASS);
  }

  /**
   * 使用指定的类构造一个 {@link UnsupportedClassException} 对象。
   *
   * @param cls
   *     不被支持的类对象。
   */
  public UnsupportedClassException(final Class<?> cls) {
    super(ErrorCode.UNSUPPORTED_CLASS, new KeyValuePair("class", cls.getName()));
  }

  /**
   * 使用指定的类名构造一个 {@link UnsupportedClassException} 对象。
   *
   * @param className
   *     不被支持的类的名称。
   */
  public UnsupportedClassException(final String className) {
    super(ErrorCode.UNSUPPORTED_CLASS, new KeyValuePair("class", className));
  }
}
