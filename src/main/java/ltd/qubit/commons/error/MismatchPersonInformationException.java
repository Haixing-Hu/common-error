////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.util.ArrayList;
import java.util.List;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.Field;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.person.Person;

public class MismatchPersonInformationException extends BusinessLogicException {

  private static final long serialVersionUID = 4393486077067411366L;

  private final Person expected;
  private final Person actual;

  public MismatchPersonInformationException(final Person expected,
      final Person actual) {
    super(ErrorCode.INVALID_ORDER, makeParams(expected, actual));
    this.expected = expected;
    this.actual = expected;
  }

  public Person getExpected() {
    return expected;
  }

  public Person getActual() {
    return actual;
  }

  private static KeyValuePair[] makeParams(final Person expected,
      final Person actual) {
    final List<KeyValuePair> params = new ArrayList<>();
    params.add(new KeyValuePair(Field.FULLNAME, expected.getName()));
    params.add(new KeyValuePair(Field.FULLNAME, actual.getName()));
    if (expected.getCredential() != null) {
      final CredentialInfo credential = expected.getCredential();
      params.add(new KeyValuePair(Field.CREDENTIAL_TYPE, credential.getType().name()));
      params.add(new KeyValuePair(Field.CREDENTIAL_NUMBER, credential.getNumber()));
    }
    return params.toArray(new KeyValuePair[0]);
  }
}
