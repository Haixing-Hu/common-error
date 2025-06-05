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

/**
 * 表示监护人是其自身的异常。
 *
 * @author 胡海星
 */
public class GuardianIsSelfException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8864150248009427606L;

  private final Long id;
  private final String name;
  private final CredentialInfo credential;

  /**
   * 使用指定的ID、姓名和证件信息构造一个 {@link GuardianIsSelfException} 对象。
   *
   * @param id
   *     将自己设置为监护人的人的ID。
   * @param name
   *     将自己设置为监护人的人的姓名。
   * @param credential
   *     将自己设置为监护人的人的证件信息。
   */
  public GuardianIsSelfException(final Long id, final String name,
      final CredentialInfo credential) {
    super(ErrorCode.GUARDIAN_IS_SELF);
    this.id = id;
    this.name = name;
    this.credential = credential;
    this.addParam("id", id);
    this.addParam("name", name);
    this.addParam("credential_type", credential.getType());
    this.addParam("credential_number", credential.getNumber());
  }

  /**
   * 获取将自己设置为监护人的人的ID。
   *
   * @return 将自己设置为监护人的人的ID。
   */
  public Long getId() {
    return id;
  }

  /**
   * 获取将自己设置为监护人的人的姓名。
   *
   * @return 将自己设置为监护人的人的姓名。
   */
  public String getName() {
    return name;
  }

  /**
   * 获取将自己设置为监护人的人的证件信息。
   *
   * @return 将自己设置为监护人的人的证件信息。
   */
  public CredentialInfo getCredential() {
    return credential;
  }

  /**
   * 获取证件类型字符串。
   *
   * @return 证件类型字符串。
   */
  public String getCredentialType() {
    return StringUtils.toString(credential.getType());
  }

  /**
   * 获取证件号码。
   *
   * @return 证件号码。
   */
  public String getCredentialNumber() {
    return credential.getNumber();
  }
}
