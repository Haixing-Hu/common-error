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

/**
 * 预约单删除异常。
 *
 * @author 王佳
 */
public class AppointmentCannotDeleteException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 3104633352054555682L;

  public AppointmentCannotDeleteException() {
    super(ErrorCode.APPOINTMENT_CANNOT_DELETE);
  }
}
