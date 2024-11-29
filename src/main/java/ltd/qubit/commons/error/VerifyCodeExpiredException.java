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
 * An exception thrown to indicate the expiration of verify code.
 *
 * @author Haixing Hu
 */
public class VerifyCodeExpiredException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3445682897108257543L;

  public VerifyCodeExpiredException() {
    super(ErrorCode.VERIFY_CODE_EXPIRED);
  }

}
