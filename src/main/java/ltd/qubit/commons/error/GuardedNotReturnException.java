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
import ltd.qubit.model.person.Person;

public class GuardedNotReturnException extends BusinessLogicException {

  private static final long serialVersionUID = -295666385733572789L;
  private final Person guarded;

  public GuardedNotReturnException(final Person guarded) {
    super(ErrorCode.GUARDED_NOT_RETURN,
        new KeyValuePair("guarded_name", guarded.getName()),
        new KeyValuePair("guarded_credential_type",
            guarded.getCredential() == null ? null : guarded.getCredential().getType()),
        new KeyValuePair("guarded_credential_number",
            guarded.getCredential() == null ? null : guarded.getCredential().getNumber()),
        new KeyValuePair("guarded_birthday", guarded.getBirthday()));
    this.guarded = guarded;
  }

  public Person getGuarded() {
    return guarded;
  }
}
