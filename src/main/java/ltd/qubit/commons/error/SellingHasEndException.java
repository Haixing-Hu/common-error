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

public class SellingHasEndException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 5983886472917964829L;

  private final LocalDateTime now;
  private final LocalDateTime from;
  private final LocalDateTime until;

  public SellingHasEndException(final LocalDateTime now,
      final LocalDateTime from, final LocalDateTime until) {
    super(ErrorCode.SELLING_HAS_END,
        new KeyValuePair("now", now),
        new KeyValuePair("from", from),
        new KeyValuePair("until", until));
    this.now = now;
    this.from = from;
    this.until = until;
  }

  public LocalDateTime getNow() {
    return now;
  }

  public LocalDateTime getFrom() {
    return from;
  }

  public LocalDateTime getUntil() {
    return until;
  }
}
