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
 * 表示产品购买数量错误。
 *
 * @author Haixing Hu
 */
public class InvalidProductCountException extends BusinessLogicException {

  private static final long serialVersionUID = 5921391072348162455L;

  private final ProductInfo product;

  public InvalidProductCountException(final ProductInfo product) {
    super(ErrorCode.INVALID_PRODUCT_COUNT,
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()));
    this.product = product;
  }

  public ProductInfo getProduct() {
    return product;
  }
}
