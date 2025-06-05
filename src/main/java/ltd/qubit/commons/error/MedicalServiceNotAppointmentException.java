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
 * 医疗服务项目未预约。
 *
 * @author 胡海星
 */
public class MedicalServiceNotAppointmentException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 1796296442775916389L;

  /**
   * 构造一个 {@link MedicalServiceNotAppointmentException} 对象。
   */
  public MedicalServiceNotAppointmentException() {
    super(ErrorCode.MEDICAL_SERVICE_NOT_APPOINTMENT);
  }
}
