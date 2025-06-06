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
 * 表示处方没有找到可供货药店的异常。
 *
 * @author 胡海星
 */
public class PrescriptionCannotFindSellerException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7037048076157118425L;

  private final Long prescriptionId;

  public PrescriptionCannotFindSellerException(final Long prescriptionId) {
    super(ErrorCode.PRESCRIPTION_CANNOT_FIND_SELLER,
        new KeyValuePair("prescription_id", prescriptionId));
    this.prescriptionId = prescriptionId;
  }

  public Long getPrescriptionId() {
    return prescriptionId;
  }
}