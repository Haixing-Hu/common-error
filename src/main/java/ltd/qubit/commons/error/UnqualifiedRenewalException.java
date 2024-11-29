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

import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.commons.CredentialType;
import ltd.qubit.model.order.Client;

public class UnqualifiedRenewalException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -2956663857300728315L;

  private final Client client;

  public UnqualifiedRenewalException(final Client client) {
    super(ErrorCode.UNQUALIFIED_RENEWAL);
    this.client = client;
    this.addParam("client_name", client.getName());
    final CredentialInfo credential = client.getCredential();
    this.addParam("client_credential_type", (credential == null ? null : credential.getType()));
    this.addParam("client_credential_number", (credential == null ? null : credential.getNumber()));
  }

  public Client getClient() {
    return client;
  }

  public String getClientName() {
    return client.getName();
  }

  public CredentialType getClientCredentialType() {
    final CredentialInfo credential = client.getCredential();
    return (credential == null ? null : credential.getType());
  }

  public String getClientCredentialNumber() {
    final CredentialInfo credential = client.getCredential();
    return (credential == null ? null : credential.getNumber());
  }
}
