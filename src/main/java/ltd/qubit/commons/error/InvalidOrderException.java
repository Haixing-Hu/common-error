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

import ltd.qubit.model.product.ProductInfo;

/**
 * 表示订单信息错误。
 *
 * @author 胡海星
 */
public class InvalidOrderException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4393486077067411366L;

  private final Long orderId;
  private final ProductInfo product;

  /**
   * 使用指定的订单ID和产品信息构造一个 {@link InvalidOrderException} 对象。
   *
   * @param orderId
   *     信息错误的订单的ID。
   * @param product
   *     订单中相关的产品信息。
   */
  public InvalidOrderException(final Long orderId, final ProductInfo product) {
    super(ErrorCode.INVALID_ORDER);
    this.orderId = orderId;
    this.product = product;
    this.addParam("order_id", orderId);
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取信息错误的订单的ID。
   *
   * @return 信息错误的订单的ID。
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

  /**
   * 获取产品的ID。
   *
   * @return 产品的ID。
   */
  public Long getProductId() {
    return product.getId();
  }

  /**
   * 获取产品的名称。
   *
   * @return 产品的名称。
   */
  public String getProductName() {
    return product.getName();
  }

  /**
   * 获取产品的代码。
   *
   * @return 产品的代码。
   */
  public String getProductCode() {
    return product.getCode();
  }
}
