/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2006 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package com.github.liudaomanbu.symbolic.computation.mathematic.structure;

import org.jetbrains.annotations.NotNull;

/**
 * This interface represents a structure with a binary additive operation (+), satisfying the group
 * axioms (associativity, neutral element, inverse element and closure).
 *
 * @author liudaomanbu
 * @date 2018-03-28
 * @see <a href="http://en.wikipedia.org/wiki/Mathematical_Group">
 * Wikipedia: Mathematical Group</a>
 * @since 1.0.0
 **/
public interface GroupAdditive<G> extends Structure<G> {

  /**
   * Returns the sum of this object with the one specified.
   *
   * @param augend he object to be added.
   * @return <code>this + augend</code>.
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  @NotNull
  G add(@NotNull G augend);

  /**
   * Returns the additive inverse of this object. It is the object such as
   * <code>this.add(this.negate()) == ZERO</code>,
   * with <code>ZERO</code> being the additive identity.
   *
   * @return <code>-this</code>.
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  @NotNull
  G negate();
}
