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

import ltd.qubit.commons.lang.StringUtils;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.contact.Phone;
import ltd.qubit.model.person.PersonInfo;

public class GuardianNotBuyException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -295666385730072789L;

  private final PersonInfo guardian;

  public GuardianNotBuyException(final PersonInfo guardian) {
    super(ErrorCode.GUARDIAN_NOT_BUY);
    this.guardian = guardian;
    this.addParam("guardian_name", guardian.getName());
    this.addParam("guardian_mobile", guardian.getMobile());
    final CredentialInfo credential = guardian.getCredential();
    this.addParam("guardian_credential_type", credential == null ? null : credential.getType());
    this.addParam("guardian_credential_number", credential == null ? null : credential.getNumber());
    this.addParam("guardian_birthday", guardian.getBirthday());
  }

  public PersonInfo getGuardian() {
    return guardian;
  }

  public String getGuardianName() {
    return guardian.getName();
  }

  public String getGuardianMobile() {
    final Phone mobile = guardian.getMobile();
    return mobile == null ? null : mobile.toString();
  }

  public String getGuardianCredentialType() {
    final CredentialInfo credential = guardian.getCredential();
    return credential == null ? null : StringUtils.toString(credential.getType());
  }

  public String getGuardianCredentialNumber() {
    final CredentialInfo credential = guardian.getCredential();
    return credential == null ? null : credential.getNumber();
  }
}
