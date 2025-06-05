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
 * 表示发送短信失败的异常。
 *
 * @author 胡海星
 */
public class SendSmsException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = 8488280770978042223L;

  private final Phone phone;

  private final List<Phone> phones;

  private final String thirdPartyCode;

  private final String thirdPartyMessage;

  /**
   * 构造一个 {@link SendSmsException} 对象。
   *
   * @param phone
   *     目标电话号码。
   * @param thirdPartyCode
   *     第三方服务返回的错误代码。
   * @param thirdPartyMessage
   *     第三方服务返回的描述错误的详细错误消息。
   */
  public SendSmsException(final Phone phone, final String thirdPartyCode,
      final String thirdPartyMessage) {
    this(phone, null, thirdPartyCode, thirdPartyMessage);
  }

  /**
   * 构造一个 {@link SendSmsException} 对象。
   *
   * @param phones
   *     目标电话号码列表。
   * @param thirdPartyCode
   *     第三方服务返回的错误代码。
   * @param thirdPartyMessage
   *     第三方服务返回的描述错误的详细错误消息。
   */
  public SendSmsException(final List<Phone> phones, final String thirdPartyCode,
      final String thirdPartyMessage) {
    this(null, phones, thirdPartyCode, thirdPartyMessage);
  }

  /**
   * 构造一个 {@link SendSmsException} 对象。
   *
   * @param phone
   *     目标电话号码，可以为 null。
   * @param phones
   *     目标电话号码列表，可以为 null。
   * @param thirdPartyCode
   *     第三方服务返回的错误代码。
   * @param thirdPartyMessage
   *     第三方服务返回的描述错误的详细错误消息。
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

  /**
   * 获取目标电话号码（如果发送给单个号码）。
   *
   * @return 目标电话号码，如果发送给多个号码或未指定则返回 null。
   */
  public Phone getPhone() {
    return phone;
  }

  /**
   * 获取目标电话号码列表（如果发送给多个号码）。
   *
   * @return 目标电话号码列表，如果发送给单个号码或未指定则返回 null。
   */
  public List<Phone> getPhones() {
    return phones;
  }

  /**
   * 获取第三方服务返回的错误代码。
   *
   * @return 第三方服务返回的错误代码。
   */
  public String getThirdPartyCode() {
    return thirdPartyCode;
  }

  /**
   * 获取第三方服务返回的详细错误消息。
   *
   * @return 第三方服务返回的详细错误消息。
   */
  public String getThirdPartyMessage() {
    return thirdPartyMessage;
  }
}
