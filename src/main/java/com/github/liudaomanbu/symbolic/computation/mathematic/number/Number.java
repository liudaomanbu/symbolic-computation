package com.github.liudaomanbu.symbolic.computation.mathematic.number;

import com.github.liudaomanbu.symbolic.computation.mathematic.function.Item;
import com.github.liudaomanbu.symbolic.computation.mathematic.structure.Ring;
import java.io.Serializable;

/**
 * @author liudaomanbu
 * @date 2018-03-28
 * @implSpec
 * @implNote
 * @since 1.0.0
 **/
public interface Number<T extends Number<T>> extends Item,Ring<T>,Serializable {
  /**
   * Indicates if this large integer is equal to ZERO.
   *
   * @return @return <code>this == ZERO</code>
   * @author liudaomanbu
   * @date 2018-05-12
   * @since 1.0.0
   */
  boolean isZero();

}
