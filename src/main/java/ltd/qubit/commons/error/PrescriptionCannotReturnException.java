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

import ltd.qubit.commons.lang.LocalizedEnum;
import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示处方订单不能退货的异常。
 *
 * @author 胡海星
 */
public class PrescriptionCannotReturnException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4674227139992307420L;

  private final Long prescriptionId;

  private final LocalizedEnum prescriptionStatus;

  public PrescriptionCannotReturnException(final Long prescriptionId, final LocalizedEnum prescriptionStatus) {
    super(ErrorCode.PRESCRIPTION_CANNOT_RETURN,
        new KeyValuePair("prescription_id", prescriptionId),
        new KeyValuePair("prescription_status", prescriptionStatus.getLocalizedName()));
    this.prescriptionId = prescriptionId;
    this.prescriptionStatus = prescriptionStatus;
  }

  public Long getPrescriptionId() {
    return prescriptionId;
  }

  public LocalizedEnum getPrescriptionStatus() {
    return prescriptionStatus;
  }
}