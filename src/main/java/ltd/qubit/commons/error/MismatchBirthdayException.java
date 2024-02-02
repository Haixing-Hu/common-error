////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.time.LocalDate;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.commons.CredentialInfo;

/**
 * 表示生日不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchBirthdayException extends BusinessLogicException {

  private static final long serialVersionUID = 8602724557924252098L;

  private final CredentialInfo credential;
  private final LocalDate expected;
  private final LocalDate actual;

  public MismatchBirthdayException(final CredentialInfo credential,
      final LocalDate expected, final LocalDate actual) {
    super(ErrorCode.MISMATCH_BIRTHDAY,
        new KeyValuePair("credential_type", credential.getType()),
        new KeyValuePair("credential_number", credential.getNumber()),
        new KeyValuePair("expected_birthday", expected),
        new KeyValuePair("actual_birthday", actual));
    this.credential = credential;
    this.expected = expected;
    this.actual = actual;
  }

  public CredentialInfo getCredential() {
    return credential;
  }

  public LocalDate getExpected() {
    return expected;
  }

  public LocalDate getActual() {
    return actual;
  }
}
