package com.github.liudaomanbu.symbolic.computation.mathematic.structure;

import org.jetbrains.annotations.NotNull;

/**
 * This interface represents a structure with a binary multiplicative operation (·), satisfying the
 * group axioms (associativity, neutral element, inverse element and closure).
 *
 * @author liudaomanbu
 * @date 2018-03-28
 * @see <a href="http://en.wikipedia.org/wiki/Mathematical_Group">
 * Wikipedia: Mathematical Group</a>
 * @since 1.0.0
 **/
public interface GroupMultiplicative<G> extends Structure<G> {

  /**
   * Returns the product of this object with the one specified.
   *
   * @param multiplicand the object multiplier.
   * @return <code>this · multiplicand</code>.
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-12
   * @since 1.0.0
   */
  G multiply(@NotNull G multiplicand);

  /**
   * Returns the multiplicative inverse of this object. It it the object such as
   * <code>this.multiply(this.inverse()) == ONE </code>, with <code>ONE</code> being the
   * multiplicative
   * identity.
   *
   * @return <code>ONE / this</code>.
   * @author liudaomanbu
   * @date 2018-05-12
   * @since 1.0.0
   */
  G inverse();

}