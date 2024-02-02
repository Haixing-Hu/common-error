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
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.order.Buyer;
import ltd.qubit.model.util.Info;

/**
 * 表示购买者重复时错误。
 *
 * @author Haixing Hu
 */
public class DuplicateBuyerException extends BusinessLogicException {

  private static final long serialVersionUID = 4393486077067411366L;

  private final Buyer buyer;
  private final Info product;

  public DuplicateBuyerException(final Buyer buyer, final Info product) {
    super(ErrorCode.DUPLICATE_BUYER, makeParams(buyer, product));
    this.buyer = buyer;
    this.product = product;
  }

  public Buyer getBuyer() {
    return buyer;
  }

  public Info getProduct() {
    return product;
  }

  private static KeyValuePair[] makeParams(final Buyer buyer, final Info product) {
    final List<KeyValuePair> params = new ArrayList<>();
    params.add(new KeyValuePair("buyer_name", buyer.getName()));
    params.add(new KeyValuePair("buyer_mobile", buyer.getMobile()));
    final CredentialInfo credential = buyer.getCredential();
    if (credential != null) {
      params.add(new KeyValuePair("buyer_credential_type", credential.getType().name()));
      params.add(new KeyValuePair("buyer_credential_number", credential.getNumber()));
    } else {
      params.add(new KeyValuePair("buyer_credential_type", null));
      params.add(new KeyValuePair("buyer_credential_number", null));
    }
    params.add(new KeyValuePair("product_id", product.getId()));
    params.add(new KeyValuePair("product_code", product.getCode()));
    params.add(new KeyValuePair("product_name", product.getName()));
    return params.toArray(new KeyValuePair[0]);
  }
}
