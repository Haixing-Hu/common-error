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
 * 表示产品购买数量错误。
 *
 * @author 胡海星
 */
public class InvalidProductCountException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5921391072348162455L;

  private final ProductInfo product;

  /**
   * 使用指定的产品信息构造一个 {@link InvalidProductCountException} 对象。
   *
   * @param product
   *     购买数量错误的产品的信息。
   */
  public InvalidProductCountException(final ProductInfo product) {
    super(ErrorCode.INVALID_PRODUCT_COUNT);
    this.product = product;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取购买数量错误的产品的信息。
   *
   * @return 购买数量错误的产品的信息。
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
