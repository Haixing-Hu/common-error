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

import ltd.qubit.model.util.Info;

/**
 * 表示机构不匹配。
 *
 * @author 胡海星
 */
public class MismatchOrganizationException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 1469136391320113624L;

  private final String name;
  private final Info expectedOrganization;
  private final Info actualOrganization;

  /**
   * 使用指定的名称、预期机构和实际机构构造一个 {@link MismatchOrganizationException} 对象。
   *
   * @param name
   *     发生机构不匹配的实体的名称或描述。
   * @param expectedOrganization
   *     预期的机构信息。
   * @param actualOrganization
   *     实际的机构信息。
   */
  public MismatchOrganizationException(final String name,
      final Info expectedOrganization, final Info actualOrganization) {
    super(ErrorCode.MISMATCH_ORGANIZATION);
    this.name = name;
    this.expectedOrganization = expectedOrganization;
    this.actualOrganization = actualOrganization;
    this.addParam("name", name);
    this.addParam("expected_organization", expectedOrganization.getName());
    this.addParam("actual_organization", actualOrganization.getName());
  }

  /**
   * 获取发生机构不匹配的实体的名称或描述。
   *
   * @return 发生机构不匹配的实体的名称或描述。
   */
  public String getName() {
    return name;
  }

  /**
   * 获取预期的机构信息。
   *
   * @return 预期的机构信息。
   */
  public Info getExpectedOrganization() {
    return expectedOrganization;
  }

  /**
   * 获取实际的机构信息。
   *
   * @return 实际的机构信息。
   */
  public Info getActualOrganization() {
    return actualOrganization;
  }
}
