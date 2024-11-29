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
 * @author Haixing Hu
 */
public class InvalidPriceException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4393486077067411366L;

  private final ProductInfo product;

  public InvalidPriceException(final ProductInfo product) {
    super(ErrorCode.INVALID_PRICE);
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

  public String getProductName() {
    return product.getName();
  }

  public String getProductCode() {
    return product.getCode();
  }
}
