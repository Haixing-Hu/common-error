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
 * @author Haixing Hu
 */
public class MismatchCredentialException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -8875450249518109891L;

  private final String name;
  private final CredentialInfo expected;
  private final CredentialInfo actual;

  public MismatchCredentialException(final String name,
      final Credential expected, final Credential actual) {
    this(name, expected.getInfo(), actual.getInfo());
  }

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

  public String getName() {
    return name;
  }

  public CredentialInfo getExpected() {
    return expected;
  }

  public CredentialInfo getActual() {
    return actual;
  }

  public CredentialType getExpectedCredentialType() {
    return expected.getType();
  }

  public String getExpectedCredentialNumber() {
    return expected.getNumber();
  }

  public CredentialType getActualCredentialType() {
    return actual.getType();
  }

  public String getActualCredentialNumber() {
    return actual.getNumber();
  }
}
