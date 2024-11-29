////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.CredentialType;
import ltd.qubit.model.person.Gender;

/**
 * 表示性别不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchGenderException extends BusinessLogicException {

  private static final long serialVersionUID = -7285953695851149215L;

  private final CredentialInfo credential;
  private final Gender expectedGender;
  private final Gender actualGender;

  public MismatchGenderException(final CredentialInfo credential,
      final Gender expectedGender, final Gender actualGender) {
    super(ErrorCode.MISMATCH_GENDER);
    this.credential = credential;
    this.expectedGender = expectedGender;
    this.actualGender = actualGender;
    this.addParam("credential_type", credential.getType());
    this.addParam("credential_number", credential.getNumber());
    this.addParam("expected_gender", expectedGender);
    this.addParam("actual_gender", actualGender);
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

  public Gender getExpectedGender() {
    return expectedGender;
  }

  public Gender getActualGender() {
    return actualGender;
  }
}
