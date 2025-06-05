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

import ltd.qubit.commons.sql.DaoOperation;

/**
 * 表示外键约束失败的异常。
 *
 * @author 胡海星
 */
public class ForeignKeyConstraintFailException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 4781962031198705900L;

  private final DaoOperation operation;
  private final String field;
  private final String referenceEntity;
  private final String referenceField;

  /**
   * 使用指定的操作、属性、引用的实体和引用的字段构造一个
   * {@link ForeignKeyConstraintFailException} 对象。
   *
   * @param operation
   *     导致外键约束失败的DAO操作。
   * @param property
   *     外键字段的属性名称 (通常是 lowerCamelCase 格式)。
   * @param referenceEntity
   *     外键引用的实体名称。
   * @param referenceField
   *     外键引用的字段名称。
   */
  public ForeignKeyConstraintFailException(final DaoOperation operation,
      final String property, final String referenceEntity,
      final String referenceField) {
    super(getErrorCodeImpl(operation));
    this.operation = operation;
    this.field = getFieldName(property);
    this.referenceEntity = getEntityName(referenceEntity);
    this.referenceField = getFieldName(referenceField);
    this.addParam("operation", this.operation);
    this.addParam("field", this.field);
    this.addParam("reference_entity", this.referenceEntity);
    this.addParam("reference_field", this.referenceField);
  }

  private static ErrorCode getErrorCodeImpl(final DaoOperation operation) {
    switch (operation) {
      case ADD_OR_UPDATE:
        return ErrorCode.REFER_TO_NON_EXIST_FOREIGN_KEY;
      case DELETE:
      default:
        return ErrorCode.DELETE_REFERENCED_FOREIGN_KEY;
    }
  }

  /**
   * 获取导致外键约束失败的DAO操作。
   *
   * @return 导致外键约束失败的DAO操作。
   */
  public DaoOperation getOperation() {
    return operation;
  }

  /**
   * 获取外键字段的名称。
   *
   * @return 外键字段的名称 (通常是 lower_underscore 格式)。
   */
  public String getField() {
    return field;
  }

  /**
   * 获取外键引用的实体名称。
   *
   * @return 外键引用的实体名称 (通常是 lower_underscore 格式)。
   */
  public String getReferenceEntity() {
    return referenceEntity;
  }

  /**
   * 获取外键引用的字段名称。
   *
   * @return 外键引用的字段名称 (通常是 lower_underscore 格式)。
   */
  public String getReferenceField() {
    return referenceField;
  }
}
