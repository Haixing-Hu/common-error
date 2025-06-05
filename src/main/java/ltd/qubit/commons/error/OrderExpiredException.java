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

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示订单已过期失效。
 *
 * @author 胡海星
 */
public class OrderExpiredException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -7254632978306253491L;

  private final Long orderId;

  /**
   * 使用指定的订单ID构造一个 {@link OrderExpiredException} 对象。
   *
   * @param orderId
   *     已过期订单的ID。
   */
  public OrderExpiredException(final Long orderId) {
    super(ErrorCode.ORDER_EXPIRED, new KeyValuePair("order_id", orderId));
    this.orderId = orderId;
  }

  /**
   * 获取已过期订单的ID。
   *
   * @return 已过期订单的ID。
   */
  public Long getOrderId() {
    return orderId;
  }
}
