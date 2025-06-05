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
 * 表示产品价格错误。
 *
 * @author 胡海星
 */
public class InvalidPriceException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4393486077067411366L;

  private final ProductInfo product;

  /**
   * 使用指定的产品信息构造一个 {@link InvalidPriceException} 对象。
   *
   * @param product
   *     价格错误的产品的信息。
   */
  public InvalidPriceException(final ProductInfo product) {
    super(ErrorCode.INVALID_PRICE);
    this.product = product;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取价格错误的产品的信息。
   *
   * @return 价格错误的产品的信息。
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
