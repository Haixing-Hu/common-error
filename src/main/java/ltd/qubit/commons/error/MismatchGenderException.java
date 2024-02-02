////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.person.Gender;

/**
 * 表示性别不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchGenderException extends BusinessLogicException {

  private static final long serialVersionUID = -7285953695851149215L;

  private final CredentialInfo credential;
  private final Gender expected;
  private final Gender actual;

  public MismatchGenderException(final CredentialInfo credential, final Gender expected,
          final Gender actual) {
    super(ErrorCode.MISMATCH_GENDER,
        new KeyValuePair("credential_type", credential.getType()),
        new KeyValuePair("credential_number", credential.getNumber()),
        new KeyValuePair("expected_gender", expected),
        new KeyValuePair("actual_gender", actual));
    this.credential = credential;
    this.expected = expected;
    this.actual = actual;
  }

  public CredentialInfo getCredential() {
    return credential;
  }

  public Gender getExpected() {
    return expected;
  }

  public Gender getActual() {
    return actual;
  }
}
