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

  /**
   * 使用指定的产品信息构造一个 {@link MustBuyForSelfException} 对象。
   *
   * @param product
   *     只能为自己购买的产品的信息。
   */
  public MustBuyForSelfException(final Info product) {
    super(ErrorCode.MUST_BUY_FOR_SELF);
    this.product = product;
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取只能为自己购买的产品的信息。
   *
   * @return 只能为自己购买的产品的信息。
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
}
