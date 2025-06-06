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
 * 表示一个订单中出现重复的商品的异常。
 *
 * @author 胡海星
 */
public class DuplicateProductException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4281230450595374666L;

  private final ProductInfo product;

  /**
   * 构造一个 {@link DuplicateProductException} 对象。
   *
   * @param product
   *     重复的商品信息。
   */
  public DuplicateProductException(final ProductInfo product) {
    super(ErrorCode.DUPLICATE_PRODUCT);
    this.product = product;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取重复的商品信息。
   *
   * @return 重复的商品信息。
   */
  public ProductInfo getProduct() {
    return product;
  }

  /**
   * 获取重复的商品的ID。
   *
   * @return 重复的商品的ID。
   */
  public Long getProductId() {
    return product.getId();
  }

  /**
   * 获取重复的商品的代码。
   *
   * @return 重复的商品的代码。
   */
  public String getProductCode() {
    return product.getCode();
  }

  /**
   * 获取重复的商品的名称。
   *
   * @return 重复的商品的名称。
   */
  public String getProductName() {
    return product.getName();
  }
}
