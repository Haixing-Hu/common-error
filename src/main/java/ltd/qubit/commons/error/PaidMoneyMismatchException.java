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
import java.math.BigDecimal;

import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.payment.Payment;

import static ltd.qubit.commons.lang.BigDecimalUtils.formatMoney;

/**
 * 表示支付的款项不匹配。
 *
 * @author Haixing Hu
 */
public class PaidMoneyMismatchException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4393486077067411366L;

  private final Payment payment;

  public PaidMoneyMismatchException(final Payment payment) {
    super(ErrorCode.PAID_MONEY_MISMATCH);
    this.payment = payment;
    this.addParam("transaction_id", payment.getTransactionId());
    this.addParam("payment_number", payment.getNumber());
    this.addParam("payment_channel_number", payment.getChannelNumber());
    this.addParam("currency", payment.getCurrency());
    this.addParam("success", payment.isSuccess());
    this.addParam("payable", formatMoney(payment.getPayable()));
    this.addParam("discount", formatMoney(payment.getDiscount()));
    this.addParam("cost", formatMoney(payment.getCost()));
    this.addParam("paid", formatMoney(payment.getPaid()));
  }

  public Payment getPayment() {
    return payment;
  }

  public Long getTransactionId() {
    return payment.getTransactionId();
  }

  public String getPaymentNumber() {
    return payment.getNumber();
  }

  public String getPaymentChannelNumber() {
    return payment.getChannelNumber();
  }

  public Currency getCurrency() {
    return payment.getCurrency();
  }

  public boolean isSuccess() {
    return payment.isSuccess();
  }

  public BigDecimal getPayable() {
    return formatMoney(payment.getPayable());
  }

  public BigDecimal getDiscount() {
    return formatMoney(payment.getDiscount());
  }

  public BigDecimal getCost() {
    return formatMoney(payment.getCost());
  }

  public BigDecimal getPaid() {
    return formatMoney(payment.getPaid());
  }
}
