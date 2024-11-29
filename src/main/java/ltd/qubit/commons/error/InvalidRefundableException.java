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
import java.math.BigDecimal;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.product.ProductInfo;

import static ltd.qubit.commons.lang.BigDecimalUtils.formatMoney;

/**
 * 表示退款金额错误。
 *
 * @author Haixing Hu
 */
public class InvalidRefundableException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7538860350794754470L;

  private final ProductInfo product;
  private final BigDecimal expectedRefundable;
  private final BigDecimal actualRefundable;

  public InvalidRefundableException(final ProductInfo product,
      final BigDecimal expectedRefundable, final BigDecimal actualRefundable) {
    super(ErrorCode.INVALID_REFUNDABLE,
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()),
        new KeyValuePair("expected_refundable", formatMoney(expectedRefundable)),
        new KeyValuePair("actual_refundable", formatMoney(actualRefundable)));
    this.product = product;
    this.expectedRefundable = formatMoney(expectedRefundable);
    this.actualRefundable = formatMoney(actualRefundable);
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
    this.addParam("expected_refundable", this.expectedRefundable);
    this.addParam("actual_refundable", this.actualRefundable);
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

  public BigDecimal getExpectedRefundable() {
    return expectedRefundable;
  }

  public BigDecimal getActualRefundable() {
    return actualRefundable;
  }
}
