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

import ltd.qubit.commons.util.pair.KeyValuePair;

/**
 * 表示实体的对立面是其自身的异常。
 *
 * @author 胡海星
 */
public class OppositeIsSelfException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -3020192983459599035L;

  private final String entity;
  private final String key;
  private final Object value;

  /**
   * 使用指定的实体类型、键和值构造一个 {@link OppositeIsSelfException} 对象。
   *
   * @param entityType
   *     相关实体的类对象。
   * @param key
   *     用于标识实体的键的名称。
   * @param value
   *     用于标识实体的键的值。
   */
  public OppositeIsSelfException(final Class<?> entityType, final String key,
      final Object value) {
    this(getEntityName(entityType), getFieldName(key), value);
  }

  private OppositeIsSelfException(final String entity, final String key,
      final Object value) {
    super(ErrorCode.OPPOSITE_IS_SELF,
        new KeyValuePair("entity", entity),
        new KeyValuePair("key", key),
        new KeyValuePair("value", value));
    this.entity = entity;
    this.key = key;
    this.value = value;
  }

  /**
   * 获取相关实体的名称。
   *
   * @return 相关实体的名称 (通常是 lower_underscore 格式)。
   */
  public final String getEntity() {
    return entity;
  }

  /**
   * 获取用于标识实体的键的名称。
   *
   * @return 用于标识实体的键的名称 (通常是 lower_underscore 格式)。
   */
  public String getKey() {
    return key;
  }

  /**
   * 获取用于标识实体的键的值。
   *
   * @return 用于标识实体的键的值。
   */
  public Object getValue() {
    return value;
  }
}
