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

import ltd.qubit.model.util.Info;

/**
 * 表示商品库存不够。
 *
 * @author 胡海星
 */
public class NoEnoughInventoryException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 1053966567796966131L;

  private final Info product;
  private final Integer expected;
  private final Integer actual;

  /**
   * 使用指定的产品信息、期望数量和实际数量构造一个 {@link NoEnoughInventoryException} 对象。
   *
   * @param product
   *     库存不足的产品的信息。
   * @param expected
   *     期望购买的产品数量。
   * @param actual
   *     实际剩余的产品库存数量。
   */
  public NoEnoughInventoryException(final Info product,
      final Integer expected, final Integer actual) {
    super(ErrorCode.NO_ENOUGH_INVENTORY);
    this.product = product;
    this.expected = expected;
    this.actual = actual;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
    this.addParam("expected", expected);
    this.addParam("actual", actual);
  }

  /**
   * 获取库存不足的产品的信息。
   *
   * @return 库存不足的产品的信息。
   */
  public Info getProduct() {
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
   * 获取期望购买的产品数量。
   *
   * @return 期望购买的产品数量。
   */
  public Integer getExpected() {
    return expected;
  }

  /**
   * 获取实际剩余的产品库存数量。
   *
   * @return 实际剩余的产品库存数量。
   */
  public Integer getActual() {
    return actual;
  }
}
