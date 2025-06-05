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
 * @author 胡海星
 */
public class MismatchGenderException extends BusinessLogicException {

  private static final long serialVersionUID = -7285953695851149215L;

  private final CredentialInfo credential;
  private final Gender expectedGender;
  private final Gender actualGender;

  /**
   * 使用指定的证件信息、预期性别和实际性别构造一个 {@link MismatchGenderException} 对象。
   *
   * @param credential
   *     发生性别不匹配的证件信息。
   * @param expectedGender
   *     预期的性别。
   * @param actualGender
   *     实际的性别。
   */
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

  /**
   * 获取发生性别不匹配的证件信息。
   *
   * @return 发生性别不匹配的证件信息。
   */
  public CredentialInfo getCredential() {
    return credential;
  }

  /**
   * 获取证件类型。
   *
   * @return 证件类型。
   */
  public CredentialType getCredentialType() {
    return credential.getType();
  }

  /**
   * 获取证件号码。
   *
   * @return 证件号码。
   */
  public String getCredentialNumber() {
    return credential.getNumber();
  }

  /**
   * 获取预期的性别。
   *
   * @return 预期的性别。
   */
  public Gender getExpectedGender() {
    return expectedGender;
  }

  /**
   * 获取实际的性别。
   *
   * @return 实际的性别。
   */
  public Gender getActualGender() {
    return actualGender;
  }
}
