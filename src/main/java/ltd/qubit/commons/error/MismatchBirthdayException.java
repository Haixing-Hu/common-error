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
import java.time.LocalDate;

import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.CredentialType;

/**
 * 表示生日不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchBirthdayException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8602724557924252098L;

  private final CredentialInfo credential;
  private final LocalDate expectedBirthday;
  private final LocalDate actualBirthday;

  public MismatchBirthdayException(final CredentialInfo credential,
      final LocalDate expectedBirthday, final LocalDate actualBirthday) {
    super(ErrorCode.MISMATCH_BIRTHDAY);
    this.credential = credential;
    this.expectedBirthday = expectedBirthday;
    this.actualBirthday = actualBirthday;
    this.addParam("credential_type", credential.getType());
    this.addParam("credential_number", credential.getNumber());
    this.addParam("expected_birthday", expectedBirthday);
    this.addParam("actual_birthday", actualBirthday);
  }

  public CredentialInfo getCredential() {
    return credential;
  }

  public CredentialType getCredentialType() {
    return credential.getType();
  }

  public String getCredentialNumber() {
    return credential.getNumber();
  }

  public LocalDate getExpectedBirthday() {
    return expectedBirthday;
  }

  public LocalDate getActualBirthday() {
    return actualBirthday;
  }
}
