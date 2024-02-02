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
 * 表示指定客户已经退货。
 *
 * @author Haixing Hu
 */
public class AlreadyReturnedException extends BusinessLogicException {

  private static final long serialVersionUID = 502028108253929548L;

  private final Buyer buyer;
  private final ProductInfo product;

  public AlreadyReturnedException(final Buyer buyer, final ProductInfo product) {
    super(ErrorCode.ALREADY_RETURNED,
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
