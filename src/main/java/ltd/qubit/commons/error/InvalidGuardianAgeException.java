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
import ltd.qubit.model.person.PersonInfo;

/**
 * 表示监护人年龄错误。
 *
 * @author 胡海星
 */
public class InvalidGuardianAgeException extends BusinessLogicException {

  private static final long serialVersionUID = -1147861390993501153L;

  private final PersonInfo guardian;

  public InvalidGuardianAgeException(final PersonInfo guardian) {
    super(ErrorCode.INVALID_GUARDIAN_AGE,
        new KeyValuePair("guardian_name", guardian.getName()),
        new KeyValuePair("guardian_mobile", guardian.getMobile()),
        new KeyValuePair("guardian_credential_type",
            guardian.getCredential() == null ? null : guardian.getCredential().getType()),
        new KeyValuePair("guardian_credential_number",
            guardian.getCredential() == null ? null : guardian.getCredential().getNumber()),
        new KeyValuePair("guardian_birthday", guardian.getBirthday()));
    this.guardian = guardian;
  }

  public PersonInfo getGuardian() {
    return guardian;
  }

  private static KeyValuePair[] makeParams(final PersonInfo guardian) {
    final List<KeyValuePair> params = new ArrayList<>();
    params.add(new KeyValuePair(Field.FULLNAME, guardian.getName()));
    params.add(new KeyValuePair(Field.CREDENTIAL, guardian.getCredential()));
    params.add(new KeyValuePair(Field.BIRTHDAY, guardian.getBirthday()));
    return params.toArray(new KeyValuePair[0]);
  }
}
