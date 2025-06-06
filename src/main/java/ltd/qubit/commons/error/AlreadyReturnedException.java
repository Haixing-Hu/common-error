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

import static ltd.qubit.commons.lang.Argument.requireNonNull;

/**
 * 表示指定客户已经退货的异常。
 *
 * @author 胡海星
 */
public class AlreadyReturnedException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 502028108253929548L;

  private final Buyer buyer;
  private final ProductInfo product;

  /**
   * 使用指定的购买者和产品信息构造一个 {@link AlreadyReturnedException} 对象。
   *
   * @param buyer
   *     已经退货的购买者信息。
   * @param product
   *     已经退货的产品信息。
   */
  public AlreadyReturnedException(final Buyer buyer, final ProductInfo product) {
    super(ErrorCode.ALREADY_RETURNED);
    this.buyer = requireNonNull("buyer", buyer);
    this.product = requireNonNull("product", product);
    this.addParam("buyer_name", buyer.getName());
    this.addParam("buyer_mobile", buyer.getMobile() == null ? "" : buyer.getMobile().toString());
    final CredentialInfo credential = buyer.getCredential();
    this.addParam("buyer_credential_type", (credential == null ? "" : credential.getType().name()));
    this.addParam("buyer_credential_number", (credential == null ? "" : credential.getNumber()));
    this.addParam("product_id", product.getId());
    this.addParam("product_code", product.getCode());
    this.addParam("product_name", product.getName());
  }

  /**
   * 获取已经退货的购买者信息。
   *
   * @return 已经退货的购买者信息。
   */
  public Buyer getBuyer() {
    return buyer;
  }

  /**
   * 获取已经退货的产品信息。
   *
   * @return 已经退货的产品信息。
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
   * @return 购买者的手机号码字符串，如果不存在则为 ""。
   */
  public String getBuyerMobile() {
    return buyer.getMobile() == null ? "" : buyer.getMobile().toString();
  }

  /**
   * 获取购买者的证件类型名称。
   *
   * @return 购买者的证件类型名称，如果证件信息不存在则返回 ""。
   */
  public String getBuyerCredentialType() {
    final CredentialInfo credential = buyer.getCredential();
    return (credential == null ? "" : credential.getType().name());
  }

  /**
   * 获取购买者的证件号码。
   *
   * @return 购买者的证件号码，如果证件信息不存在则返回 ""。
   */
  public String getBuyerCredentialNumber() {
    final CredentialInfo credential = buyer.getCredential();
    return (credential == null ? "" : credential.getNumber());
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
