package com.github.liudaomanbu.symbolic.computation.mathematic.number;

import org.jetbrains.annotations.NotNull;

/**
 * @author liudaomanbu
 * @date 2018-04-13
 * @implSpec
 * @implNote
 * @since 1.0.0
 **/
public interface Comparable<T> extends java.lang.Comparable<T> {

  int compareTo(@NotNull T o);

  /**
   * Equal To
   *
   * @param other compare object
   * @return is equal
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  default boolean eq(@NotNull T other) {
    return compareTo(other) == 0;
  }

  /**
   * Not Equal To
   *
   * @param other compare object
   * @return is not equal
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  default boolean ne(@NotNull T other) {
    return !eq(other);
  }

  /**
   * Greater Than
   *
   * @param other compare object
   * @return is Greater Than
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  default boolean gt(@NotNull T other) {
    return compareTo(other) > 0;
  }

  /**
   * Greater Than or Equal to
   *
   * @param other compare object
   * @return is Greater Than or Equal to
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  default boolean ge(@NotNull T other) {
    return compareTo(other) >= 0;
  }

  /**
   * Less Than
   *
   * @param other compare object
   * @return is Less Than
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  default boolean lt(@NotNull T other) {
    return compareTo(other) < 0;
  }

  /**
   * Less Than or Equal to
   *
   * @param other compare object
   * @return is Less Than or Equal to
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  default boolean le(@NotNull T other) {
    return compareTo(other) <= 0;
  }

}
