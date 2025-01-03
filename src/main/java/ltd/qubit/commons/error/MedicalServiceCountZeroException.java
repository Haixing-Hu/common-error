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
 * 表示医疗服务项目次数为零。
 *
 * @author pino
 */
public class MedicalServiceCountZeroException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 3846236782286447274L;

  public MedicalServiceCountZeroException() {
    super(ErrorCode.MEDICAL_SERVICE_COUNT_ZERO);
  }

}
