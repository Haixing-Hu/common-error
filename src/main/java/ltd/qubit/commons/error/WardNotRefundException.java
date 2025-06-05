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

  /**
   * 使用指定的被监护人对象构造一个 {@link WardNotRefundException} 对象。
   *
   * @param guarded
   *     未退款的被监护人对象。
   */
  public WardNotRefundException(final Person guarded) {
    super(ErrorCode.WARD_NOT_REFUND);
    this.ward = guarded;
    this.addParam("ward_name", guarded.getName());
    final CredentialInfo credential = guarded.getCredential();
    this.addParam("ward_credential_type", (credential == null ? null : credential.getType()));
    this.addParam("ward_credential_number", (credential == null ? null : credential.getNumber()));
    this.addParam("ward_birthday", guarded.getBirthday());
  }

  /**
   * 获取未退款的被监护人对象。
   *
   * @return 未退款的被监护人对象。
   */
  public Person getWard() {
    return ward;
  }

  /**
   * 获取未退款的被监护人的姓名。
   *
   * @return 未退款的被监护人的姓名。
   */
  public String getWardName() {
    return ward.getName();
  }

  /**
   * 获取未退款的被监护人的证件类型。
   *
   * @return 未退款的被监护人的证件类型字符串，如果证件信息不存在则返回 null。
   */
  public String getWardCredentialType() {
    final CredentialInfo credential = ward.getCredential();
    return (credential == null ? null : StringUtils.toString(credential.getType()));
  }

  /**
   * 获取未退款的被监护人的证件号码。
   *
   * @return 未退款的被监护人的证件号码，如果证件信息不存在则返回 null。
   */
  public String getWardCredentialNumber() {
    final CredentialInfo credential = ward.getCredential();
    return (credential == null ? null : credential.getNumber());
  }

  /**
   * 获取未退款的被监护人的生日字符串。
   *
   * @return 未退款的被监护人的生日字符串，格式为 yyyy-MM-dd。
   */
  public String getWardBirthday() {
    return LocalDateUtils.toString(ward.getBirthday());
  }
}
