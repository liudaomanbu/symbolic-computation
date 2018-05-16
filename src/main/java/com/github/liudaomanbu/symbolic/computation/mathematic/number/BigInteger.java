package com.github.liudaomanbu.symbolic.computation.mathematic.number;

import java.math.MathContext;
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
@Value(staticConstructor = "valueOf")
public final class BigInteger extends RealNumber {

  @Value(staticConstructor = "create")
  public static class DivideResult {

    @NonNull
    private final BigInteger quotient;
    @NonNull
    private final BigInteger remainder;
  }

  @NotNull
  private static final BigInteger BYTE_MIN_VALUE=BigInteger.valueOf(Byte.MIN_VALUE);
  @NotNull
  private static final BigInteger BYTE_MAX_VALUE=BigInteger.valueOf(Byte.MAX_VALUE);
  @NotNull
  private static final BigInteger SHORT_MIN_VALUE=BigInteger.valueOf(Short.MIN_VALUE);
  @NotNull
  private static final BigInteger SHORT_MAX_VALUE=BigInteger.valueOf(Short.MAX_VALUE);
  @NotNull
  private static final BigInteger INT_MIN_VALUE=BigInteger.valueOf(Integer.MIN_VALUE);
  @NotNull
  private static final BigInteger INT_MAX_VALUE=BigInteger.valueOf(Integer.MAX_VALUE);
  @NotNull
  private static final BigInteger LONG_MIN_VALUE=BigInteger.valueOf(Long.MIN_VALUE);
  @NotNull
  private static final BigInteger LONG_MAX_VALUE=BigInteger.valueOf(Long.MAX_VALUE);

  @NotNull
  public static final BigInteger ZERO = valueOf(java.math.BigInteger.ZERO);
  @NotNull
  public static final BigInteger ONE = valueOf(java.math.BigInteger.ONE);
  @NotNull
  public static final BigInteger TEN = valueOf(java.math.BigInteger.TEN);
  @NotNull
  public static BigInteger valueOf(long val) {
    return valueOf(java.math.BigInteger.valueOf(val));
  }

  @NotNull
  @NonNull
  private final java.math.BigInteger value;

  @Override
  public byte toByte() {
    return value.byteValueExact();
  }

  @Override
  public boolean canPerfectToByte() {
    return ge(BYTE_MIN_VALUE) && le(BYTE_MAX_VALUE);
  }

  @Override
  public short toShort() {
    return value.shortValueExact();
  }

  @Override
  public boolean canPerfectToShort() {
    return ge(SHORT_MIN_VALUE) && le(SHORT_MAX_VALUE);
  }

  @Override
  public int toInt() {
    return value.intValueExact();
  }

  @Override
  public boolean canPerfectToInt() {
    return ge(INT_MIN_VALUE) && le(INT_MAX_VALUE);
  }

  @Override
  public long toLong() {
    return value.longValueExact();
  }

  @Override
  public boolean canPerfectToLong() {
    return ge(LONG_MIN_VALUE) && le(LONG_MAX_VALUE);
  }

  @NotNull
  @Override
  public BigInteger toBigInteger() {
    return this;
  }

  @Override
  public boolean canPerfectToBigInteger() {
    return true;
  }

  @Override
  public float toFloat() {
    return value.floatValue();
  }

  @Override
  public boolean canPerfectToFloat() {
    return toBigDecimal().canPerfectToFloat();
  }

  @Override
  public double toDouble() {
    return value.doubleValue();
  }

  @Override
  public boolean canPerfectToDouble() {
    return toBigDecimal().canPerfectToDouble();
  }

  @NotNull
  @Override
  public BigDecimal toBigDecimal() {
    return BigDecimal.valueOf(this);
  }

  @Override
  public boolean canPerfectToBigDecimal() {
    return true;
  }

  @NotNull
  @Override
  public Rational toRational() {
    return Rational.valueOf(this, ONE);
  }

  @Override
  public boolean canPerfectToRational() {
    return true;
  }

  @Override
  public boolean isZero() {
    return value.signum() == 0;
  }

  @Override
  public boolean isPositive() {
    return value.signum() == 1;
  }

  @Override
  public boolean isNegative() {
    return value.signum() == -1;
  }

  @NotNull
  @Override
  public BigInteger negate() {
    return valueOf(value.negate());
  }

  @Override
  @NotNull
  public BigInteger abs() {
    return valueOf(value.abs());
  }

  public int compareTo(@NotNull BigInteger o) {
    return value.compareTo(o.value);
  }

  @Override
  public int compareTo(@NotNull RealNumber o) {
    if(o.canPerfectToBigInteger()){
      return compareTo(o.toBigInteger());
    }
    return toRational().compareTo(o);
  }

  @NotNull
  public BigInteger add(@NotNull BigInteger augend) {
    return valueOf(value.add(augend.value));
  }

  @NotNull
  @Override
  public RealNumber add(@NotNull RealNumber augend) {
    if(augend.canPerfectToBigInteger()){
      return add(augend.toBigInteger());
    }
    return augend.add(this);
  }

  @NotNull
  public BigInteger subtract(@NotNull BigInteger subtracted) {
    return valueOf(value.subtract(subtracted.value));
  }

  @NotNull
  @Override
  public RealNumber subtract(@NotNull RealNumber subtrahend) {
    if(subtrahend.canPerfectToBigInteger()){
      return subtract(subtrahend.toBigInteger());
    }
    return add(subtrahend.negate());
  }

  @NotNull
  public BigInteger multiply(@NotNull BigInteger multiplicand) {
    return valueOf(value.multiply(multiplicand.value));
  }

  @NotNull
  @Override
  public RealNumber multiply(@NotNull RealNumber multiplicand) {
    if(multiplicand.canPerfectToBigInteger()){
      return multiply(multiplicand.toBigInteger());
    }
    return multiplicand.multiply(this);
  }

  @NotNull
  public BigInteger divide(@NotNull BigInteger divisor) {
    return valueOf(value.divide(divisor.value));
  }

  @NotNull
  public DivideResult divideAndRemainder(@NotNull BigInteger divisor) {
    java.math.BigInteger[] result = value.divideAndRemainder(divisor.value);
    return DivideResult.create(BigInteger.valueOf(result[0]), BigInteger.valueOf(result[1]));
  }

  @NotNull
  public BigInteger remainder(@NotNull BigInteger m) {
    return valueOf(value.remainder(m.value));
  }

  @NotNull
  public BigInteger gcd(@NotNull BigInteger val) {
    return valueOf(value.gcd(val.value));
  }

  @NotNull
  public BigInteger pow(int exponent) {
    return valueOf(value.pow(exponent));
  }

  /**
   * 开rootIndex次根号
   * @param rootIndex 开方次数
   * @return rootIndex次方根
   * @author liudaomanbu
   * @date 2018-05-13
   * @since 1.0.0
   */
  @NotNull
  public BigDecimal root(int rootIndex) {
    return toBigDecimal().root(rootIndex);
  }

  /**
   * 开rootIndex次根号
   * @param rootIndex 开方次数
   * @param mathContext 上下文
   * @return rootIndex次方根
   * @author liudaomanbu
   * @date 2018-05-13
   * @since 1.0.0
   */
  @NotNull
  public BigDecimal root(int rootIndex, @NotNull MathContext mathContext) {
    return toBigDecimal().root(rootIndex,mathContext);
  }

  @NotNull
  public String toString(int radix) {
    return value.toString(radix);
  }
}
