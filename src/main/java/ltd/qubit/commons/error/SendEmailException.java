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
 * 表示发送电子邮件失败的异常。
 *
 * @author 胡海星
 */
public class SendEmailException extends ThirdPartyServiceException {

  @Serial
  private static final long serialVersionUID = 6958281472891531001L;

  private final String email;

  private final String thirdPartyCode;

  private final String thirdPartyMessage;

  /**
   * 构造一个 {@link SendEmailException} 对象。
   *
   * @param email
   *     目标电子邮件地址。
   * @param thirdPartyCode
   *     第三方服务返回的错误代码。
   * @param thirdPartyMessage
   *     第三方服务返回的描述错误的详细错误消息。
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

  /**
   * 获取目标电子邮件地址。
   *
   * @return 目标电子邮件地址。
   */
  public String getEmail() {
    return email;
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
