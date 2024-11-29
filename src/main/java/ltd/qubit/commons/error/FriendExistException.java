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
 * The exception thrown to indicate that a friendship already exists.
 *
 * @author Haixing Hu
 */
public class FriendExistException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -4988788314886836289L;

  private final String friendName;

  public FriendExistException(final String friendName) {
    super(ErrorCode.FRIEND_EXIST);
    this.friendName = friendName;
    this.addParam("field_name", friendName);
  }

  public String getFriendName() {
    return friendName;
  }
}
