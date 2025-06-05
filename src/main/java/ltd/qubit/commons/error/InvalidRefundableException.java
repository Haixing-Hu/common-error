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
 * @author 胡海星
 */
public class InvalidRefundableException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7538860350794754470L;

  private final ProductInfo product;
  private final BigDecimal expectedRefundable;
  private final BigDecimal actualRefundable;

  /**
   * 使用指定的产品信息、预期可退款金额和实际可退款金额构造一个
   * {@link InvalidRefundableException} 对象。
   *
   * @param product
   *     相关的产品信息。
   * @param expectedRefundable
   *     预期的可退款金额。
   * @param actualRefundable
   *     实际的可退款金额。
   */
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

  /**
   * 获取相关的产品信息。
   *
   * @return 相关的产品信息。
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
   * 获取产品的代码。
   *
   * @return 产品的代码。
   */
  public String getProductCode() {
    return product.getCode();
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
   * 获取预期的可退款金额。
   *
   * @return 预期的可退款金额。
   */
  public BigDecimal getExpectedRefundable() {
    return expectedRefundable;
  }

  /**
   * 获取实际的可退款金额。
   *
   * @return 实际的可退款金额。
   */
  public BigDecimal getActualRefundable() {
    return actualRefundable;
  }
}
