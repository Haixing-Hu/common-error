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
 * An exception thrown to indicate the mismatch of verify code.
 *
 * @author Haixing Hu
 */
public class VerifyCodeMismatchException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -1767662246498278604L;

  public VerifyCodeMismatchException() {
    super(ErrorCode.VERIFY_CODE_MISMATCH);
  }

}
