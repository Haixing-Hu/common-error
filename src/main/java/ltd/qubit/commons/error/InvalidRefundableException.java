////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.math.BigDecimal;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.product.ProductInfo;

import static ltd.qubit.commons.lang.BigDecimalUtils.formatMoney;

/**
 * 表示产品价格错误。
 *
 * @author Haixing Hu
 */
public class InvalidRefundableException extends BusinessLogicException {

  private static final long serialVersionUID = 7538860350794754470L;

  private final ProductInfo product;
  private final BigDecimal expected;
  private final BigDecimal actual;

  public InvalidRefundableException(final ProductInfo product,
      final BigDecimal expected, final BigDecimal actual) {
    super(ErrorCode.INVALID_REFUNDABLE,
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()),
        new KeyValuePair("expected_refundable", formatMoney(expected)),
        new KeyValuePair("actual_refundable", formatMoney(actual)));
    this.product = product;
    this.expected = expected;
    this.actual = actual;
  }

  public ProductInfo getProduct() {
    return product;
  }

  public BigDecimal getExpected() {
    return expected;
  }

  public BigDecimal getActual() {
    return actual;
  }
}
