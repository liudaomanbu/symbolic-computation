package com.github.liudaomanbu.symbolic.computation.mathematic.number;

import com.github.liudaomanbu.symbolic.computation.mathematic.structure.Field;
import com.google.common.base.Preconditions;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

/**
 * <p> This class represents the ratio of two {@link BigInteger} numbers.</p>
 *
 * <p> Instances of this class are immutable and can be used to find exact
 * solutions to linear equations with the {@link org.jscience.mathematics.vector.Matrix Matrix}
 * class.</p>
 *
 * @author liudaomanbu
 * @date 2018-03-28
 * @see <a href="http://en.wikipedia.org/wiki/Rational_numbers">
 * Wikipedia: Rational Numbers</a>
 * @since 1.0.0
 **/
@Value
public final class Rational extends RealNumber implements Field<RealNumber> {

  private static final long serialVersionUID = 1L;

  /**
   * The {@link Rational} representing the additive identity.
   */
  public static final Rational ZERO = new Rational(BigInteger.ZERO,
      BigInteger.ONE);

  /**
   * The {@link Rational} representing the multiplicative identity.
   */
  public static final Rational ONE = new Rational(BigInteger.ONE,
      BigInteger.ONE);


  private static Rational create(@NotNull BigInteger dividend, @NotNull BigInteger divisor){
    Preconditions.checkArgument(divisor.isZero(), "divisor can't be zero");
    //TODO normalize写在这?
    return new Rational(dividend,divisor);
  }

  /**
   * Returns the rational number for the specified integer dividend and divisor.
   *
   * @param dividend the dividend value.
   * @param divisor the divisor value.
   * @return <code>dividend / divisor</code>
   * @throws ArithmeticException if <code>divisor == 0</code>
   */
  public static Rational valueOf(long dividend, long divisor) {
    return valueOf(BigInteger.valueOf(dividend), BigInteger.valueOf(divisor));
  }

  /**
   * Returns the rational number for the specified large integer dividend and divisor.
   *
   * @param dividend the dividend value.
   * @param divisor the divisor value.
   * @return <code>dividend / divisor</code>
   * @throws IllegalArgumentException if <code>divisor.isZero()</code>
   */
  public static Rational valueOf(@NotNull BigInteger dividend, @NotNull BigInteger divisor) {
    return create(dividend, divisor).normalize();
  }

  /**
   * Holds the dividend.
   */
  @NotNull
  @NonNull
  private final BigInteger dividend;

  /**
   * Holds the divisor.
   */
  @NotNull
  @NonNull
  private final BigInteger divisor;

  @NotNull
  @Override
  public BigInteger toBigInteger() {
    return dividend.divide(divisor);
  }

  @Override
  public boolean canPerfectToBigInteger() {
    return dividend.remainder(divisor).isZero();
  }

  @NotNull
  @Override
  public BigDecimal toBigDecimal() {
    return BigDecimal.valueOf(dividend).divide(BigDecimal.valueOf(divisor),BigDecimal.DEFAULT_MATH_CONTEXT);
  }

  @Override
  public boolean canPerfectToBigDecimal() {
    try {
      BigDecimal.valueOf(dividend).divide(BigDecimal.valueOf(divisor));
    }catch (ArithmeticException e){
      return false;
    }
    return true;
  }

  @NotNull
  @Override
  public Rational toRational() {
    return this;
  }

  @Override
  public boolean canPerfectToRational() {
    return true;
  }

  /**
   * Indicates if this rational number is equal to zero.
   *
   * @return <code>this == 0</code>
   */
  @Override
  public boolean isZero() {
    return dividend.isZero();
  }


  /**
   * Indicates if this rational number is greater than zero.
   *
   * @return <code>this > 0</code>
   */
  @Override
  public boolean isPositive() {
    return dividend.isPositive();
  }

  /**
   * Indicates if this rational number is less than zero.
   *
   * @return <code>this < 0</code>
   */
  @Override
  public boolean isNegative() {
    return dividend.isNegative();
  }

  /**
   * Returns the closest integer value to this rational number.
   *
   * @return this rational rounded to the nearest integer.
   */
//  public BigInteger round() {
//    BigInteger halfDivisor = divisor.times2pow(-1);
//    return isNegative() ? dividend.subtract(halfDivisor).divide(divisor) :
//        dividend.add(halfDivisor).divide(divisor);
//  }

  /**
   * Returns the opposite of this rational number.
   *
   * @return <code>-this</code>.
   */
  @NotNull
  @Override
  public Rational negate() {
    return Rational.valueOf(dividend.negate(), divisor);
  }

  /**
   * Returns the absolute value of this rational number.
   *
   * @return <code>|this|</code>.
   */
  @NotNull
  @Override
  public Rational abs() {
    return Rational.valueOf(dividend.abs(), divisor);
  }

  public int compareTo(@NotNull Rational that) {
    return this.dividend.multiply(that.divisor).compareTo(
        that.dividend.multiply(this.divisor));
  }

  /**
   * Compares two rational number numerically.
   *
   * @param that the rational number to compare with.
   * @return -1, 0 or 1 as this rational number is numerically less than, equal to, or greater than
   * <code>that</code>.
   */
  @Override
  public int compareTo(@NotNull RealNumber that) {
    return compareTo(that.toRational());
  }

  /**
   * Returns the inverse of this rational number.
   *
   * @return <code>1 / this</code>.
   * @throws ArithmeticException if <code>dividend.isZero()</code>
   */
  @Override
  public Rational inverse() {
    return dividend.isNegative() ? Rational.valueOf(divisor.negate(),
        dividend.negate()) : Rational
        .valueOf(divisor, dividend);
  }

  /**
   * Returns the sum of this rational number with the one specified.
   *
   * @param augend the rational number to be added.
   * @return <code>this + that</code>.
   */
  @NotNull
  public Rational add(
      @NotNull Rational augend) {
    return Rational.valueOf(
        this.dividend.multiply(augend.divisor).add(
            this.divisor.multiply(augend.dividend)),
        this.divisor.multiply(augend.divisor)).normalize();
  }

  @NotNull
  @Override
  public RealNumber add(@NotNull RealNumber augend) {
    if(augend.canPerfectToRational()){
      return add(augend.toRational());
    }
    return augend.add(this);
  }

  /**
   * Returns the difference between this rational number and the one specified.
   *
   * @param subtrahend the rational number to be subtracted.
   * @return <code>this - subtrahend</code>.
   */
  @NotNull
  public Rational subtract(
      @NotNull Rational subtrahend) {
    return Rational.valueOf(
        this.dividend.multiply(subtrahend.divisor).subtract(
            this.divisor.multiply(subtrahend.dividend)),
        this.divisor.multiply(subtrahend.divisor)).normalize();
  }

  @NotNull
  @Override
  public RealNumber subtract(
      @NotNull RealNumber subtrahend) {
    if(subtrahend.canPerfectToRational()){
      return subtract(subtrahend.toRational());
    }
    return add(subtrahend.negate());
  }

  /**
   * Returns the product of this rational number with the specified
   * <code>long</code> multiplier.
   *
   * @param multiplier the <code>long</code> multiplier.
   * @return <code>this · multiplier</code>.
   */
  public Rational multiply(long multiplier) {
    return this.multiply(Rational.valueOf(multiplier, 1));
  }

  /**
   * Returns the product of this rational number with the one specified.
   *
   * @param multiplicand the rational number multiplier.
   * @return <code>this · that</code>.
   */
  @NotNull
  public Rational multiply(
      @NotNull Rational multiplicand) {
    return Rational.valueOf(this.dividend.multiply(multiplicand.dividend),
        this.divisor.multiply(multiplicand.divisor)).normalize();
  }

  @NotNull
  @Override
  public RealNumber multiply(
      @NotNull RealNumber multiplicand) {
    if(multiplicand.canPerfectToRational()){
      return multiply(multiplicand.toRational());
    }
    return multiplicand.multiply(this);
  }

  /**
   * Returns this rational number divided by the one specified.
   *
   * @param that the rational number divisor.
   * @return <code>this / that</code>.
   * @throws ArithmeticException if <code>that.equals(ZERO)</code>
   */
  public Rational divide(
      Rational that) {
    return Rational.valueOf(this.dividend.multiply(that.divisor),
        this.divisor.multiply(that.dividend)).normalize();
  }

  /**
   * Returns the normalized form of this rational.
   *
   * @return this rational after normalization.
   */
  private Rational normalize() {
    if (divisor.isPositive()) {
      BigInteger gcd = dividend.gcd(divisor);
      return gcd.equals(BigInteger.ONE) ? this
          : create(dividend.divide(gcd), divisor.divide(gcd));
    } else {
      return valueOf(dividend.negate(), divisor.negate());
    }
  }
}