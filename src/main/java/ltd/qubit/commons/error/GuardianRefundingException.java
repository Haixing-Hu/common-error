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
 * 表示监护人正在退款中的异常。
 *
 * @author 胡海星
 */
public class GuardianRefundingException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -269560063857372789L;

  private final PersonInfo guardian;

  /**
   * 使用指定的监护人信息构造一个 {@link GuardianRefundingException} 对象。
   *
   * @param guardian
   *     正在退款中的监护人的信息。
   */
  public GuardianRefundingException(final PersonInfo guardian) {
    super(ErrorCode.GUARDIAN_IS_REFUNDING);
    this.guardian = guardian;
    this.addParam("guardian_name", guardian.getName());
    this.addParam("guardian_mobile", guardian.getMobile());
    final CredentialInfo credential = guardian.getCredential();
    this.addParam("guardian_credential_type", credential == null ? null : credential.getType());
    this.addParam("guardian_credential_number", credential == null ? null : credential.getNumber());
    this.addParam("guardian_birthday", guardian.getBirthday());
  }

  /**
   * 获取正在退款中的监护人的信息。
   *
   * @return 正在退款中的监护人的信息。
   */
  public PersonInfo getGuardian() {
    return guardian;
  }

  /**
   * 获取监护人的姓名。
   *
   * @return 监护人的姓名。
   */
  public String getGuardianName() {
    return guardian.getName();
  }

  /**
   * 获取监护人的手机号码。
   *
   * @return 监护人的手机号码字符串，如果不存在则返回 null。
   */
  public String getGuardianMobile() {
    final Phone mobile = guardian.getMobile();
    return mobile == null ? null : mobile.toString();
  }

  /**
   * 获取监护人的证件类型。
   *
   * @return 监护人的证件类型字符串，如果不存在则返回 null。
   */
  public String getGuardianCredentialType() {
    final CredentialInfo credential = guardian.getCredential();
    return credential == null ? null : StringUtils.toString(credential.getType());
  }

  /**
   * 获取监护人的证件号码。
   *
   * @return 监护人的证件号码，如果不存在则返回 null。
   */
  public String getGuardianCredentialNumber() {
    final CredentialInfo credential = guardian.getCredential();
    return credential == null ? null : credential.getNumber();
  }
}
