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
import ltd.qubit.model.util.Info;

/**
 * 表示商品只能为自己购买。
 *
 * @author 胡海星
 */
public class MustBuyForSelfException extends BusinessLogicException {

  private static final long serialVersionUID = 975536938407833445L;

  private final Info product;

  public MustBuyForSelfException(final Info product) {
    super(ErrorCode.MUST_BUY_FOR_SELF, makeParams(product));
    this.product = product;
  }

  public Info getProduct() {
    return product;
  }

  private static KeyValuePair[] makeParams(final Info product) {
    final List<KeyValuePair> params = new ArrayList<>();
    params.add(new KeyValuePair("product_id", product.getId()));
    params.add(new KeyValuePair("product_code", product.getCode()));
    params.add(new KeyValuePair("product_name", product.getName()));
    return params.toArray(new KeyValuePair[0]);
  }

}
