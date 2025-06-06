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
 * 表示好友关系已存在的异常。
 *
 * @author 胡海星
 */
public class FriendExistException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -4988788314886836289L;

  private final String friendName;

  /**
   * 使用指定的好友名称构造一个 {@link FriendExistException} 对象。
   *
   * @param friendName
   *     已存在的好友的名称。
   */
  public FriendExistException(final String friendName) {
    super(ErrorCode.FRIEND_EXIST,
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