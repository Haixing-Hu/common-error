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
 * 表示好友请求已存在的异常。
 *
 * @author 胡海星
 */
public class FriendRequestExistException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -6116535746840333099L;

  private final String friendName;

  public FriendRequestExistException(final String friendName) {
    super(ErrorCode.FRIEND_REQUEST_EXIST,
        new KeyValuePair("friend_name", friendName));
    this.friendName = friendName;
  }

  /**
   * 获取已存在的好友的名称。
   *
   * @return 已存在的好友的名称。
   */
  public String getFriendName() {
    return friendName;
  }
}