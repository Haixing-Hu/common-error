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

/**
 * 表示不符合续保条件的异常。
 *
 * @author 胡海星
 */
public class UnqualifiedRenewalException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -2956663857300728315L;

  private final Client client;

  /**
   * 使用指定的客户信息构造一个 {@link UnqualifiedRenewalException} 对象。
   *
   * @param client
   *     不符合续保条件的客户信息。
   */
  public UnqualifiedRenewalException(final Client client) {
    super(ErrorCode.UNQUALIFIED_RENEWAL);
    this.client = client;
    this.addParam("client_name", client.getName());
    final CredentialInfo credential = client.getCredential();
    this.addParam("client_credential_type", (credential == null ? null : credential.getType()));
    this.addParam("client_credential_number", (credential == null ? null : credential.getNumber()));
  }

  /**
   * 获取不符合续保条件的客户信息。
   *
   * @return 不符合续保条件的客户信息。
   */
  public Client getClient() {
    return client;
  }

  /**
   * 获取不符合续保条件的客户的姓名。
   *
   * @return 不符合续保条件的客户的姓名。
   */
  public String getClientName() {
    return client.getName();
  }

  /**
   * 获取不符合续保条件的客户的证件类型。
   *
   * @return 不符合续保条件的客户的证件类型，如果证件信息不存在则返回 null。
   */
  public CredentialType getClientCredentialType() {
    final CredentialInfo credential = client.getCredential();
    return (credential == null ? null : credential.getType());
  }

  /**
   * 获取不符合续保条件的客户的证件号码。
   *
   * @return 不符合续保条件的客户的证件号码，如果证件信息不存在则返回 null。
   */
  public String getClientCredentialNumber() {
    final CredentialInfo credential = client.getCredential();
    return (credential == null ? null : credential.getNumber());
  }
}
