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
 * @author 胡海星
 */
public class PaidMoneyMismatchException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 4393486077067411366L;

  private final Payment payment;

  /**
   * 使用指定的支付信息构造一个 {@link PaidMoneyMismatchException} 对象。
   *
   * @param payment
   *     发生金额不匹配的支付信息对象。
   */
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

  /**
   * 获取相关的支付信息对象。
   *
   * @return 相关的支付信息对象。
   */
  public Payment getPayment() {
    return payment;
  }

  /**
   * 获取支付的交易ID。
   *
   * @return 支付的交易ID。
   */
  public Long getTransactionId() {
    return payment.getTransactionId();
  }

  /**
   * 获取支付单号。
   *
   * @return 支付单号。
   */
  public String getPaymentNumber() {
    return payment.getNumber();
  }

  /**
   * 获取支付渠道单号。
   *
   * @return 支付渠道单号。
   */
  public String getPaymentChannelNumber() {
    return payment.getChannelNumber();
  }

  /**
   * 获取支付货币单位。
   *
   * @return 支付货币单位。
   */
  public Currency getCurrency() {
    return payment.getCurrency();
  }

  /**
   * 判断支付是否成功。
   *
   * @return 如果支付成功，则返回 true；否则返回 false。
   */
  public boolean isSuccess() {
    return payment.isSuccess();
  }

  /**
   * 获取应付金额。
   *
   * @return 应付金额。
   */
  public BigDecimal getPayable() {
    return formatMoney(payment.getPayable());
  }

  /**
   * 获取折扣金额。
   *
   * @return 折扣金额。
   */
  public BigDecimal getDiscount() {
    return formatMoney(payment.getDiscount());
  }

  /**
   * 获取成本金额。
   *
   * @return 成本金额。
   */
  public BigDecimal getCost() {
    return formatMoney(payment.getCost());
  }

  /**
   * 获取实付金额。
   *
   * @return 实付金额。
   */
  public BigDecimal getPaid() {
    return formatMoney(payment.getPaid());
  }
}
