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
import ltd.qubit.model.util.Info;

/**
 * 表示商品库存不够。
 *
 * @author 胡海星
 */
public class NoEnoughInventoryException extends BusinessLogicException {

  private static final long serialVersionUID = 1053966567796966131L;

  private final Info product;
  private final Integer expected;
  private final Integer actual;

  public NoEnoughInventoryException(final Info product,
      final Integer expected, final Integer actual) {
    super(ErrorCode.NO_ENOUGH_INVENTORY,
        new KeyValuePair("product_id", product.getId()),
        new KeyValuePair("product_code", product.getCode()),
        new KeyValuePair("product_name", product.getName()),
        new KeyValuePair("expected", expected),
        new KeyValuePair("actual", actual));
    this.product = product;
    this.expected = expected;
    this.actual = actual;
  }

  public Info getProduct() {
    return product;
  }

  public Integer getExpected() {
    return expected;
  }

  public Integer getActual() {
    return actual;
  }
}
