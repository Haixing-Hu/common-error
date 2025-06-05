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

import ltd.qubit.model.commons.Credential;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.CredentialType;

/**
 * 表示证件不匹配。
 *
 * @author 胡海星
 */
public class MismatchCredentialException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -8875450249518109891L;

  private final String name;
  private final CredentialInfo expected;
  private final CredentialInfo actual;

  /**
   * 使用指定的名称、预期证件和实际证件构造一个 {@link MismatchCredentialException} 对象。
   *
   * @param name
   *     发生证件不匹配的实体的名称或描述。
   * @param expected
   *     预期的证件。
   * @param actual
   *     实际的证件。
   */
  public MismatchCredentialException(final String name,
      final Credential expected, final Credential actual) {
    this(name, expected.getInfo(), actual.getInfo());
  }

  /**
   * 使用指定的名称、预期证件信息和实际证件信息构造一个 {@link MismatchCredentialException} 对象。
   *
   * @param name
   *     发生证件不匹配的实体的名称或描述。
   * @param expected
   *     预期的证件信息。
   * @param actual
   *     实际的证件信息。
   */
  public MismatchCredentialException(final String name,
      final CredentialInfo expected, final CredentialInfo actual) {
    super(ErrorCode.MISMATCH_CREDENTIAL);
    this.name = name;
    this.expected = expected;
    this.actual = actual;
    this.addParam("name", name);
    this.addParam("expected_credential_type", expected.getType());
    this.addParam("expected_credential_number", expected.getNumber());
    this.addParam("actual_credential_type", actual.getType());
    this.addParam("actual_credential_number", actual.getNumber());
  }

  /**
   * 获取发生证件不匹配的实体的名称或描述。
   *
   * @return 发生证件不匹配的实体的名称或描述。
   */
  public String getName() {
    return name;
  }

  /**
   * 获取预期的证件信息。
   *
   * @return 预期的证件信息。
   */
  public CredentialInfo getExpected() {
    return expected;
  }

  /**
   * 获取实际的证件信息。
   *
   * @return 实际的证件信息。
   */
  public CredentialInfo getActual() {
    return actual;
  }

  /**
   * 获取预期的证件类型。
   *
   * @return 预期的证件类型。
   */
  public CredentialType getExpectedCredentialType() {
    return expected.getType();
  }

  /**
   * 获取预期的证件号码。
   *
   * @return 预期的证件号码。
   */
  public String getExpectedCredentialNumber() {
    return expected.getNumber();
  }

  /**
   * 获取实际的证件类型。
   *
   * @return 实际的证件类型。
   */
  public CredentialType getActualCredentialType() {
    return actual.getType();
  }

  /**
   * 获取实际的证件号码。
   *
   * @return 实际的证件号码。
   */
  public String getActualCredentialNumber() {
    return actual.getNumber();
  }
}
