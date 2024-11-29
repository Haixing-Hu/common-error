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

  public Info getProduct() {
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

  public Integer getExpected() {
    return expected;
  }

  public Integer getActual() {
    return actual;
  }
}
