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

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.product.ProductInfo;

/**
 * 表示订单中客户信息错误。
 *
 * @author 胡海星
 */
public class InvalidOrderClientException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3414596639344085024L;

  private final Long orderId;
  private final ProductInfo product;

  /**
   * 使用指定的订单ID和产品信息构造一个 {@link InvalidOrderClientException} 对象。
   *
   * @param orderId
   *     客户信息错误的订单的ID。
   * @param product
   *     订单中相关的产品信息。
   */
  public InvalidOrderClientException(final Long orderId, final ProductInfo product) {
    super(ErrorCode.INVALID_ORDER_CLIENT,
        new KeyValuePair("order_id", orderId),
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()));
    this.orderId = orderId;
    this.product = product;
  }

  /**
   * 获取客户信息错误的订单的ID。
   *
   * @return 客户信息错误的订单的ID。
   */
  public Long getOrderId() {
    return orderId;
  }

  /**
   * 获取订单中相关的产品信息。
   *
   * @return 订单中相关的产品信息。
   */
  public ProductInfo getProduct() {
    return product;
  }
}
