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
import ltd.qubit.model.order.Client;

public class UnqualifiedRenewalException extends BusinessLogicException {

  private static final long serialVersionUID = -2956663857300728315L;
  private final Client client;

  public UnqualifiedRenewalException(final Client client) {
    super(ErrorCode.UNQUALIFIED_RENEWAL,
        new KeyValuePair("client_name", client.getName()),
        new KeyValuePair("client_credential_type",
            (client.getCredential() == null ? null : client.getCredential().getType())),
        new KeyValuePair("client_credential_number",
            (client.getCredential() == null ? null : client.getCredential().getNumber())));
    this.client = client;
  }

  public Client getClient() {
    return client;
  }
}
