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
import ltd.qubit.model.order.Buyer;
import ltd.qubit.model.product.ProductInfo;

/**
 * 表示指定客户已经退货后再次重购。
 *
 * @author Haixing Hu
 */
public class ReturnedPurchaseAgainException extends BusinessLogicException {

  private static final long serialVersionUID = 2555947627572687153L;

  private final Buyer buyer;
  private final ProductInfo product;

  public ReturnedPurchaseAgainException(final Buyer buyer,
      final ProductInfo product) {
    super(ErrorCode.RETURNED_PURCHASE_AGAIN,
        new KeyValuePair("buyer_name", buyer.getName()),
        new KeyValuePair("buyer_mobile", buyer.getMobile()),
        new KeyValuePair("buyer_credential_type",
            (buyer.getCredential() != null ? buyer.getCredential().getType() : null)),
        new KeyValuePair("buyer_credential_number",
            (buyer.getCredential() != null ? buyer.getCredential().getNumber() : null)),
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()));
    this.buyer = buyer;
    this.product = product;
  }

  public Buyer getBuyer() {
    return buyer;
  }

  public ProductInfo getProduct() {
    return product;
  }
}
