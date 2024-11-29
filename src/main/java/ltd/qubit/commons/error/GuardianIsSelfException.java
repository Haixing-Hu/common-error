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

import ltd.qubit.commons.lang.StringUtils;
import ltd.qubit.model.commons.CredentialInfo;

/**
 * The exception thrown to indicate that the guardian of a person is the
 * person itself.
 *
 * @author Haixing Hu
 */
public class GuardianIsSelfException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 8864150248009427606L;

  private final Long id;
  private final String name;
  private final CredentialInfo credential;

  public GuardianIsSelfException(final Long id, final String name,
      final CredentialInfo credential) {
    super(ErrorCode.GUARDIAN_IS_SELF);
    this.id = id;
    this.name = name;
    this.credential = credential;
    this.addParam("id", id);
    this.addParam("name", name);
    this.addParam("credential_type", credential.getType());
    this.addParam("credential_number", credential.getNumber());
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

  public String getCredentialType() {
    return StringUtils.toString(credential.getType());
  }

  public String getCredentialNumber() {
    return credential.getNumber();
  }
}
