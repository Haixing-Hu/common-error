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
import ltd.qubit.model.person.PersonInfo;

public class GuardianRefundingException extends BusinessLogicException {

  private static final long serialVersionUID = -269560063857372789L;
  private final PersonInfo guardian;

  public GuardianRefundingException(final PersonInfo guardian) {
    super(ErrorCode.GUARDIAN_IS_REFUNDING,
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
}
