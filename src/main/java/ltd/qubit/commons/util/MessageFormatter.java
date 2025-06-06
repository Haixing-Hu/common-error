////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;

import jakarta.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ltd.qubit.commons.error.ErrorInfo;
import ltd.qubit.commons.error.ErrorInfoConvertable;
import ltd.qubit.commons.error.NoSuchMessageException;
import ltd.qubit.commons.i18n.message.MessageSource;
import ltd.qubit.commons.lang.EnumUtils;
import ltd.qubit.commons.text.Replacer;
import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.commons.util.pair.KeyValuePairList;
import ltd.qubit.model.Entity;
import ltd.qubit.model.commons.CredentialType;
import ltd.qubit.model.commons.Currency;
import ltd.qubit.model.person.Gender;

import static ltd.qubit.commons.lang.EnumUtils.getEnumClass;

/**
 * 消息格式化工具。
 * <p>
 * 此工具根据预定义规则，格式化消息模板，生成最终的消息。
 *
 * @author 胡海星
 */
public class MessageFormatter {

  /**
   * 错误消息键的前缀，其值为 {@value}.
   */
  public static final String ERROR_PREFIX = "error.";

  /**
   * 实体类型键的前缀，其值为 {@value}.
   */
  public static final String ENTITY_PREFIX = "entity.";

  /**
   * 字段名键的前缀，其值为 {@value}.
   */
  public static final String FIELD_PREFIX = "field.";

  /**
   * 字段名键的中缀，其值为 {@value}.
   */
  public static final String FIELD_INFIX = ".field.";

  /**
   * 操作名称键的前缀，其值为 {@value}.
   */
  public static final String OPERATION_PREFIX = "operation.";

  /**
   * 表示成功或失败的布尔值键的前缀，其值为 {@value}.
   */
  public static final String SUCCESS_PREFIX = "success.";

  /**
   * 附件类型键的前缀，其值为 {@value}.
   */
  public static final String ATTACHMENT_TYPE_PREFIX = "attachment.";

  /**
   * 表示以秒为单位的持续时间的键。
   */
  public static final String DURATION_SECONDS = "time.duration.seconds";

  /**
   * 表示以分钟为单位的持续时间的键。
   */
  public static final String DURATION_MINUTES = "time.duration.minutes";

  /**
   * 表示以小时为单位的持续时间的键。
   */
  public static final String DURATION_HOURS = "time.duration.hours";

  /**
   * 表示以天为单位的持续时间的键。
   */
  public static final String DURATION_DAYS = "time.duration.days";

  /**
   * 表示未知值的键。
   */
  public static final String UNKNOWN = "unknown";

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final Locale locale;
  private final MessageSource messageSource;

  /**
   * 构造一个 {@link MessageFormatter} 对象。
   *
   * @param locale
   *     当前地区的 {@link Locale} 对象。
   * @param messageSource
   *     用于获取消息模板的 {@link MessageSource} 对象。
   */
  public MessageFormatter(final Locale locale, final MessageSource messageSource) {
    this.locale = locale;
    this.messageSource = messageSource;
  }

  /**
   * 获取当前地区的 {@link Locale} 对象。
   *
   * @return
   *     当前地区的 {@link Locale} 对象。
   */
  public final Locale getLocale() {
    return locale;
  }

  /**
   * 获取用于获取消息模板的 {@link MessageSource} 对象。
   *
   * @return
   *     用于获取消息模板的 {@link MessageSource} 对象。
   */
  public final MessageSource getMessageSource() {
    return messageSource;
  }

  /**
   * 获取格式化消息。
   *
   * <p>注意：此函数只能格式化包含形如"{0}", "{1}"这样占位符的消息模板。</p>
   *
   * @param key
   *     消息模板的主键。
   * @param params
   *     用于格式化消息的参数。
   * @return
   *     格式化后的消息。
   */
  public String getMessage(final String key, final Object ... params) {
    try {
      return messageSource.getMessage(key, params, locale);
    } catch (final NoSuchMessageException exception) {
      logger.warn("Cannot find the message template for '{}'.", key);
      return key;
    }
  }

  /**
   * 从指定的错误异常对象获取格式化后的错误消息。
   *
   * @param e
   *     指定的错误异常对象。
   */
  public final <T extends Throwable & ErrorInfoConvertable>
  String getErrorMessage(final T e) {
    final ErrorInfo info = e.toErrorInfo();
    return getErrorMessage(info.getCode(), info.getParams());
  }

  /**
   * 从指定的错误信息对象获取格式化后的错误消息。
   *
   * @param error
   *     指定的错误信息对象。
   */
  public final String getErrorMessage(final ErrorInfo error) {
    if (error.getParams() == null) {
      return getErrorMessage(error.getCode());
    } else {
      return getErrorMessage(error.getCode(), error.getParams().toArray());
    }
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final String getErrorMessage(final String errorCode,
      final KeyValuePair... errorParams) {
    return getErrorMessage(errorCode, KeyValuePairList.ofArray(errorParams));
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final <E extends Enum<E>> String getErrorMessage(final E errorCode,
      final KeyValuePair... errorParams) {
    return getErrorMessage(errorCode.name(), KeyValuePairList.ofArray(errorParams));
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final String getErrorMessage(final String errorCode,
      final KeyValuePairList errorParams) {
    final String messageKey = ERROR_PREFIX + errorCode.toLowerCase();
    final List<String> params = new ArrayList<>();
    final String originalTemplate = getMessage(messageKey);
    if (originalTemplate == null) {
      final String message = "Cannot find the message template for " +  messageKey;
      logger.error(message);
      return message;
    }
    final String template = translateTemplate(originalTemplate, errorParams, params);
    logger.debug("Getting message of template '{}': {}", template, params);
    return MessageFormat.format(template, params.toArray());
  }

  /**
   * 从指定的错误代码和参数获取格式化后的错误消息。
   *
   * @param errorCode
   *     指定的错误代码。
   * @param errorParams
   *     指定的错误参数。
   */
  public final <E extends Enum<E>> String getErrorMessage(final E errorCode,
      final KeyValuePairList errorParams) {
    return getErrorMessage(errorCode.name(), errorParams);
  }

  private String translateTemplate(@NotNull final String template,
      final KeyValuePairList params, final List<String> translatedParams) {
    assert template != null;
    int index = 0;
    translatedParams.clear();
    String result = template;
    final Replacer replacer = new Replacer().ignoreCase(false);
    for (final KeyValuePair param : params) {
      final String key = param.getKey();
      final String value = param.getValue();
      final String placeholder = "{" + key + "}";
      if (result != null && result.contains(placeholder)) {
        final String replaced = "{" + index + "}";
        result = replacer.searchForSubstring(placeholder)
                         .replaceWithString(replaced)
                         .applyTo(result);
        translatedParams.add(translateValue(key, value, params));
        ++index;
      }
    }
    logger.debug("Translate the error message template from '{}' to '{}'", template, result);
    return result;
  }

  private String translateValue(final String key, final String value,
      final KeyValuePairList params) {
    if (key.equals("entity") || key.endsWith("_entity")) {
      return getEntity(value);
    }
    if (key.equals("field") || key.endsWith("_field")) {
      return getField(value);
    }
    if (key.equals("gender") || key.equals("_gender")) {
      return getEnumLocalizedName(Gender.class, value);
    }
    if (key.equals("credential_type") || key.equals("_credential_type")) {
      return getEnumLocalizedName(CredentialType.class, value);
    }
    if (key.equals("currency") || key.equals("_currency")) {
      return getEnumLocalizedName(Currency.class, value);
    }
    if (key.equals("duration") || key.endsWith("_duration")) {
      return getDuration(value);
    }
    if (key.equals("file_size") || key.endsWith("_file_size")) {
      return getFileSize(value);
    }
    if (key.equals("success")
        && (value == null
          || value.isEmpty()
          || value.equalsIgnoreCase("true")
          || value.equalsIgnoreCase("false"))) {
      return getSuccessValue(value);
    }
    if (key.equals("status") || key.equals("_status")) {
      if (value == null || value.isEmpty()) {
        return getMessage(UNKNOWN);
      } else {
        return getStatus(key, value, params);
      }
    }
    return value;
  }

  /**
   * 获取实体的本地化显示名称。
   *
   * @param entity
   *     实体的名称。可以为 {@code null}。
   * @return
   *     实体的本地化显示名称。
   */
  public String getEntity(@Nullable final String entity) {
    if (entity == null) {
      return getMessage(UNKNOWN);
    }
    //  final String key = ENTITY_PREFIX + entity.toLowerCase();
    //  return getMessage(key);
    return getEnumLocalizedName(Entity.class, entity);
  }

  /**
   * 获取字段的本地化显示名称。
   *
   * @param field
   *     字段的名称。可以为 {@code null}。
   * @return
   *     字段的本地化显示名称。
   */
  public String getField(@Nullable final String field) {
    if (field == null) {
      return getMessage(UNKNOWN);
    }
    final String key = FIELD_PREFIX + field.toLowerCase();
    return getMessage(key);
  }

  /**
   * 获取实体字段的本地化显示名称。
   *
   * @param entity
   *     实体的名称。可以为 {@code null}。
   * @param field
   *     字段的名称。可以为 {@code null}。
   * @return
   *     实体字段的本地化显示名称。
   */
  public String getField(@Nullable final String entity, @Nullable final String field) {
    if (entity == null || field == null) {
      return getMessage(UNKNOWN);
    }
    final String key = entity.toLowerCase() + FIELD_INFIX + field.toLowerCase();
    return getMessage(key);
  }

  /**
   * 获取操作的本地化显示名称。
   *
   * @param operation
   *     操作的名称。可以为 {@code null}。
   * @param entity
   *     实体名称。
   * @return
   *     操作的本地化显示名称。
   */
  public String getOperation(@Nullable final String operation, @Nullable final String entity) {
    if (operation == null) {
      return getMessage(UNKNOWN);
    }
    final String key = OPERATION_PREFIX + operation.toLowerCase();
    if (entity == null) {
      return getMessage(key);
    } else {
      return getMessage(key, getEntity(entity));
    }
  }

  /**
   * 获取枚举值的本地化显示名称。
   *
   * @param cls
   *     枚举的类型。
   * @param name
   *     枚举值的名称。可以为 {@code null}。
   * @return
   *     枚举值的本地化显示名称。
   */
  public String getEnumLocalizedName(final Class<? extends Enum<?>> cls,
          @Nullable final String name) {
    if (name == null || name.isEmpty()) {
      return getMessage(UNKNOWN);
    }
    final String enumName = name.toUpperCase();
    final Enum<?> value = EnumUtils.valueOf(cls, enumName);
    if (value == null) {
      logger.error("Unknown localized name of '{}' of the enumeration class {}",
          enumName, cls);
      return enumName;
    } else {
      return EnumUtils.getLocalizedName(locale, value);
    }
  }

  private static final long SECONDS_PER_MINUTE = 60L;

  private static final long SECONDS_PER_HOUR = 60L * 60L;

  private static final long SECONDS_PER_DAY = 60L * 60L * 24L;

  /**
   * 将以秒为单位的持续时间转换为本地化的显示字符串。
   *
   * @param seconds
   *     以秒为单位的持续时间的字符串表示。
   * @return
   *     本地化的持续时间显示字符串。
   */
  public String getDuration(final String seconds) {
    return getDuration(Long.parseLong(seconds));
  }

  /**
   * 将以秒为单位的持续时间转换为本地化的显示字符串。
   *
   * @param seconds
   *     以秒为单位的持续时间。
   * @return
   *     本地化的持续时间显示字符串。
   */
  public String getDuration(final long seconds) {
    if (seconds < SECONDS_PER_MINUTE) {
      return getMessage(DURATION_SECONDS, seconds);
    } else if (seconds < SECONDS_PER_HOUR) {
      return getMessage(DURATION_MINUTES, (seconds + SECONDS_PER_MINUTE - 1) / SECONDS_PER_MINUTE);
    } else if (seconds < SECONDS_PER_DAY) {
      return getMessage(DURATION_HOURS, (seconds + SECONDS_PER_HOUR - 1) / SECONDS_PER_HOUR);
    } else {
      return getMessage(DURATION_DAYS, (seconds + SECONDS_PER_DAY - 1) / SECONDS_PER_DAY);
    }
  }

  /**
   * 将以字节为单位的文件大小转换为本地化的显示字符串。
   *
   * @param bytes
   *     以字节为单位的文件大小的字符串表示。
   * @return
   *     本地化的文件大小显示字符串。
   */
  public String getFileSize(final String bytes) {
    return getFileSize(Long.parseLong(bytes));
  }

  /**
   * 将以字节为单位的文件大小转换为本地化的显示字符串。
   *
   * @param bytes
   *     以字节为单位的文件大小。
   * @return
   *     本地化的文件大小显示字符串。
   */
  public String getFileSize(final long bytes) {
    return HumanReadable.formatBytesShort(bytes);
  }

  /**
   * 获取布尔值的本地化显示字符串。
   *
   * @param value
   *     布尔值的字符串表示，即 "true" 或 "false"。
   * @return
   *     布尔值的本地化显示字符串。
   */
  public String getSuccessValue(final String value) {
    final String key;
    if (value == null || value.isEmpty()) {
      return getMessage(UNKNOWN);
    } else {
      return getMessage(SUCCESS_PREFIX + value.toLowerCase());
    }
  }

  /**
   * 获取状态的本地化显示字符串。
   *
   * @param key
   *     状态的键。
   * @param value
   *     状态的值。
   * @param params
   *     其他参数。
   * @return
   *     状态的本地化显示字符串。
   */
  public String getStatus(final String key, final String value, final KeyValuePairList params) {
    final String statusClassKey = key + "_class";
    final String statusClassName = params.get(statusClassKey);
    if (statusClassName == null) {
      return value;
    }
    final Class<? extends Enum<?>> statusClass = getEnumClass(statusClassName);
    if (statusClass == null) {
      return value.toUpperCase();
    } else {
      return getEnumLocalizedName(statusClass, value);
    }
  }
}
