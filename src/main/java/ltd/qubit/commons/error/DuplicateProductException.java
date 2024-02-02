////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.util.ArrayList;
import java.util.List;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.Field;
import ltd.qubit.model.util.Info;

/**
 * 表示一个订单中出现重复的商品。
 *
 * @author Haixing Hu
 */
public class DuplicateProductException extends BusinessLogicException {

  private static final long serialVersionUID = 4281230450595374666L;

  private final Info product;

  public DuplicateProductException(final Info product) {
    super(ErrorCode.DUPLICATE_PRODUCT, makeParams(product));
    this.product = product;
  }

  public Info getProduct() {
    return product;
  }

  private static KeyValuePair[] makeParams(final Info product) {
    final List<KeyValuePair> params = new ArrayList<>();
    params.add(new KeyValuePair(Field.PRODUCT_ID, product.getId()));
    params.add(new KeyValuePair(Field.PRODUCT_CODE, product.getCode()));
    params.add(new KeyValuePair(Field.PRODUCT_NAME, product.getName()));
    return params.toArray(new KeyValuePair[0]);
  }
}
