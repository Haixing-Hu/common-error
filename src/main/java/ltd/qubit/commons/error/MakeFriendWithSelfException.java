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

/**
 * 表示用户试图将自己加为好友的异常。
 *
 * @author 胡海星
 */
public class MakeFriendWithSelfException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 7318020832823881260L;

  /**
   * 构造一个 {@link MakeFriendWithSelfException} 对象。
   */
  public MakeFriendWithSelfException() {
    super(ErrorCode.MAKE_FRIEND_WITH_SELF);
  }
}
