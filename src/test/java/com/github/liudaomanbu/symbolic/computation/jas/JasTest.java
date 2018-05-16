package com.github.liudaomanbu.symbolic.computation.jas;

import org.jscience.mathematics.function.Polynomial;
import org.jscience.mathematics.function.Variable;
import org.jscience.mathematics.number.Complex;
import org.jscience.mathematics.number.LargeInteger;
import org.junit.jupiter.api.Test;

/**
 * @author liudaomanbu
 * @date 2018-03-28
 * @implSpec
 * @implNote
 * @since 1.0.0
 **/
class JasTest {
  @Test
  void demo(){
    // Defines two local variables (x, y).
    Variable<Complex> varX = new Variable.Local<Complex>("x");
    Variable<Complex> varY = new Variable.Local<Complex>("y");

    // f(x) = ix² + 2x + 1
    Polynomial<Complex> x = Polynomial.valueOf(Complex.ONE, varX);
    System.out.println(x);
    Polynomial<Complex> fx = x.pow(2).times(Complex.I).plus(
        x.times(Complex.valueOf(2, 0)).plus(Complex.ONE));
    System.out.println(fx);
    System.out.println(fx.pow(2));
    System.out.println(fx.differentiate(varX));
    System.out.println(fx.integrate(varY));
    System.out.println(fx.compose(fx));

    // Calculates expression.
    varX.set(Complex.valueOf(2, 3));
    System.out.println(fx.evaluate());
  }

  @Test
  void test(){
    Variable<LargeInteger> varX = new Variable.Local<>("x");
    Polynomial<LargeInteger> x1 = Polynomial.valueOf(LargeInteger.ONE, varX).plus(LargeInteger.valueOf(-100));
    System.out.println(x1);

    Polynomial<LargeInteger> x2 = Polynomial.valueOf(LargeInteger.valueOf(2), varX).plus(LargeInteger.valueOf(-200));
    System.out.println(x2);

    System.out.println(x1.divide(x2));
  }
}
