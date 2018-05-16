package com.github.liudaomanbu.symbolic.computation.mathematic.structure;

/**
 * This interface represents an algebraic structure in which the operations of addition,
 * subtraction, multiplication and division (except division by zero) may be performed. It is not
 * required for the multiplication to be commutative (non commutative fields are also called
 * division rings or skew fields).
 *
 * @author liudaomanbu
 * @date 2018-03-28
 * @see <a href="http://en.wikipedia.org/wiki/Field_mathematics">
 * Wikipedia: Field (mathematics)</a>
 * @since 1.0.0
 **/
public interface Field<F> extends Ring<F>, GroupMultiplicative<F> {

}