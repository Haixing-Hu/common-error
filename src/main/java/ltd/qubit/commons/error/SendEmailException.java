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

public class SendEmailException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = 6958281472891531001L;

  private final String email;

  private final String thirdPartyCode;

  private final String thirdPartyMessage;

  /**
   * Constructs a {@link SendEmailException}.
   *
   * @param email
   *     the email address.
   * @param thirdPartyCode
   *     the error code returned by the third-party service.
   * @param thirdPartyMessage
   *     the detailed error message describing the error returned by the
   *     third-party service.
   */
  public SendEmailException(final String email, final String thirdPartyCode,
      final String thirdPartyMessage) {
    super(ErrorCode.SEND_EMAIL_FAILED);
    this.email = email;
    this.thirdPartyCode = thirdPartyCode;
    this.thirdPartyMessage = thirdPartyMessage;
    this.addParam("email", this.email);
    this.addParam("third_party_code", this.thirdPartyCode);
    this.addParam("third_party_message", this.thirdPartyMessage);
  }

  public String getEmail() {
    return email;
  }

  public String getThirdPartyCode() {
    return thirdPartyCode;
  }

  public String getThirdPartyMessage() {
    return thirdPartyMessage;
  }
}
