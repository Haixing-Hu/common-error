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

/**
 * 表示监护人年龄错误。
 *
 * @author 胡海星
 */
public class InvalidGuardianAgeException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -1147861390993501153L;

  private final PersonInfo guardian;

  public InvalidGuardianAgeException(final PersonInfo guardian) {
    super(ErrorCode.INVALID_GUARDIAN_AGE);
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
