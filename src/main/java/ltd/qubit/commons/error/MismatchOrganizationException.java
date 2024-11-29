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
 * @author Haixing Hu
 */
public class MismatchOrganizationException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = 1469136391320113624L;

  private final String name;
  private final Info expectedOrganization;
  private final Info actualOrganization;

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

  public String getName() {
    return name;
  }

  public Info getExpectedOrganization() {
    return expectedOrganization;
  }

  public Info getActualOrganization() {
    return actualOrganization;
  }
}
