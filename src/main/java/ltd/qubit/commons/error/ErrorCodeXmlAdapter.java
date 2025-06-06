////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.text.xml.jaxb.EnumXmlAdapter;

/**
 * {@link ErrorCode} 枚举类的 JAXB 适配器。
 *
 * @author 胡海星
 */
public final class ErrorCodeXmlAdapter extends EnumXmlAdapter<ErrorCode> {

  /**
   * 构造一个 {@link ErrorCodeXmlAdapter} 对象。
   */
  public ErrorCodeXmlAdapter() {
    super(ErrorCode.class);
  }
}
