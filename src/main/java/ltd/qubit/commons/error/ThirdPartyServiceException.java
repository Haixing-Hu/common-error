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

public class ThirdPartyServiceException extends ServerSideException {

  @Serial
  private static final long serialVersionUID = -7165213672754327853L;

  public ThirdPartyServiceException(final String message) {
    this(ErrorCode.THIRD_PARTY_SERVICE_FAILURE, message);
  }

  public ThirdPartyServiceException(final ErrorCode errorCode, final String message) {
    super(ErrorType.THIRD_PARTY_ERROR, errorCode, new KeyValuePair("message", message));
  }

  public ThirdPartyServiceException(final ErrorCode errorCode, final KeyValuePair ... params) {
    super(ErrorType.THIRD_PARTY_ERROR, errorCode, params);
  }
}
