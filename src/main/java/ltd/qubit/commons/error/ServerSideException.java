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
import java.io.Serializable;
import java.util.Collections;

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
    implements ErrorInfoConvertable, Serializable {

  @Serial
  private static final long serialVersionUID = -1518045055520365532L;

  private final ErrorType type;
  private final ErrorCode code;
  private KeyValuePairList params;

  /**
   * 使用指定的错误类型、错误代码和参数构造一个 {@link ServerSideException} 对象。
   *
   * @param type
   *     错误类型。
   * @param code
   *     错误代码。
   * @param params
   *     与此错误相关的参数。
   */
  public ServerSideException(final ErrorType type, final ErrorCode code,
      final KeyValuePair ... params) {
    super(code.name());
    this.type = type;
    this.code = code;
    this.params = KeyValuePairList.ofArray(params);
  }

  /**
   * 使用指定的错误类型、错误代码和参数列表构造一个 {@link ServerSideException} 对象。
   *
   * @param type
   *     错误类型。
   * @param code
   *     错误代码。
   * @param params
   *     与此错误相关的参数列表。
   */
  public ServerSideException(final ErrorType type, final ErrorCode code,
      final KeyValuePairList params) {
    super(code.name());
    this.type = type;
    this.code = code;
    this.params = params;
  }

  /**
   * 使用指定的错误类型、错误代码和根本原因构造一个 {@link ServerSideException} 对象。
   *
   * @param type
   *     错误类型。
   * @param code
   *     错误代码。
   * @param cause
   *     导致此错误的根本原因。
   */
  public ServerSideException(final ErrorType type, final ErrorCode code,
      final Throwable cause) {
    super(code.name(), cause);
    this.type = type;
    this.code = code;
    this.params = KeyValuePairList.of("cause", getRootCauseMessage(cause));
  }

  /**
   * 获取此错误的类型。
   *
   * @return 此错误的类型。
   */
  public final ErrorType getType() {
    return type;
  }

  /**
   * 获取此错误的错误代码。
   *
   * @return 此错误的错误代码。
   */
  public final ErrorCode getCode() {
    return code;
  }

  /**
   * 获取与此错误相关的参数列表。
   *
   * @return 与此错误相关的参数列表。
   */
  public final KeyValuePairList getParams() {
    return params;
  }

  /**
   * 设置与此错误相关的参数列表。
   *
   * @param params
   *     要设置的参数列表。
   */
  public final void setParams(final KeyValuePairList params) {
    this.params = params;
  }

  /**
   * 设置与此错误相关的参数。
   *
   * @param params
   *     要设置的参数数组。
   */
  public final void setParams(final KeyValuePair ...  params) {
    this.params = KeyValuePairList.ofArray(params);
  }

  /**
   * 添加一个与此错误相关的参数。
   *
   * @param param
   *     要添加的参数。
   */
  public final void addParam(final KeyValuePair param) {
    this.params.add(param);
  }

  /**
   * 添加一个与此错误相关的参数键值对。
   *
   * @param key
   *     参数的键。
   * @param value
   *     参数的值。
   */
  public final void addParam(final String key, final Object value) {
    this.params.add(new KeyValuePair(key, value));
  }

  /**
   * 添加多个与此错误相关的参数。
   *
   * @param params
   *     要添加的参数数组。
   */
  public final void addParams(final KeyValuePair ...  params) {
    Collections.addAll(this.params, params);
  }

  /**
   * 返回此错误的详细消息字符串。
   *
   * @return 此错误的详细消息字符串。
   */
  @Override
  public String getMessage() {
    final StringBuilder builder = new StringBuilder();
    builder.append(code);
    if ((params != null) && (!params.isEmpty())) {
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

  /**
   * 返回此错误的本地化描述。
   * <p>
   * 子类可以覆盖此方法以生成特定于语言环境的消息。
   * 对于不覆盖此方法的子类，默认实现返回与 {@code getMessage()} 相同的结果。
   *
   * @return 此错误的本地化描述。
   */
  @Override
  public String getLocalizedMessage() {
    // FIXME: 实现获取本地化错误消息
    return this.getMessage();
  }

  /**
   * 将此错误信息转换为 {@link ErrorInfo} 对象。
   *
   * @return 表示此错误信息的 {@link ErrorInfo} 对象。
   */
  @Override
  public ErrorInfo toErrorInfo() {
    return new ErrorInfo(type.name(), code.name(), params);
  }

  /**
   * 根据实体类型获取实体名称，通常用于错误消息中。
   *
   * @param entityType
   *     实体类型，可以为 null。
   * @return 转换后的实体名称 (lower_underscore格式)，如果输入为 null 则返回 null。
   */
  public static String getEntityName(@Nullable final Class<?> entityType) {
    return getEntityName(entityType == null ? null : entityType.getSimpleName());
  }

  /**
   * 根据实体名称字符串获取规范化的实体名称，通常用于错误消息中。
   *
   * @param entityName
   *     实体名称字符串 (UpperCamel格式)，可以为 null。
   * @return 转换后的实体名称 (lower_underscore格式)，如果输入为 null 则返回 null。
   */
  public static String getEntityName(@Nullable final String entityName) {
    if (entityName == null) {
      return null;
    } else {
      return UPPER_CAMEL.to(LOWER_UNDERSCORE, entityName);
    }
  }

  /**
   * 根据属性名称获取规范化的字段名称，通常用于错误消息中。
   *
   * @param propertyName
   *     属性名称 (lowerCamel格式)，可以为 null。
   * @return 转换后的字段名称 (lower_underscore格式)，如果输入为 null 则返回 null。
   */
  public static String getFieldName(@Nullable final String propertyName) {
    if (propertyName == null) {
      return null;
    } else {
      return LOWER_CAMEL.to(LOWER_UNDERSCORE, propertyName);
    }
  }

  /**
   * 根据操作名称获取规范化的操作名称，通常用于错误消息中。
   *
   * @param operation
   *     操作名称 (UPPER_UNDERSCORE格式)，可以为 null。
   * @return 转换后的操作名称 (lower_underscore格式)，如果输入为 null 则返回 null。
   */
  public static String getOperationName(@Nullable final String operation) {
    if (operation == null) {
      return null;
    } else {
      return UPPER_UNDERSCORE.to(LOWER_UNDERSCORE, operation);
    }
  }

  /**
   * 根据实体类型获取表名称，通常用于数据库相关的错误消息中。
   *
   * @param entityType
   *     实体类型，可以为 null。
   * @return 转换后的表名称 (lower_underscore格式)，如果输入为 null 则返回 null。
   */
  public static String getTableName(@Nullable final Class<?> entityType) {
    if (entityType == null) {
      return null;
    } else {
      return UPPER_CAMEL.to(LOWER_UNDERSCORE, entityType.getSimpleName());
    }
  }
}
