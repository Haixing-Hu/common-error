////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

/**
 * The exception thrown to indicate that a friendship already exists.
 *
 * @author Haixing Hu
 */
public class FriendExistException extends BusinessLogicException {

  private static final long serialVersionUID = -4988788314886836289L;

  public FriendExistException() {
    super(ErrorCode.FRIEND_EXIST);
  }
}
