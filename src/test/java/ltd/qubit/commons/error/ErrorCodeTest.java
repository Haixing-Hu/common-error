////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.error;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ltd.qubit.commons.i18n.message.ReloadableResourceBundleMessageSource;
import ltd.qubit.commons.reflect.BeanInfo;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.person.User;
import ltd.qubit.model.util.MessageFormatter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static ltd.qubit.commons.text.CaseFormat.LOWER_CAMEL;
import static ltd.qubit.commons.text.CaseFormat.LOWER_UNDERSCORE;
import static ltd.qubit.model.util.MessageFormatter.ERROR_PREFIX;

public class ErrorCodeTest {

  @Test
  public void testErrorMessageTemplateForErrorCodeExist() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasename("classpath:i18n/common-error/error");
    final Locale locale = new Locale("zh", "CN");
    final MessageFormatter formatter = new MessageFormatter(locale, messageSource);
    final List<Executable> executables = new ArrayList<>();
    for (final ErrorCode code : ErrorCode.values()) {
      final String codeName = code.name().toLowerCase();
      final String messageKey = ERROR_PREFIX + codeName;
      final String message = formatter.getMessage(messageKey);
      System.out.println(codeName + ": " + message);
      executables.add(() -> {
        assertNotNull(message,
            "The message for the error code " + code + " should not be null.");
        assertNotEquals(messageKey, message,
            "The message template for the error code " + code + " must exist.");
      });
    }
    assertAll("Check the message templates of all error codes.", executables);
  }

  @Test
  public void testErrorParamsForErrorMessageTemplateExist() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasename("classpath:i18n/common-error/error");
    final Locale locale = new Locale("zh", "CN");
    final MessageFormatter formatter = new MessageFormatter(locale, messageSource);
    final List<Executable> executables = new ArrayList<>();
    for (final ErrorCode code : ErrorCode.values()) {
      if (code == ErrorCode.REQUEST_METHOD_NOT_SUPPORTED) {
        // 跳过这个错误吗，因为无法引入其对应的异常 org.springframework.web.HttpRequestMethodNotSupportedException
        // 总会报错： 找不到jakarta.servlet.ServletException的类文件
        continue;
      }
      final String codeName = code.name().toLowerCase();
      final String messageKey = ERROR_PREFIX + codeName;
      final String message = formatter.getMessage(messageKey);
      final Class<?> cls = code.getExceptionClass();
      // 收集 message 模板中行如 {key} 这样所有的 key
      final List<String> keys = getAllKeysFromTemplate(message);
      for (final String key : keys) {
        System.out.println("Checking the parameter '" + key + "' of the message template of " + code);
        final String property = LOWER_UNDERSCORE.to(LOWER_CAMEL, key);
        executables.add(() ->
          assertTrue(hasDeclaredProperty(cls, property),
              "The parameter key '" + key
              + "' in the message template of the error code " + code
              + " must have a corresponding property '"
              + property
              + "' in the exception class "
              + cls.getName() + ".")
        );
      }
    }
    assertAll("Check the parameters of the message templates of all error codes.", executables);
  }

  private boolean hasDeclaredProperty(final Class<?> cls, final String property) {
    final BeanInfo info = BeanInfo.of(cls);
    return info.hasProperty(property);
  }

  /**
   * 从消息模板中获取所有形如"{key}"这样所有的 key
   *
   * @param messageTemplate
   *     给定的消息模板
   * @return
   *     该消息模板中获取所有形如"{key}"这样所有的"key"的名称列表，其中名称不会重复。
   */
  private List<String> getAllKeysFromTemplate(final String messageTemplate) {
    final String regexp = "\\{([^{}]*)}";
    final Pattern pattern = Pattern.compile(regexp);
    final Matcher matcher = pattern.matcher(messageTemplate);
    final HashSet<String> keysSet = new HashSet<>();
    while (matcher.find()) {
      keysSet.add(matcher.group(1));
    }
    return new ArrayList<>(keysSet);
  }

  @Test
  public void testSessionExpiredException() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasename("classpath:i18n/common-error/error");
    final Locale locale = new Locale("zh", "CN");
    final MessageFormatter formatter = new MessageFormatter(locale, messageSource);

    final SessionExpiredException e1 = new SessionExpiredException(User.class);
    final ErrorInfo i1 = e1.toErrorInfo();
    assertEquals(ErrorType.AUTHENTICATION_ERROR.name(), i1.getType());
    assertEquals(ErrorCode.SESSION_EXPIRED.name(), i1.getCode());
    assertNotNull(i1.getParams());
    assertEquals(1, i1.getParams().size());
    assertEquals("user", i1.getParams().get("entity"));
    final String m1 = formatter.getErrorMessage(i1);
    assertEquals("用户的会话已过期", m1);

    final SessionExpiredException e2 = new SessionExpiredException(App.class);
    final ErrorInfo i2 = e2.toErrorInfo();
    assertEquals(ErrorType.AUTHENTICATION_ERROR.name(), i2.getType());
    assertEquals(ErrorCode.SESSION_EXPIRED.name(), i2.getCode());
    assertNotNull(i2.getParams());
    assertEquals(1, i2.getParams().size());
    assertEquals("app", i2.getParams().get("entity"));
    final String m2 = formatter.getErrorMessage(i2);
    assertEquals("应用的会话已过期", m2);
  }

  @Test
  public void testInvalidTokenException() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasename("classpath:i18n/common-error/error");
    final Locale locale = new Locale("zh", "CN");
    final MessageFormatter formatter = new MessageFormatter(locale, messageSource);

    final InvalidAccessTokenException e1 = new InvalidAccessTokenException(User.class, "invalid-user-token");
    final ErrorInfo i1 = e1.toErrorInfo();
    assertEquals(ErrorType.AUTHENTICATION_ERROR.name(), i1.getType());
    assertEquals(ErrorCode.INVALID_TOKEN.name(), i1.getCode());
    assertNotNull(i1.getParams());
    assertEquals(2, i1.getParams().size());
    assertEquals("user", i1.getParams().get("entity"));
    assertEquals("invalid-user-token", i1.getParams().get("token"));
    final String m1 = formatter.getErrorMessage(i1);
    assertEquals("用户的令牌不正确: invalid-user-token", m1);

    final InvalidAccessTokenException e2 = new InvalidAccessTokenException(App.class, "invalid-app-token");
    final ErrorInfo i2 = e2.toErrorInfo();
    assertEquals(ErrorType.AUTHENTICATION_ERROR.name(), i2.getType());
    assertEquals(ErrorCode.INVALID_TOKEN.name(), i2.getCode());
    assertNotNull(i2.getParams());
    assertEquals(2, i2.getParams().size());
    assertEquals("app", i2.getParams().get("entity"));
    assertEquals("invalid-app-token", i2.getParams().get("token"));
    final String m2 = formatter.getErrorMessage(i2);
    assertEquals("应用的令牌不正确: invalid-app-token", m2);
  }
}
