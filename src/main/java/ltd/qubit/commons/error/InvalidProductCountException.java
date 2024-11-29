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
 * @author Haixing Hu
 */
public class InvalidProductCountException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5921391072348162455L;

  private final ProductInfo product;

  public InvalidProductCountException(final ProductInfo product) {
    super(ErrorCode.INVALID_PRODUCT_COUNT);
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
