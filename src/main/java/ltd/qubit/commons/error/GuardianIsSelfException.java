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

/**
 * The exception thrown to indicate that the guardian of a person is the
 * person itself.
 *
 * @author Haixing Hu
 */
public class GuardianIsSelfException extends BusinessLogicException {

  private static final long serialVersionUID = 8864150248009427606L;

  private final Long id;
  private final String name;
  private final CredentialInfo credential;

  public GuardianIsSelfException(final Long id, final String name,
      final CredentialInfo credential) {
    super(ErrorCode.GUARDIAN_IS_SELF,
        new KeyValuePair("id", id),
        new KeyValuePair("name", name),
        new KeyValuePair("credential_type", credential.getType()),
        new KeyValuePair("credential_number", credential.getNumber()));
    this.id = id;
    this.name = name;
    this.credential = credential;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public CredentialInfo getCredential() {
    return credential;
  }
}
