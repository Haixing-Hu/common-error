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
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.commons.Credential;

/**
 * 表示证件不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchCredentialException extends BusinessLogicException {

  private static final long serialVersionUID = -8875450249518109891L;

  private final String name;
  private final Credential expected;
  private final Credential actual;

  public MismatchCredentialException(final String name,
      final Credential expected, final Credential actual) {
    super(ErrorCode.MISMATCH_CREDENTIAL, makeParams(name, expected, actual));
    this.name = name;
    this.expected = expected;
    this.actual = actual;
  }

  public String getName() {
    return name;
  }

  public Credential getExpected() {
    return expected;
  }

  public Credential getActual() {
    return actual;
  }

  private static KeyValuePair[] makeParams(final String name,
          final Credential expected, final Credential actual) {
    final KeyValuePairList params = new KeyValuePairList();
    params.add("name", name)
          .add("expected_credential_type", expected.getType())
          .add("expected_credential_number", expected.getNumber())
          .add("actual_credential_type", actual.getType())
          .add("actual_credential_number", actual.getNumber());
    return params.toArray(new KeyValuePair[0]);
  }
}
