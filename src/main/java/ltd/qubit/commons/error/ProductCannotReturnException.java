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

public class ProductCannotReturnException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -6494469978924632525L;

  private final String productName;
  private final String productCode;

  public ProductCannotReturnException(final String productName,
      final String productCode) {
    super(ErrorCode.PRODUCT_CANNOT_RETURN,
        new KeyValuePair("product_name", productName),
        new KeyValuePair("product_code", productCode));
    this.productName = productName;
    this.productCode = productCode;
  }

  public String getProductName() {
    return productName;
  }

  public String getProductCode() {
    return productCode;
  }
}
