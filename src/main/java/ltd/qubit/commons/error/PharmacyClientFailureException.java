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
 * 表示药房系统连接失败的异常。
 *
 * @author 胡海星
 */
public class PharmacyClientFailureException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7326367718128234245L;

  private final String reason;

  public PharmacyClientFailureException(final String reason) {
    super(ErrorCode.PHARMACY_CLIENT_FAILURE,
        new KeyValuePair("reason", reason));
    this.reason = reason;
  }

  public String getReason() {
    return reason;
  }
}