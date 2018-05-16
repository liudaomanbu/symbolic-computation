package com.github.liudaomanbu.symbolic.computation.mathematic.number;

import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

/**
 * @author liudaomanbu
 * @date 2018-04-13
 * @implSpec
 * @implNote
 * @since 1.0.0
 **/
@Value(staticConstructor = "create")
public final class Complex implements Number<Complex>{

  @NonNull
  @NotNull
  private final RealNumber real;

  @NonNull
  @NotNull
  private final RealNumber imaginary;

  @Override
  public boolean isZero() {
    return real.isZero() && imaginary.isZero();
  }

  @NotNull
  @Override
  public Complex negate() {
    return create(real.negate(),imaginary.negate());
  }

  @NotNull
  @Override
  public Complex add(@NotNull Complex augend) {
    return create(real.add(augend.real),imaginary.add(augend.imaginary));
  }

  @NotNull
  @Override
  public Complex multiply(@NotNull Complex multiplicand) {
    return create(real.multiply(multiplicand.real).subtract(imaginary.multiply(multiplicand.imaginary)),imaginary.multiply(multiplicand.real).add(real.multiply(multiplicand.imaginary)));
  }

//  @NotNull
//  public Complex divide(@NotNull Complex divisor) {
////    return create();
//    return null;
//  }

}
