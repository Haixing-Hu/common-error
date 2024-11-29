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
 * 表示重复购买时错误.
 *
 * @author Haixing Hu
 */
public class DuplicatePurchaseException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4393486077067411366L;

  private final Buyer buyer;
  private final ProductInfo product;

  public DuplicatePurchaseException(final Buyer buyer, final ProductInfo product) {
    super(ErrorCode.DUPLICATE_PURCHASE);
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

  public Buyer getBuyer() {
    return buyer;
  }

  public ProductInfo getProduct() {
    return product;
  }

  public String getBuyerName() {
    return buyer.getName();
  }

  public String getBuyerMobile() {
    return buyer.getMobile() == null ? null : buyer.getMobile().toString();
  }

  public String getBuyerCredentialType() {
    final CredentialInfo credential = buyer.getCredential();
    return (credential == null ? null : credential.getType().name());
  }

  public String getBuyerCredentialNumber() {
    final CredentialInfo credential = buyer.getCredential();
    return (credential == null ? null : credential.getNumber());
  }

  public String getProductId() {
    return LongUtils.toString(product.getId());
  }

  public String getProductCode() {
    return product.getCode();
  }

  public String getProductName() {
    return product.getName();
  }
}
