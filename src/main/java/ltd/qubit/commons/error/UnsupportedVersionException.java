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

import ltd.qubit.commons.util.Version;

/**
 * An exception thrown to indicate the specified version is not supported.
 *
 * @author Haixing Hu
 */
public class UnsupportedVersionException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -476273164096743622L;

  private final String version;

  public UnsupportedVersionException() {
    this("");
  }

  public UnsupportedVersionException(final Version version) {
    this(version.toString());
  }

  public UnsupportedVersionException(final String version) {
    super(ErrorCode.UNSUPPORTED_VERSION);
    this.version = version;
    this.addParam("version", version);
  }

  public String getVersion() {
    return version;
  }
}
