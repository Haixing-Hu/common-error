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
 * Thrown to indicate that the user try to make a friend with himself.
 *
 * @author Haixing Hu
 */
public class MakeFriendWithSelfException extends BusinessLogicException {

  private static final long serialVersionUID = 7318020832823881260L;

  public MakeFriendWithSelfException() {
    super(ErrorCode.MAKE_FRIEND_WITH_SELF);
  }
}
