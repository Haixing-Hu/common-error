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
 * @author 胡海星
 */
public class MismatchBirthdayException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8602724557924252098L;

  private final CredentialInfo credential;
  private final LocalDate expectedBirthday;
  private final LocalDate actualBirthday;

  /**
   * 使用指定的证件信息、预期生日和实际生日构造一个 {@link MismatchBirthdayException} 对象。
   *
   * @param credential
   *     发生生日不匹配的证件信息。
   * @param expectedBirthday
   *     预期的生日。
   * @param actualBirthday
   *     实际的生日。
   */
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

  /**
   * 获取发生生日不匹配的证件信息。
   *
   * @return 发生生日不匹配的证件信息。
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
   * 获取预期的生日。
   *
   * @return 预期的生日。
   */
  public LocalDate getExpectedBirthday() {
    return expectedBirthday;
  }

  /**
   * 获取实际的生日。
   *
   * @return 实际的生日。
   */
  public LocalDate getActualBirthday() {
    return actualBirthday;
  }
}
