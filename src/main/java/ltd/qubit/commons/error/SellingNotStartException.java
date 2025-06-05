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
import java.time.LocalDateTime;

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示产品销售尚未开始的异常。
 *
 * @author 胡海星
 */
public class SellingNotStartException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 910878055272966327L;

  private final LocalDateTime now;
  private final LocalDateTime from;
  private final LocalDateTime until;

  /**
   * 使用当前时间、销售开始时间和销售结束时间构造一个 {@link SellingNotStartException} 对象。
   *
   * @param now
   *     当前时间。
   * @param from
   *     销售开始时间。
   * @param until
   *     销售结束时间。
   */
  public SellingNotStartException(final LocalDateTime now,
      final LocalDateTime from, final LocalDateTime until) {
    super(ErrorCode.SELLING_NOT_START,
        new KeyValuePair("now", now),
        new KeyValuePair("from", from),
        new KeyValuePair("until", until));
    this.now = now;
    this.from = from;
    this.until = until;
  }

  /**
   * 获取当前时间。
   *
   * @return 当前时间。
   */
  public LocalDateTime getNow() {
    return now;
  }

  /**
   * 获取销售开始时间。
   *
   * @return 销售开始时间。
   */
  public LocalDateTime getFrom() {
    return from;
  }

  /**
   * 获取销售结束时间。
   *
   * @return 销售结束时间。
   */
  public LocalDateTime getUntil() {
    return until;
  }
}
