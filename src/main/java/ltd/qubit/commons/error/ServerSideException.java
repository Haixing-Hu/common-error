////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import javax.annotation.Nullable;

import org.springframework.dao.DataAccessException;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.commons.util.pair.KeyValuePairList;

import static ltd.qubit.commons.lang.ThrowableUtils.getRootCauseMessage;
import static ltd.qubit.commons.text.CaseFormat.LOWER_CAMEL;
import static ltd.qubit.commons.text.CaseFormat.LOWER_UNDERSCORE;
import static ltd.qubit.commons.text.CaseFormat.UPPER_CAMEL;
import static ltd.qubit.commons.text.CaseFormat.UPPER_UNDERSCORE;

/**
 * 此异常类是所有服务器端异常的基类。
 *
 * @author 胡海星
 */
public class ServerSideException extends DataAccessException
    implements ErrorInfoConvertable {

  private static final long serialVersionUID = -1518045055520365532L;

  private final ErrorType type;
  private final ErrorCode code;
  private final KeyValuePairList params;

  public ServerSideException(final ErrorType type, final ErrorCode code,
      final KeyValuePair ... params) {
    super(code.name());
    this.type = type;
    this.code = code;
    this.params = KeyValuePairList.ofArray(params);
  }

  public ServerSideException(final ErrorType type, final ErrorCode code,
      final KeyValuePairList params) {
    super(code.name());
    this.type = type;
    this.code = code;
    this.params = params;
  }

  public ServerSideException(final ErrorType type, final ErrorCode code,
      final Throwable cause) {
    super(code.name(), cause);
    this.type = type;
    this.code = code;
    this.params = KeyValuePairList.of("cause", getRootCauseMessage(cause));
  }

  public final ErrorType getType() {
    return type;
  }

  public final ErrorCode getCode() {
    return code;
  }

  public final KeyValuePairList getParams() {
    return params;
  }

  @Override
  public String getMessage() {
    final StringBuilder builder = new StringBuilder();
    builder.append(code);
    if ((params != null) && (params.size() > 0)) {
      builder.append(": [");
      for (int i = 0; i < params.size(); ++i) {
        if (i > 0) {
          builder.append(", ");
        }
        final KeyValuePair pair = params.get(i);
        builder.append(pair.getKey())
               .append(": '")
               .append(pair.getValue())
               .append("'");
      }
      builder.append("]");
    }
    return builder.toString();
  }

  public String getLocalizedMessage() {
    // FIXME: 实现获取本地化错误消息
    return this.getMessage();
  }

  @Override
  public ErrorInfo toErrorInfo() {
    return new ErrorInfo(type.name(), code.name(), params);
  }

  public static String getEntityName(@Nullable final Class<?> entityType) {
    return getEntityName(entityType == null ? null : entityType.getSimpleName());
  }

  public static String getEntityName(@Nullable final String entityName) {
    if (entityName == null) {
      return null;
    } else {
      return UPPER_CAMEL.to(LOWER_UNDERSCORE, entityName);
    }
  }

  public static String getFieldName(@Nullable final String propertyName) {
    if (propertyName == null) {
      return null;
    } else {
      return LOWER_CAMEL.to(LOWER_UNDERSCORE, propertyName);
    }
  }

  public static String getOperationName(@Nullable final String operation) {
    if (operation == null) {
      return null;
    } else {
      return UPPER_UNDERSCORE.to(LOWER_UNDERSCORE, operation);
    }
  }

  public static String getTableName(@Nullable final Class<?> entityType) {
    if (entityType == null) {
      return null;
    } else {
      return UPPER_CAMEL.to(LOWER_UNDERSCORE, entityType.getSimpleName());
    }
  }
}
