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

import ltd.qubit.commons.lang.LongUtils;
import ltd.qubit.model.commons.CredentialInfo;
import ltd.qubit.model.order.Buyer;
import ltd.qubit.model.product.ProductInfo;

/**
 * 表示指定客户已经退货后再次重购。
 *
 * @author 胡海星
 */
public class ReturnedPurchaseAgainException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 2555947627572687153L;

  private final Buyer buyer;
  private final ProductInfo product;

  /**
   * 使用指定的购买者和产品信息构造一个 {@link ReturnedPurchaseAgainException} 对象。
   *
   * @param buyer
   *     进行重购的购买者信息。
   * @param product
   *     被重购的产品信息。
   */
  public ReturnedPurchaseAgainException(final Buyer buyer,
      final ProductInfo product) {
    super(ErrorCode.RETURNED_PURCHASE_AGAIN);
    this.buyer = buyer;
    this.product = product;
    this.addParam("buyer_name", buyer.getName());
    this.addParam("buyer_mobile", buyer.getMobile());
    final CredentialInfo credential = buyer.getCredential();
    this.addParam("buyer_credential_type", credential == null ? null : credential.getType().name());
    this.addParam("buyer_credential_number", credential == null ? null : credential.getNumber());
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取进行重购的购买者信息。
   *
   * @return 进行重购的购买者信息。
   */
  public Buyer getBuyer() {
    return buyer;
  }

  /**
   * 获取被重购的产品信息。
   *
   * @return 被重购的产品信息。
   */
  public ProductInfo getProduct() {
    return product;
  }

  /**
   * 获取购买者的姓名。
   *
   * @return 购买者的姓名。
   */
  public String getBuyerName() {
    return buyer.getName();
  }

  /**
   * 获取购买者的手机号码字符串。
   *
   * @return 购买者的手机号码字符串，如果不存在则返回 null。
   */
  public String getBuyerMobile() {
    return buyer.getMobile() == null ? null : buyer.getMobile().toString();
  }

  /**
   * 获取购买者的证件类型名称。
   *
   * @return 购买者的证件类型名称，如果证件信息不存在则返回 null。
   */
  public String getBuyerCredentialType() {
    final CredentialInfo credential = buyer.getCredential();
    return (credential == null ? null : credential.getType().name());
  }

  /**
   * 获取购买者的证件号码。
   *
   * @return 购买者的证件号码，如果证件信息不存在则返回 null。
   */
  public String getBuyerCredentialNumber() {
    final CredentialInfo credential = buyer.getCredential();
    return (credential == null ? null : credential.getNumber());
  }

  /**
   * 获取产品的ID字符串。
   *
   * @return 产品的ID字符串。
   */
  public String getProductId() {
    return LongUtils.toString(product.getId());
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
