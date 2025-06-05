////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.io.IOException;

import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.client.RestClientException;

import ltd.qubit.commons.io.error.DirectoryAlreadyExistException;
import ltd.qubit.commons.io.error.DirectoryCannotCopyException;
import ltd.qubit.commons.io.error.DirectoryCannotCreateException;
import ltd.qubit.commons.io.error.DirectoryCannotDeleteException;
import ltd.qubit.commons.io.error.DirectoryCannotListException;
import ltd.qubit.commons.io.error.DirectoryCannotMoveException;
import ltd.qubit.commons.io.error.DirectoryCannotReadException;
import ltd.qubit.commons.io.error.DirectoryCannotWriteException;
import ltd.qubit.commons.io.error.DirectoryNotExistException;
import ltd.qubit.commons.io.error.FileAlreadyExistException;
import ltd.qubit.commons.io.error.FileCannotCopyException;
import ltd.qubit.commons.io.error.FileCannotCreateException;
import ltd.qubit.commons.io.error.FileCannotDeleteException;
import ltd.qubit.commons.io.error.FileCannotExecuteException;
import ltd.qubit.commons.io.error.FileCannotMoveException;
import ltd.qubit.commons.io.error.FileCannotReadException;
import ltd.qubit.commons.io.error.FileCannotWriteException;
import ltd.qubit.commons.io.error.FileIsDirectoryException;
import ltd.qubit.commons.io.error.FileIsNotDirectoryException;
import ltd.qubit.commons.io.error.FileNotExistException;

/**
 * 错误码的枚举。
 *
 * @author 胡海星
 */
public enum ErrorCode {
  /**
   * 表示指定的对象已绑定了另一个指定的对象。
   */
  ALREADY_BIND(AlreadyBindException.class),

  /**
   * 表示指定的对象已存在。
   */
  ALREADY_EXIST(DataAlreadyExistException.class),

  /**
   * 表示指定的实体已注册过，无法再次注册.
   */
  ALREADY_REGISTERED(AlreadyRegisteredException.class),

  /**
   * 已退货。
   */
  ALREADY_RETURNED(AlreadyReturnedException.class),

  /**
   * 表示预约已生效不能被删除。
   */
  APPOINTMENT_CANNOT_DELETE(AppointmentCannotDeleteException.class),

  /**
   * 表示该操作需要应用认证通过后才能执行。
   */
  APP_AUTHENTICATION_REQUIRED(AppAuthenticationRequiredException.class),

  /**
   * 表示请求的格式无效。
   */
  BAD_REQUEST(HttpMessageNotWritableException.class),

  /**
   * 表示指定的实体已被标记为已阻止。
   */
  BLOCKED(EntityBlockedException.class),

  /**
   * 表示当前用户阻止了某个用户。
   */
  BLOCK_USER(BlockUserException.class),

  /**
   * 表示当前用户已被其他用户阻止。
   */
  BLOCKED_BY_USER(BlockedByUserException.class),

  /**
   * 表示聊天服务器发生错误。
   */
  CHAT_SERVER_ERROR(ChatServerError.class),

  // /**
  //  * Indicates that the complaint about an entity reported by a user has already
  //  * existed.
  //  */
  // COMPLAINT_EXIST(ComplaintExistException.class),

  /**
   * 表示发生了数据库错误。
   */
  DATABASE_ERROR(DataUpdateFailException.class),

  /**
   * 表示指定的实体已被标记为已删除。
   */
  DELETED(EntityDeletedException.class),

  /**
   * 表示当前用户尝试删除自己时发生错误。
   */
  DELETE_CURRENT_USER(DeleteCurrentUserException.class),

  /**
   * 表示删除一个其字段被其他实体作为外键引用的实体时发生错误。
   */
  DELETE_REFERENCED_FOREIGN_KEY(ForeignKeyConstraintFailException.class),

  /**
   * 表示解密时发生错误。
   */
  DECRYPT_MESSAGE_FAILED(DecryptException.class),

  /**
   * 表示指定的目录已存在。
   */
  DIRECTORY_ALREADY_EXIST(DirectoryAlreadyExistException.class),

  /**
   * 表示指定的目录无法复制。
   */
  DIRECTORY_CANNOT_COPY(DirectoryCannotCopyException.class),

  /**
   * 表示指定的目录无法创建。
   */
  DIRECTORY_CANNOT_CREATE(DirectoryCannotCreateException.class),

  /**
   * 表示指定的目录无法删除。
   */
  DIRECTORY_CANNOT_DELETE(DirectoryCannotDeleteException.class),

  /**
   * 表示无法列出指定的目录内容。
   */
  DIRECTORY_CANNOT_LIST(DirectoryCannotListException.class),

  /**
   * 表示指定的目录无法移动。
   */
  DIRECTORY_CANNOT_MOVE(DirectoryCannotMoveException.class),

  /**
   * 表示指定的目录无法读取。
   */
  DIRECTORY_CANNOT_READ(DirectoryCannotReadException.class),

  /**
   * 表示指定的目录无法写入。
   */
  DIRECTORY_CANNOT_WRITE(DirectoryCannotWriteException.class),

  /**
   * 表示指定的目录不存在。
   */
  DIRECTORY_NOT_EXIST(DirectoryNotExistException.class),

  /**
   * 表示指定的实体已被禁用。
   */
  DISABLED(EntityDisabledException.class),

  /**
   * 对消息计算数字摘要时失败。
   */
  DIGEST_MESSAGE_FAILED(DigestMessageException.class),

  /**
   * 购买者重复。
   */
  DUPLICATE_BUYER(DuplicateBuyerException.class),

  /**
   * 表示唯一字段的输入值与该字段中的现有值重复。
   */
  DUPLICATE_KEY(DuplicateKeyException.class),

  /**
   * 商品重复。
   */
  DUPLICATE_PRODUCT(DuplicateProductException.class),

  /**
   * 重复购买。
   */
  DUPLICATE_PURCHASE(DuplicatePurchaseException.class),

  /**
   * 表示必填字段为空。
   */
  EMPTY_FIELD(NullFieldException.class),

  /**
   * 对消息进行编码时操作失败。
   */
  ENCODING_MESSAGE_FAILED(EncodingMessageException.class),

  /**
   * 表示加密消息失败。
   */
  ENCRYPT_MESSAGE_FAILED(EncryptException.class),

  /**
   * 表示指定的实体已被标记为已取消。
   */
  ENTITY_CANCELLED(EntityCancelledException.class),

  /**
   * 表示指定的实体已被标记为已完成。
   */
  ENTITY_COMPLETED(EntityCompletedException.class),

  /**
   * 表示指定的实体已被标记为已失败。
   */
  ENTITY_FAILED(EntityFailedException.class),

  // /**
  //  * 表示快递系统调用失败。
  //  * <p>
  //  * FIXME: 没有对应异常类，这个错误代码在哪里用到？另外名称不够清晰。
  //  */
  // EXPRESS_GENERATE_FAILURE(ExpressGenerateFailureException.class),

  /**
   * 表示字段的值超出范围。
   */
  FIELD_OUT_OF_RANGE(FieldValueOutOfRangeException.class),

  /**
   * 表示字段的长度超出限制。
   */
  FIELD_TOO_LONG(FieldTooLongException.class),

  /**
   * 表示指定的文件已存在。
   */
  FILE_ALREADY_EXIST(FileAlreadyExistException.class),

  /**
   * 表示指定的文件无法复制。
   */
  FILE_CANNOT_COPY(FileCannotCopyException.class),

  /**
   * 表示指定的文件无法创建。
   */
  FILE_CANNOT_CREATE(FileCannotCreateException.class),

  /**
   * 表示指定的文件无法删除。
   */
  FILE_CANNOT_DELETE(FileCannotDeleteException.class),

  /**
   * 表示指定的文件无法执行。
   */
  FILE_CANNOT_EXECUTE(FileCannotExecuteException.class),

  /**
   * 表示指定的文件无法移动。
   */
  FILE_CANNOT_MOVE(FileCannotMoveException.class),

  /**
   * 表示指定的文件无法读取。
   */
  FILE_CANNOT_READ(FileCannotReadException.class),

  /**
   * 表示指定的文件无法写入。
   */
  FILE_CANNOT_WRITE(FileCannotWriteException.class),

  /**
   * 表示指定的文件是一个目录。
   */
  FILE_IS_DIRECTORY(FileIsDirectoryException.class),

  /**
   * 表示指定的文件不是一个目录。
   */
  FILE_IS_NOT_DIRECTORY(FileIsNotDirectoryException.class),

  /**
   * 表示指定的文件不存在。
   */
  FILE_NOT_EXIST(FileNotExistException.class),

  /**
   * 表示好友关系已存在。
   */
  FRIEND_EXIST(FriendExistException.class),

  // /**
  //  * Indicates that the friendship request already exist.
  //  */
  // FRIEND_REQUEST_EXIST(),

  /**
   * 表示被监护人未退款。
   */
  WARD_NOT_REFUND(WardNotRefundException.class),

  /**
   * 表示一个人的监护人是他自己。
   */
  GUARDIAN_IS_SELF(GuardianIsSelfException.class),

  /**
   * 表示监护人未购买。
   */
  GUARDIAN_NOT_BUY(GuardianNotBuyException.class),

  /**
   * 表示监护人处于退款中。
   */
  GUARDIAN_IS_REFUNDING(GuardianRefundingException.class),

  /**
   * 表示发生了HTTP请求错误。
   */
  HTTP_ERROR(RestClientException.class),

  /**
   * 表示实体被标记为非活动状态。
   */
  INACTIVE(EntityInactiveException.class),

  /**
   * 表示发生内部错误，通常由程序缺陷引起。
   */
  INTERNAL_ERROR(Exception.class),

  /**
   * 表示枚举值无效。
   */
  INVALID_ENUM_VALUE(InvalidEnumValueException.class),

  /**
   * 表示电子邮件的格式无效。
   */
  INVALID_EMAIL_FORMAT(InvalidFieldFormatException.class),

  /**
   * 表示字段的格式无效。
   */
  INVALID_FIELD_FORMAT(InvalidFieldFormatException.class),

  /**
   * 表示字段值无效。
   */
  INVALID_FIELD_VALUE(InvalidFieldValueException.class),

  /**
   * 表示字段值的字符无效。
   */
  INVALID_FIELD_VALUE_CHARACTER(InvalidFieldValueCharacterException.class),

  /**
   * 表示文件格式无效。
   */
  INVALID_FILE_FORMAT(InvalidFileFormatException.class),

  /**
   * 监护人年龄错误。
   */
  INVALID_GUARDIAN_AGE(InvalidGuardianAgeException.class),

  /**
   * 表示身份证号码的格式无效。
   */
  INVALID_IDENTITY_CARD_FORMAT(InvalidIdentityCardFormatException.class),

  /**
   * 表示JSON对象的格式无效。
   */
  INVALID_JSON_FORMAT(InvalidJsonFormatException.class),

  /**
   * 订单信息错误。
   */
  INVALID_ORDER(InvalidOrderException.class),

  /**
   * 订单客户信息错误。
   */
  INVALID_ORDER_CLIENT(InvalidOrderClientException.class),

  /**
   * 表示密码的格式无效。
   */
  INVALID_PASSWORD_FORMAT(InvalidPasswordFormatException.class),

  /**
   * 表示电话号码的格式无效。
   */
  INVALID_PHONE_FORMAT(InvalidFieldFormatException.class),

  /**
   * 产品价格错误。
   */
  INVALID_PRICE(InvalidPriceException.class),

  /**
   * 产品数量错误错误。
   */
  INVALID_PRODUCT_COUNT(InvalidProductCountException.class),

  /**
   * 退款金额错误。
   */
  INVALID_REFUNDABLE(InvalidRefundableException.class),

  /**
   * 此错误表示消息的数字签名错误。
   */
  INVALID_SIGNATURE(InvalidSignatureException.class),

  /**
   * SQL语法错误。
   */
  INVALID_SQL_SYNTAX(InvalidSqlSyntaxException.class),

  /**
   * 表示状态错误。
   */
  INVALID_STATUS(InvalidStatusException.class),

  /**
   * 表示应用或用户的访问令牌无效。
   */
  INVALID_TOKEN(InvalidAccessTokenException.class),

  /**
   * 表示类型错误。
   */
  INVALID_TYPE(InvalidTypeException.class),

  /**
   * 表示用户名的格式无效。
   */
  INVALID_USERNAME_FORMAT(InvalidUsernameFormatException.class),

  /**
   * 表示发生了其他I/O错误。
   */
  IO_ERROR(IOException.class),

  /**
   * Indicates that the operation cannot be performed since the limitation of
   * the system has been reached.
   */
  // LIMITATION_REACHED(),

  /**
   * 表示实体已被锁定。
   */
  LOCKED(EntityLockedException.class),

  /**
   * 表示该操作需要用户登录系统后才能执行。
   */
  LOGIN_REQUIRED(LoginRequiredException.class),

  /**
   * 表示该操作需要当前用户登出系统后才能执行。
   */
  LOGOUT_REQUIRED(LogoutRequiredException.class),

  /**
   * 用于指示用户尝试与自己成为好友。
   */
  MAKE_FRIEND_WITH_SELF(MakeFriendWithSelfException.class),

  /**
   * 表示医疗服务未预约。
   */
  MEDICAL_SERVICE_NOT_APPOINTMENT(MedicalServiceNotAppointmentException.class),

  /**
   * 表示医疗服务可用次数为零。
   */
  MEDICAL_SERVICE_COUNT_ZERO(MedicalServiceCountZeroException.class),

  /**
   * 表示出生日期不匹配。
   */
  MISMATCH_BIRTHDAY(MismatchBirthdayException.class),

  /**
   * 表示证件不匹配。
   */
  MISMATCH_CREDENTIAL(MismatchCredentialException.class),

  /**
   * 表示货币单位不匹配。
   */
  MISMATCH_CURRENCY(MismatchCurrencyException.class),

  /**
   * 表示电子邮箱不匹配。
   */
  MISMATCH_EMAIL(MismatchEmailException.class),

  /**
   * 表示性别不匹配。
   */
  MISMATCH_GENDER(MismatchGenderException.class),

  /**
   * 表示手机号码不匹配。
   */
  MISMATCH_MOBILE(MismatchMobileException.class),

  /**
   * 支付信息不匹配。
   */
  MISMATCH_PAYMENT(MismatchPaymentException.class),

  /**
   * 表示姓名不匹配。
   */
  MISMATCH_PERSON_NAME(MismatchPersonNameException.class),

  /**
   * 表示所属机构不匹配。
   */
  MISMATCH_ORGANIZATION(MismatchOrganizationException.class),

  /**
   * 用于指示产品必须由购买者本人购买。
   */
  MUST_BUY_FOR_SELF(MustBuyForSelfException.class),

  /**
   * 表示产品库存不足。
   */
  NO_ENOUGH_INVENTORY(NoEnoughInventoryException.class),

  /**
   * 表示当前用户没有执行该操作的权限。
   */
  NO_PRIVILEGE(NoPrivilegeException.class),

  /**
   * 表示指定的实体未被标记为已删除。
   */
  NOT_DELETED(EntityNotDeletedException.class),

  /**
   * 表示指定的实体不存在。
   */
  NOT_EXIST(DataNotExistException.class),

  /**
   * 表示指定的实体尚未绑定。
   */
  NOT_BOUND(NotBoundException.class),

  /**
   * 未购买过。
   */
  NOT_PURCHASED(NotPurchasedException.class),

  /**
   * 表示指定的实体尚未注册。
   */
  NOT_REGISTERED(NotRegisteredException.class),

  /**
   * 表示指定的实体已过时。
   */
  OBSOLETED(EntityObsoletedException.class),

  /**
   * 表示要执行的操作被系统禁止。
   */
  OPERATION_FORBIDDEN(OperationForbiddenException.class),

  /**
   * 表示操作过于频繁。
   */
  OPERATION_TOO_FREQUENT(OperationTooFrequentException.class),

  /**
   * 表示标签的反向是标签本身。
   */
  OPPOSITE_IS_SELF(OppositeIsSelfException.class),

  /**
   * 表示订单已过期。
   */
  ORDER_EXPIRED(OrderExpiredException.class),

  /**
   * 支付的款项不匹配。
   */
  PAID_MONEY_MISMATCH(PaidMoneyMismatchException.class),

  /**
   * 表示标签的父级是标签本身。
   */
  PARENT_IS_SELF(ParentIsSelfException.class),

  /**
   * 表示密码不匹配。
   */
  PASSWORD_MISMATCH(PasswordMismatchException.class),

  // /**
  //  * 表示药房系统连接失败。
  //  * <p>
  //  * FIXME: 没有对应异常类，这个错误代码在哪里用到？另外名称不够清晰。
  //  */
  // PHARMACY_CLIENT_FAILURE(Phar),
  //
  // /**
  //  * 表示处方订单不能退货。
  //  */
  // PRESCRIPTION_CANNOT_RETURN(Prescriptionca),
  //
  // /**
  //  * 表示处方没有找到可供货药店。
  //  */
  // PRESCRIPTION_CANNOT_FIND_SELLER(PrescriptionCanot),

  /**
   * 表示产品不能被退货。
   */
  PRODUCT_CANNOT_RETURN(ProductCannotReturnException.class),

  /**
   * 表示指定的实体是只读的，不能修改。
   */
  READONLY(ReadonlyEntityException.class),

  /**
   * 表示在添加或更新具有不存在外键的实体时发生错误。
   */
  REFER_TO_NON_EXIST_FOREIGN_KEY(ForeignKeyConstraintFailException.class),

  /**
   * HTTP请求的方法不被支持。
   */
  REQUEST_METHOD_NOT_SUPPORTED(Exception.class),

  /**
   * 退货后再次重购。
   */
  RETURNED_PURCHASE_AGAIN(ReturnedPurchaseAgainException.class),

  /**
   * 表示实体已被审核，因此无法更新或删除。
   */
  REVIEWED(EntityReviewedException.class),

  /**
   * 表示安全密钥不匹配。
   */
  SECURITY_KEY_MISMATCH(SecurityKeyMismatchException.class),

  /**
   * 表示产品的销售尚未开始。
   */
  SELLING_NOT_START(SellingNotStartException.class),

  /**
   * 表示产品的销售已经结束。
   */
  SELLING_HAS_END(SellingHasEndException.class),

  /**
   * 表示发送电子邮件失败。
   */
  SEND_EMAIL_FAILED(SendEmailException.class),

  /**
   * 表示发送短信失败。
   */
  SEND_SMS_FAILED(SendSmsException.class),

  /**
   * 表示调用第三方服务失败。
   */
  THIRD_PARTY_SERVICE_FAILURE(ThirdPartyServiceException.class),

  /**
   * 表示调用第三方服务时其存取令牌已过期。
   */
  THIRD_PARTY_ACCESS_TOKEN_EXPIRED(ThirdPartyAccessTokenExpiredException.class),

  /**
   * 表示调用第三方服务时其存取令牌不正确。
   */
  THIRD_PARTY_ACCESS_TOKEN_INVALID(ThirdPartyAccessTokenInvalidException.class),

  /**
   * 表示序列化错误。
   */
  SERIALIZATION_ERROR(EntitySerializationException.class),

  /**
   * 表示会话已过期。
   */
  SESSION_EXPIRED(SessionExpiredException.class),

  /**
   * 对消息进行数字签名时操作失败。
   */
  SIGN_MESSAGE_FAILED(SignMessageException.class),

  /**
   * 表示操作的目标是当前用户本身。
   */
  TARGET_IS_SELF(TargetIsSelfException.class),

  /**
   * 表示令牌已过期。
   */
  TOKEN_EXPIRED(AccessTokenExpiredException.class),

  /**
   * 表示用户登录失败次数过多。
   */
  TOO_MANY_LOGIN_FAILURES(TooManyLoginFailuresException.class),

  /**
   * 表示应用授权失败次数过多。
   */
  TOO_MANY_AUTHENTICATION_FAILURES(TooManyAuthenticationFailuresException.class),

  // /**
  //  * Indicates that the operation is unnecessary.
  //  */
  // UNNECESSARY_OPERATION(Unnecessary),

  /**
   * 表示没有资格进行续保。
   */
  UNQUALIFIED_RENEWAL(UnqualifiedRenewalException.class),

  /**
   * 表示不支持该算法。
   */
  UNSUPPORTED_ALGORITHM(UnsupportedAlgorithmException.class),

  /**
   * 表示不支持该类。
   */
  UNSUPPORTED_CLASS(UnsupportedClassException.class),

  /**
   * 表示不支持该内容类型。
   */
  UNSUPPORTED_CONTENT_TYPE(UnsupportedContentTypeException.class),

  /**
   * 表示不支持该文件类型。
   */
  UNSUPPORTED_FILE_TYPE(UnsupportedFileTypeException.class),

  /**
   * 表示不支持指定的版本。
   */
  UNSUPPORTED_VERSION(UnsupportedVersionException.class),

  /**
   * 表示要上传的文件太大。
   */
  UPLOAD_FILE_TOO_LARGE(UploadFileTooLargeException.class),

  /**
   * 表示用户名已被占用。
   */
  USERNAME_OCCUPIED(DuplicateKeyException.class),

  /**
   * 表示验证码已过期。
   */
  VERIFY_CODE_EXPIRED(VerifyCodeExpiredException.class),

  /**
   * 表示验证码不匹配。
   */
  VERIFY_CODE_MISMATCH(VerifyCodeMismatchException.class),

  /**
   * 对数字签名进行验证时操作失败。
   */
  VERIFY_SIGNATURE_FAILED(VerifySignatureException.class);

  /**
   * 此错误码对应的异常类。
   */
  private final Class<? extends Exception> exceptionClass;

  /**
   * 构造一个错误码。
   * 
   * @param exceptionClass
   *     此错误码对应的异常类。
   */
  ErrorCode(final Class<? extends Exception> exceptionClass) {
    this.exceptionClass = exceptionClass;
  }

  /**
   * 获取此错误码对应的异常类。
   * 
   * @return 此错误码对应的异常类。
   */
  Class<? extends Exception> getExceptionClass() {
    return exceptionClass;
  }
}
