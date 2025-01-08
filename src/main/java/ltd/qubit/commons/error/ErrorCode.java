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
 * The enumeration of error codes.
 *
 * @author Haixing Hu
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
   * Indicates that the operation cannot be performed until the app get the
   * authentication.
   */
  APP_AUTHENTICATION_REQUIRED(AppAuthenticationRequiredException.class),

  /**
   * Indicates that the format of the request is invalid.
   */
  BAD_REQUEST(HttpMessageNotWritableException.class),

  /**
   * Indicates that the specified entity was marked as blocked.
   */
  BLOCKED(EntityBlockedException.class),

  /**
   * Indicates that the current user blocks a user.
   */
  BLOCK_USER(BlockUserException.class),

  /**
   * Indicates that the current user was blocked by the other user.
   */
  BLOCKED_BY_USER(BlockedByUserException.class),

  /**
   * Indicates an error occurs in the chat server.
   */
  CHAT_SERVER_ERROR(ChatServerError.class),

  // /**
  //  * Indicates that the complaint about an entity reported by a user has already
  //  * existed.
  //  */
  // COMPLAINT_EXIST(ComplaintExistException.class),

  /**
   * Indicates that another database error occurred.
   */
  DATABASE_ERROR(DataUpdateFailException.class),

  /**
   * Indicates that the specified entity was marked as deleted.
   */
  DELETED(EntityDeletedException.class),

  /**
   * Indicates an error occurred while the current user try to delete itself.
   */
  DELETE_CURRENT_USER(DeleteCurrentUserException.class),

  /**
   * Indicates that an error is occurred while deleting an entity with a field
   * referenced by another entity as a foreign key.
   */
  DELETE_REFERENCED_FOREIGN_KEY(ForeignKeyConstraintFailException.class),

  /**
   * 表示解密时发生错误。
   */
  DECRYPT_MESSAGE_FAILED(DecryptException.class),

  /**
   * Indicates that the specified directory already exists.
   */
  DIRECTORY_ALREADY_EXIST(DirectoryAlreadyExistException.class),

  /**
   * Indicates that the specified directory cannot be copied.
   */
  DIRECTORY_CANNOT_COPY(DirectoryCannotCopyException.class),

  /**
   * Indicates that the specified directory cannot be created.
   */
  DIRECTORY_CANNOT_CREATE(DirectoryCannotCreateException.class),

  /**
   * Indicates that the specified directory cannot be deleted.
   */
  DIRECTORY_CANNOT_DELETE(DirectoryCannotDeleteException.class),

  /**
   * Indicates that the specified directory cannot be listed.
   */
  DIRECTORY_CANNOT_LIST(DirectoryCannotListException.class),

  /**
   * Indicates that the specified directory cannot be moved.
   */
  DIRECTORY_CANNOT_MOVE(DirectoryCannotMoveException.class),

  /**
   * Indicates that the specified directory cannot be read.
   */
  DIRECTORY_CANNOT_READ(DirectoryCannotReadException.class),

  /**
   * Indicates that the specified directory cannot be written.
   */
  DIRECTORY_CANNOT_WRITE(DirectoryCannotWriteException.class),

  /**
   * Indicates that the specified directory does not exist.
   */
  DIRECTORY_NOT_EXIST(DirectoryNotExistException.class),

  /**
   * Indicates that the specified entity was disabled.
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
   * Indicates that the input value of an unique field is duplicated with an
   * existing value in that field.
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
   * Indicates that a required field is empty.
   */
  EMPTY_FIELD(NullFieldException.class),

  /**
   * 对消息进行编码时操作失败。
   */
  ENCODING_MESSAGE_FAILED(EncodingMessageException.class),

  /**
   * Indicate that encrypting a message failed.
   */
  ENCRYPT_MESSAGE_FAILED(EncryptException.class),

  /**
   * Indicates that the specified entity was marked as cancelled.
   */
  ENTITY_CANCELLED(EntityCancelledException.class),

  /**
   * Indicates that the specified entity was marked as completed.
   */
  ENTITY_COMPLETED(EntityCompletedException.class),

  /**
   * Indicates that the specified entity was marked as failed.
   */
  ENTITY_FAILED(EntityFailedException.class),

  // /**
  //  * 表示快递系统调用失败。
  //  * <p>
  //  * FIXME: 没有对应异常类，这个错误代码在哪里用到？另外名称不够清晰。
  //  */
  // EXPRESS_GENERATE_FAILURE(ExpressGenerateFailureException.class),

  /**
   * Indicates that the value of a field is out of the range.
   */
  FIELD_OUT_OF_RANGE(FieldValueOutOfRangeException.class),

  /**
   * Indicates that the length of a field exceeds its limitation.
   */
  FIELD_TOO_LONG(FieldTooLongException.class),

  /**
   * Indicates that the specified file already exists.
   */
  FILE_ALREADY_EXIST(FileAlreadyExistException.class),

  /**
   * Indicates that the specified file cannot be copied.
   */
  FILE_CANNOT_COPY(FileCannotCopyException.class),

  /**
   * Indicates that the specified file cannot be created.
   */
  FILE_CANNOT_CREATE(FileCannotCreateException.class),

  /**
   * Indicates that the specified file cannot be deleted.
   */
  FILE_CANNOT_DELETE(FileCannotDeleteException.class),

  /**
   * Indicates that the specified file cannot be executed.
   */
  FILE_CANNOT_EXECUTE(FileCannotExecuteException.class),

  /**
   * Indicates that the specified file cannot be moved.
   */
  FILE_CANNOT_MOVE(FileCannotMoveException.class),

  /**
   * Indicates that the specified file cannot be read.
   */
  FILE_CANNOT_READ(FileCannotReadException.class),

  /**
   * Indicates that the specified file cannot be written.
   */
  FILE_CANNOT_WRITE(FileCannotWriteException.class),

  /**
   * Indicates that the specified file is a directory.
   */
  FILE_IS_DIRECTORY(FileIsDirectoryException.class),

  /**
   * Indicates that the specified file is not a directory.
   */
  FILE_IS_NOT_DIRECTORY(FileIsNotDirectoryException.class),

  /**
   * Indicates that the specified file does not exist.
   */
  FILE_NOT_EXIST(FileNotExistException.class),

  /**
   * Indicates that the friendship already exist.
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
   * Indicates that the guardian of a person is the person itself.
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
   * Indicates that a HTTP request error occurred.
   */
  HTTP_ERROR(RestClientException.class),

  /**
   * Indicates that the entity is marked as inactive.
   */
  INACTIVE(EntityInactiveException.class),

  /**
   * Indicates an internal error occurs, which is usually caused by the bug.
   */
  INTERNAL_ERROR(Exception.class),

  /**
   * Indicates that the value of an enumeration is invalid.
   */
  INVALID_ENUM_VALUE(InvalidEnumValueException.class),

  /**
   * Indicates that the format of the email is invalid.
   */
  INVALID_EMAIL_FORMAT(InvalidFieldFormatException.class),

  /**
   * Indicates that the format of a field is invalid.
   */
  INVALID_FIELD_FORMAT(InvalidFieldFormatException.class),

  /**
   * Indicates that the value of a field is invalid.
   */
  INVALID_FIELD_VALUE(InvalidFieldValueException.class),

  /**
   * Indicates that the characters of the value of a field is invalid.
   */
  INVALID_FIELD_VALUE_CHARACTER(InvalidFieldValueCharacterException.class),

  /**
   * Indicates that the format of a file is invalid.
   */
  INVALID_FILE_FORMAT(InvalidFileFormatException.class),

  /**
   * 监护人年龄错误。
   */
  INVALID_GUARDIAN_AGE(InvalidGuardianAgeException.class),

  /**
   * Indicates that the format of the identity card number is invalid.
   */
  INVALID_IDENTITY_CARD_FORMAT(InvalidIdentityCardFormatException.class),

  /**
   * Indicates that the format of a json object is invalid.
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
   * Indicates that the format of the password is invalid.
   */
  INVALID_PASSWORD_FORMAT(InvalidPasswordFormatException.class),

  /**
   * Indicates that the format of the phone number is invalid.
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
   * Indicates that the app or user's access token is invalid.
   */
  INVALID_TOKEN(InvalidAccessTokenException.class),

  /**
   * 表示类型错误。
   */
  INVALID_TYPE(InvalidTypeException.class),

  /**
   * Indicates that the format of the username is invalid.
   */
  INVALID_USERNAME_FORMAT(InvalidUsernameFormatException.class),

  /**
   * Indicates that another I/O error occurred.
   */
  IO_ERROR(IOException.class),

  /**
   * Indicates that the operation cannot be performed since the limitation of
   * the system has been reached.
   */
  // LIMITATION_REACHED(),

  /**
   * Indicates that an entity was locked.
   */
  LOCKED(EntityLockedException.class),

  /**
   * Indicates that the operation cannot be performed until the user logged into
   * the system.
   */
  LOGIN_REQUIRED(LoginRequiredException.class),

  /**
   * Indicates that the operation cannot be performed until the current user
   * logged out from the system.
   */
  LOGOUT_REQUIRED(LogoutRequiredException.class),

  /**
   * Thrown to indicate that a user try to make a friend with himself.
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
   * Thrown to indicate that a product must be bought for the buyer himself.
   */
  MUST_BUY_FOR_SELF(MustBuyForSelfException.class),

  /**
   * Indicates that there is no enough inventory of the product.
   */
  NO_ENOUGH_INVENTORY(NoEnoughInventoryException.class),

  /**
   * Indicates that the current user has no privilege to perform the operation.
   */
  NO_PRIVILEGE(NoPrivilegeException.class),

  /**
   * Indicates that the specified entity was not marked as deleted.
   */
  NOT_DELETED(EntityNotDeletedException.class),

  /**
   * Indicates that the specified entity does not exist.
   */
  NOT_EXIST(DataNotExistException.class),

  /**
   * Indicates that the specified entity has not been bound.
   */
  NOT_BOUND(NotBoundException.class),

  /**
   * 未购买过。
   */
  NOT_PURCHASED(NotPurchasedException.class),

  /**
   * Indicates that the specified entity has not been registered.
   */
  NOT_REGISTERED(NotRegisteredException.class),

  /**
   * Indicates that the specified entity was obsoleted.
   */
  OBSOLETED(EntityObsoletedException.class),

  /**
   * Indicates that the operation to be performed was forbidden by the system.
   */
  OPERATION_FORBIDDEN(OperationForbiddenException.class),

  /**
   * Indicates that the operations are too frequent.
   */
  OPERATION_TOO_FREQUENT(OperationTooFrequentException.class),

  /**
   * Indicates that the opposite of a label is the label itself.
   */
  OPPOSITE_IS_SELF(OppositeIsSelfException.class),

  /**
   * Indicates that the order has been expired.
   */
  ORDER_EXPIRED(OrderExpiredException.class),

  /**
   * 支付的款项不匹配。
   */
  PAID_MONEY_MISMATCH(PaidMoneyMismatchException.class),

  /**
   * Indicates that the parent of a label is the label itself.
   */
  PARENT_IS_SELF(ParentIsSelfException.class),

  /**
   * Indicates that the password is mismatched.
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
   * Indicates that the specified entity was readonly and cannot be modified.
   */
  READONLY(ReadonlyEntityException.class),

  /**
   * Indicates that an error is occurred while adding or updating an entity with
   * a non-exist foreign key.
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
   * Indicates that the entity has already been reviewed, and thus cannot be
   * updated nor deleted.
   */
  REVIEWED(EntityReviewedException.class),

  /**
   * Indicates that the security key is mismatched.
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
   * Indicates that failed to send an email.
   */
  SEND_EMAIL_FAILED(SendEmailException.class),

  /**
   * Indicates the failure of sending SMS.
   */
  SEND_SMS_FAILED(SendSmsException.class),

  /**
   * 表示调用服务失败。
   */
  THIRD_PARTY_SERVICE_FAILURE(ThirdPartyServiceException.class),

  /**
   * Indicates a serialization error.
   */
  SERIALIZATION_ERROR(EntitySerializationException.class),

  /**
   * Indicates that the session was expired.
   */
  SESSION_EXPIRED(SessionExpiredException.class),

  /**
   * 对消息进行数字签名时操作失败。
   */
  SIGN_MESSAGE_FAILED(SignMessageException.class),

  /**
   * Indicates that the target of an operation is the current user himself.
   */
  TARGET_IS_SELF(TargetIsSelfException.class),

  /**
   * Indicates that the token was expired.
   */
  TOKEN_EXPIRED(AccessTokenExpiredException.class),

  /**
   * Indicates that the user login failed too many times.
   */
  TOO_MANY_LOGIN_FAILURES(TooManyLoginFailuresException.class),

  /**
   * Indicates that the app authorize failed too many times.
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
   * Indicates that the algorithm is not supported.
   */
  UNSUPPORTED_ALGORITHM(UnsupportedAlgorithmException.class),

  /**
   * Indicates that the class is not supported.
   */
  UNSUPPORTED_CLASS(UnsupportedClassException.class),

  /**
   * Indicates that the content type is not supported.
   */
  UNSUPPORTED_CONTENT_TYPE(UnsupportedContentTypeException.class),

  /**
   * Indicates that the file type is not supported.
   */
  UNSUPPORTED_FILE_TYPE(UnsupportedFileTypeException.class),

  /**
   * Indicates that the specified version is not supported.
   */
  UNSUPPORTED_VERSION(UnsupportedVersionException.class),

  /**
   * Indicates that the files to be uploaded is too large.
   */
  UPLOAD_FILE_TOO_LARGE(UploadFileTooLargeException.class),

  /**
   * Indicates that the username was occupied.
   */
  USERNAME_OCCUPIED(DuplicateKeyException.class),

  /**
   * Indicates that the verification code has been expired.
   */
  VERIFY_CODE_EXPIRED(VerifyCodeExpiredException.class),

  /**
   * Indicates that the verification code is matched.
   */
  VERIFY_CODE_MISMATCH(VerifyCodeMismatchException.class),

  /**
   * 对数字签名进行验证时操作失败。
   */
  VERIFY_SIGNATURE_FAILED(VerifySignatureException.class);

  private final Class<? extends Exception> exceptionClass;

  ErrorCode(final Class<? extends Exception> exceptionClass) {
    this.exceptionClass = exceptionClass;
  }

  Class<? extends Exception> getExceptionClass() {
    return exceptionClass;
  }
}
