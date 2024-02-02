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
import ltd.qubit.model.payment.Payment;

import static ltd.qubit.commons.lang.BigDecimalUtils.formatMoney;

/**
 * 表示支付信息和交易记录不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchPaymentException extends BusinessLogicException {

  private static final long serialVersionUID = 3430836558448212935L;

  private final Payment payment;

  public MismatchPaymentException(final Payment payment) {
    super(ErrorCode.MISMATCH_PAYMENT,
        new KeyValuePair("transaction_id", payment.getTransactionId()),
        new KeyValuePair("payment_number", payment.getNumber()),
        new KeyValuePair("payment_channel_number", payment.getChannelNumber()),
        new KeyValuePair("currency", payment.getCurrency()),
        new KeyValuePair("success", payment.isSuccess()),
        new KeyValuePair("payable", formatMoney(payment.getPayable())),
        new KeyValuePair("discount", formatMoney(payment.getDiscount())),
        new KeyValuePair("cost", formatMoney(payment.getCost())),
        new KeyValuePair("paid", formatMoney(payment.getPaid())));
    this.payment = payment;
  }

  public Payment getPayment() {
    return payment;
  }
}
