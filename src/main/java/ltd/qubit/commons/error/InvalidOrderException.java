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
import ltd.qubit.model.product.ProductInfo;

/**
 * 表示订单信息错误。
 *
 * @author Haixing Hu
 */
public class InvalidOrderException extends BusinessLogicException {

  private static final long serialVersionUID = 4393486077067411366L;

  private final Long orderId;
  private final ProductInfo product;

  public InvalidOrderException(final Long orderId, final ProductInfo product) {
    super(ErrorCode.INVALID_ORDER,
        new KeyValuePair("order_id", orderId),
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()));
    this.orderId = orderId;
    this.product = product;
  }

  public Long getOrderId() {
    return orderId;
  }

  public ProductInfo getProduct() {
    return product;
  }
}
