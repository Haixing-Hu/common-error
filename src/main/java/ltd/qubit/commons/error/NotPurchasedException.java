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
 * 表示指定客户没有购买过指定产品。
 *
 * @author Haixing Hu
 */
public class NotPurchasedException extends BusinessLogicException {

  private static final long serialVersionUID = -2956663857300728314L;

  private final Buyer buyer;
  private final ProductInfo product;

  public NotPurchasedException(final Buyer buyer, final ProductInfo product) {
    super(ErrorCode.NOT_PURCHASED,
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
