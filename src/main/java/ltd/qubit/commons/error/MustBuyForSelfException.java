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
 * 表示商品只能为自己购买。
 *
 * @author 胡海星
 */
public class MustBuyForSelfException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 975536938407833445L;

  private final Info product;

  public MustBuyForSelfException(final Info product) {
    super(ErrorCode.MUST_BUY_FOR_SELF);
    this.product = product;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
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
}
