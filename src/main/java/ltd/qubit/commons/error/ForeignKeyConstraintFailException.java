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
 * Thrown to indicate the failure of a foreign key constraint.
 *
 * @author Haixing Hu
 */
public class ForeignKeyConstraintFailException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = - 4781962031198705900L;

  private final DaoOperation operation;
  private final String field;
  private final String referenceEntity;
  private final String referenceField;

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

  public DaoOperation getOperation() {
    return operation;
  }

  public String getField() {
    return field;
  }

  public String getReferenceEntity() {
    return referenceEntity;
  }

  public String getReferenceField() {
    return referenceField;
  }
}
