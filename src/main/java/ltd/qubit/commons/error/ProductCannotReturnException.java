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

/**
 * 表示产品无法退货的异常。
 *
 * @author 胡海星
 */
public class ProductCannotReturnException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -6494469978924632525L;

  private final String productName;
  private final String productCode;

  /**
   * 使用指定的产品名称和产品代码构造一个 {@link ProductCannotReturnException} 对象。
   *
   * @param productName
   *     无法退货的产品的名称。
   * @param productCode
   *     无法退货的产品的代码。
   */
  public ProductCannotReturnException(final String productName,
      final String productCode) {
    super(ErrorCode.PRODUCT_CANNOT_RETURN,
        new KeyValuePair("product_name", productName),
        new KeyValuePair("product_code", productCode));
    this.productName = productName;
    this.productCode = productCode;
  }

  /**
   * 获取无法退货的产品的名称。
   *
   * @return 无法退货的产品的名称。
   */
  public String getProductName() {
    return productName;
  }

  /**
   * 获取无法退货的产品的代码。
   *
   * @return 无法退货的产品的代码。
   */
  public String getProductCode() {
    return productCode;
  }
}
