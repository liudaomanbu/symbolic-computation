package com.github.liudaomanbu.symbolic.computation.mathematic.number;

import org.jetbrains.annotations.NotNull;

/**
 * @author liudaomanbu
 * @date 2018-03-28
 * @since 1.0.0
 **/
public abstract class RealNumber extends java.lang.Number
    implements  Comparable<RealNumber>, Number<RealNumber> {

  @Override
  public final byte byteValue() {
    return toByte();
  }

  @Override
  public final short shortValue() {
    return toShort();
  }

  @Override
  public final int intValue() {
    return toInt();
  }

  @Override
  public final long longValue() {
    return toLong();
  }

  @Override
  public final float floatValue() {
    return toFloat();
  }

  @Override
  public final double doubleValue() {
    return toDouble();
  }

  public byte toByte() {
    return toBigInteger().toByte();
  }

  public boolean canPerfectToByte() {
    return canPerfectToBigInteger() && toBigInteger().canPerfectToByte();
  }

  public short toShort() {
    return toBigInteger().toShort();
  }

  public boolean canPerfectToShort() {
    return canPerfectToBigInteger() && toBigInteger().canPerfectToShort();
  }

  public int toInt() {
    return toBigInteger().toInt();
  }

  public boolean canPerfectToInt() {
    return canPerfectToBigInteger() && toBigInteger().canPerfectToInt();
  }

  public long toLong() {
    return toBigInteger().toLong();
  }

  public boolean canPerfectToLong() {
    return canPerfectToBigInteger() && toBigInteger().canPerfectToLong();
  };

  /**
   * Returns the value of the specified number as an {@code BigInteger}, which may involve rounding
   * or truncation.
   *
   * @return the numeric value represented by this object after conversion to type {@code
   * BigInteger}.
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  @NotNull
  public abstract BigInteger toBigInteger();

  public abstract boolean canPerfectToBigInteger();

  public float toFloat() {
    return toBigDecimal().toFloat();
  }

  public boolean canPerfectToFloat(){
    return canPerfectToBigDecimal() && toBigDecimal().canPerfectToFloat();
  }

  public double toDouble() {
    return toBigDecimal().toDouble();
  }

  public boolean canPerfectToDouble(){
    return canPerfectToBigDecimal() && toBigDecimal().canPerfectToDouble();
  }

  /**
   * Returns the value of the specified number as an {@code BigDecimal}, which may involve rounding
   * or truncation.
   *
   * @return the numeric value represented by this object after conversion to type {@code
   * BigDecimal}.
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  @NotNull
  public abstract BigDecimal toBigDecimal();

  public abstract boolean canPerfectToBigDecimal();

  /**
   * Returns the value of the specified number as an {@code Rational}, which may involve rounding or
   * truncation.
   *
   * @return the numeric value represented by this object after conversion to type {@code Rational}.
   * @author liudaomanbu
   * @date 2018-05-12
   * @since 1.0.0
   */
  @NotNull
  public abstract Rational toRational();

  public abstract boolean canPerfectToRational();

  /**
   * Indicates if this large integer is greater than ZERO ZERO is not included).
   *
   * @return <code>this > ZERO</code>
   * @author liudaomanbu
   * @date 2018-05-12
   * @since 1.0.0
   */
  public abstract boolean isPositive();

  /**
   * Indicates if this large integer is less than ZERO.
   *
   * @return <code>this < ZERO</code>
   * @author liudaomanbu
   * @date 2018-05-12
   * @since 1.0.0
   */
  public abstract boolean isNegative();

  @SuppressWarnings("unchecked")
  @NotNull
  public RealNumber abs() {
    return isNegative() ? negate() : this;
  }

  /**
   * Absolute value compare
   *
   * @param that compare object
   * @return |this| compareTo |that|
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final int absCompareTo(@NotNull RealNumber that) {
    return abs().compareTo(that.abs());
  }

  /**
   * Absolute value Equal To
   *
   * @param other compare object
   * @return is equal
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final boolean absEq(@NotNull RealNumber other) {
    return absCompareTo(other) == 0;
  }

  /**
   * Absolute value Not Equal To
   *
   * @param other compare object
   * @return is not equal
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final boolean absNe(@NotNull RealNumber other) {
    return !absEq(other);
  }

  /**
   * Absolute value Greater Than
   *
   * @param other compare object
   * @return is Greater Than
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final boolean absGt(@NotNull RealNumber other) {
    return absCompareTo(other) > 0;
  }

  /**
   * Absolute value Greater Than or Equal to
   *
   * @param other compare object
   * @return is Greater Than or Equal to
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final boolean absGe(@NotNull RealNumber other) {
    return absCompareTo(other) >= 0;
  }

  /**
   * Absolute value Less Than
   *
   * @param other compare object
   * @return is Less Than
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final boolean absLt(@NotNull RealNumber other) {
    return absCompareTo(other) < 0;
  }

  /**
   * Absolute value Less Than or Equal to
   *
   * @param other compare object
   * @return is Less Than or Equal to
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  public final boolean absLe(@NotNull RealNumber other) {
    return absCompareTo(other) <= 0;
  }

  /**
   * Returns the minimum of this RealNumber and {@code val}.
   *
   * @param val value with which the minimum is to be computed.
   * @return the Comparable whose value is the lesser of this Comparable and {@code val}.  If they
   * are equal, either may be returned.
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  public final RealNumber min(@NotNull RealNumber val) {
    return lt(val) ? this : val;
  }

  /**
   * Returns the maximum of this RealNumber and {@code val}.
   *
   * @param val value with which the minimum is to be computed.
   * @return the Comparable whose value is the lesser of this Comparable and {@code val}.  If they
   * are equal, either may be returned.
   * @throws NullPointerException if the specified object is null
   * @author liudaomanbu
   * @date 2018-05-11
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  public final RealNumber max(@NotNull RealNumber val) {
    return gt(val) ? this : val;
  }

  /**
   * Returns the difference between this number and the one specified.
   *
   * @param subtrahend the number to be subtracted.
   * @return <code>this - subtrahend</code>.
   * @throws NullPointerException if the specified object is null
   */
  @NotNull
  public RealNumber subtract(@NotNull RealNumber subtrahend) {
    return this.add(subtrahend.negate());
  }

}