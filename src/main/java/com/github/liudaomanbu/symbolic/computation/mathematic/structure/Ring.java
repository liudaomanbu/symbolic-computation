package com.github.liudaomanbu.symbolic.computation.mathematic.structure;

import org.jetbrains.annotations.NotNull;

/**
 * This interface represents an algebraic structure with two binary operations addition and
 * multiplication (+ and ·), such that (R, +) is an abelian group, (R, ·) is a monoid and the
 * multiplication distributes over the addition.
 *
 * @author liudaomanbu
 * @date 2018-03-28
 * @see <a href="http://en.wikipedia.org/wiki/Mathematical_ring">
 * Wikipedia: Mathematical Ring</a>
 * @since 1.0.0
 **/
public interface Ring<R> extends GroupAdditive<R> {

  /**
  * Returns the product of this object with the one specified.
  * @param multiplicand the object multiplier.
  * @return <code>this · multiplicand</code>.
  * @throws NullPointerException if the specified object is null
  * @author liudaomanbu
  * @date 2018-05-11
  * @since 1.0.0
  */
  @NotNull
  R multiply(@NotNull R multiplicand);
}
