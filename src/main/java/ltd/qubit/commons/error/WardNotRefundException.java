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

import ltd.qubit.commons.lang.LocalDateUtils;
import ltd.qubit.commons.lang.StringUtils;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.person.Person;

/**
 * 表示<b>被监护人</b>未退款。
 *
 * @author 胡海星
 */
public class WardNotRefundException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -295666385733572789L;

  private final Person ward;

  public WardNotRefundException(final Person guarded) {
    super(ErrorCode.WARD_NOT_REFUND);
    this.ward = guarded;
    this.addParam("ward_name", guarded.getName());
    final CredentialInfo credential = guarded.getCredential();
    this.addParam("ward_credential_type", (credential == null ? null : credential.getType()));
    this.addParam("ward_credential_number", (credential == null ? null : credential.getNumber()));
    this.addParam("ward_birthday", guarded.getBirthday());
  }

  public Person getWard() {
    return ward;
  }

  public String getWardName() {
    return ward.getName();
  }

  public String getWardCredentialType() {
    final CredentialInfo credential = ward.getCredential();
    return (credential == null ? null : StringUtils.toString(credential.getType()));
  }

  public String getWardCredentialNumber() {
    final CredentialInfo credential = ward.getCredential();
    return (credential == null ? null : credential.getNumber());
  }

  public String getWardBirthday() {
    return LocalDateUtils.toString(ward.getBirthday());
  }
}
