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
import java.util.List;

import ltd.qubit.commons.util.pair.KeyValuePair;
import ltd.qubit.model.Field;
import ltd.qubit.model.contact.Phone;

/**
 * 表示手机号码不匹配。
 *
 * @author Haixing Hu
 */
public class MismatchMobileException extends BusinessLogicException {

  private static final long serialVersionUID = -3171777375509325949L;

  private final String name;
  private final Phone expected;
  private final Phone actual;

  public MismatchMobileException(final String name, final Phone expected,
      final Phone actual) {
    super(ErrorCode.MISMATCH_MOBILE, makeParams(name, expected, actual));
    this.name = name;
    this.expected = expected;
    this.actual = actual;
  }

  public String getName() {
    return name;
  }

  public Phone getExpected() {
    return expected;
  }

  public Phone getActual() {
    return actual;
  }

  private static KeyValuePair[] makeParams(final String name,
      final Phone expected, final Phone actual) {
    final List<KeyValuePair> params = new ArrayList<>();
    params.add(new KeyValuePair(Field.NAME, name));
    params.add(new KeyValuePair(Field.EXPECTED, expected));
    params.add(new KeyValuePair(Field.ACTUAL, actual));
    return params.toArray(new KeyValuePair[0]);
  }
}
