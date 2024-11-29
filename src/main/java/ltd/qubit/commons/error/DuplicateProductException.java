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
 * 表示一个订单中出现重复的商品。
 *
 * @author Haixing Hu
 */
public class DuplicateProductException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4281230450595374666L;

  private final ProductInfo product;

  public DuplicateProductException(final ProductInfo product) {
    super(ErrorCode.DUPLICATE_PRODUCT);
    this.product = product;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  public ProductInfo getProduct() {
    return product;
  }

  public Long getProductId() {
    return product.getId();
  }

  public String getProductCode() {
    return product.getCode();
  }

  public String getProductName() {
    return product.getName();
  }
}
