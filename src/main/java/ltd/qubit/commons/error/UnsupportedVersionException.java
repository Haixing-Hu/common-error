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
 * 表示不支持指定版本的异常。
 *
 * @author 胡海星
 */
public class UnsupportedVersionException extends BusinessLogicException {

  @Serial
  private static final long serialVersionUID = -476273164096743622L;

  private final String version;

  /**
   * 构造一个 {@link UnsupportedVersionException} 对象，表示不支持的版本为空字符串。
   */
  public UnsupportedVersionException() {
    this("");
  }

  /**
   * 使用指定的 {@link Version} 对象构造一个 {@link UnsupportedVersionException} 对象。
   *
   * @param version
   *     不被支持的版本对象。
   */
  public UnsupportedVersionException(final Version version) {
    this(version.toString());
  }

  /**
   * 使用指定的版本字符串构造一个 {@link UnsupportedVersionException} 对象。
   *
   * @param version
   *     不被支持的版本字符串。
   */
  public UnsupportedVersionException(final String version) {
    super(ErrorCode.UNSUPPORTED_VERSION);
    this.version = version;
    this.addParam("version", version);
  }

  /**
   * 获取不被支持的版本字符串。
   *
   * @return 不被支持的版本字符串。
   */
  public String getVersion() {
    return version;
  }
}
