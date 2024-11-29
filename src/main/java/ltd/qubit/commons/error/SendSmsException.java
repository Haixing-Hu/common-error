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
import java.util.List;

import javax.annotation.Nullable;

import ltd.qubit.commons.lang.ObjectUtils;
import ltd.qubit.model.contact.Phone;

/**
 * The exception thrown when sending SMS failed.
 *
 * @author Haixing Hu
 */
public class SendSmsException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = 8488280770978042223L;

  private final Phone phone;

  private final List<Phone> phones;

  private final String thirdPartyCode;

  private final String thirdPartyMessage;

  /**
   * Constructs a {@link SendSmsException}.
   *
   * @param phone
   *     the phone number.
   * @param thirdPartyCode
   *     the error code returned by the third-party service.
   * @param thirdPartyMessage
   *     the detailed error message describing the error returned by the
   *     third-party service.
   */
  public SendSmsException(final Phone phone, final String thirdPartyCode,
      final String thirdPartyMessage) {
    this(phone, null, thirdPartyCode, thirdPartyMessage);
  }

  /**
   * Constructs a {@link SendSmsException}.
   *
   * @param phones
   *     the phone numbers.
   * @param thirdPartyCode
   *     the error code returned by the third-party service.
   * @param thirdPartyMessage
   *     the detailed error message describing the error returned by the
   *     third-party service.
   */
  public SendSmsException(final List<Phone> phones, final String thirdPartyCode,
      final String thirdPartyMessage) {
    this(null, phones, thirdPartyCode, thirdPartyMessage);
  }

  /**
   * Constructs a {@link SendSmsException}.
   *
   * @param phone
   *     the phone number.
   * @param thirdPartyCode
   *     the error code returned by the third-party service.
   * @param thirdPartyMessage
   *     the detailed error message describing the error returned by the
   *     third-party service.
   */
  private SendSmsException(@Nullable final Phone phone, @Nullable final List<Phone> phones,
      final String thirdPartyCode, final String thirdPartyMessage) {
    super(ErrorCode.SEND_SMS_FAILED);
    this.phone = phone;
    this.phones = phones;
    this.thirdPartyCode = thirdPartyCode;
    this.thirdPartyMessage = thirdPartyMessage;
    if (phone != null) {
      this.addParam("phone", this.phone.toString());
    } else if (phones != null) {
      final List<String> numbers = this.phones.stream().map(Phone::toString).toList();
      this.addParam("phone", ObjectUtils.toString(numbers));
    } else {
      this.addParam("phone", null);
    }
    this.addParam("third_party_code", this.thirdPartyCode);
    this.addParam("third_party_message", this.thirdPartyMessage);
  }

  public Phone getPhone() {
    return phone;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public String getThirdPartyCode() {
    return thirdPartyCode;
  }

  public String getThirdPartyMessage() {
    return thirdPartyMessage;
  }
}
