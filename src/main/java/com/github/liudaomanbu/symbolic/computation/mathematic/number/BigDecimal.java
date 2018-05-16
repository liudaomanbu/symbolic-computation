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
public final class BigDecimal extends RealNumber {

  @NotNull
  public static final MathContext DEFAULT_MATH_CONTEXT=MathContext.DECIMAL128;

  @NotNull
  public static final BigDecimal ZERO = valueOf(java.math.BigDecimal.ZERO);

  @NotNull
  public static final BigDecimal TEN = valueOf(java.math.BigDecimal.TEN);

  @NotNull
  private static BigDecimal valueOf(double val) {
    return valueOf(java.math.BigDecimal.valueOf(val));
  }

  @NotNull
  public static BigDecimal valueOf(long val) {
    return valueOf(java.math.BigDecimal.valueOf(val));
  }

  @NotNull
  public static BigDecimal valueOf(@NotNull BigInteger val) {
    return valueOf(new java.math.BigDecimal(val.value()));
  }

  @NotNull
  public static BigDecimal valueOf(@NotNull String val) {
    return valueOf(new java.math.BigDecimal(val));
  }

  @NotNull
  @NonNull
  private final java.math.BigDecimal value;

  @Override
  public byte toByte() {
    return value.byteValue();
  }

  @Override
  public short toShort() {
    return value.shortValue();
  }

  @Override
  public int toInt() {
    return value.intValue();
  }

  @Override
  public long toLong() {
    return value.longValue();
  }

  @NotNull
  @Override
  public BigInteger toBigInteger() {
    return BigInteger.valueOf(value.toBigInteger());
  }

  @Override
  public boolean canPerfectToBigInteger() {
    return eq(valueOf(toBigInteger()));
  }

  @Override
  public float toFloat() {
    return value.floatValue();
  }

  @Override
  public boolean canPerfectToFloat() {
    return eq(valueOf(toFloat()));
  }

  @Override
  public double toDouble() {
    return value.doubleValue();
  }

  @Override
  public boolean canPerfectToDouble() {
    return eq(valueOf(toDouble()));
  }

  @NotNull
  @Override
  public BigDecimal toBigDecimal() {
    return this;
  }

  @Override
  public boolean canPerfectToBigDecimal() {
    return true;
  }

  @NotNull
  @Override
  public Rational toRational() {
    return Rational.valueOf(unscaledValue(), BigInteger.TEN.pow(value.scale()));
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
  public BigDecimal negate() {
    return valueOf(value.negate());
  }

  public int compareTo(@NotNull BigDecimal o) {
    return value.compareTo(o.value);
  }

  @Override
  public int compareTo(@NotNull RealNumber o) {
    if(o.canPerfectToBigDecimal()){
      return compareTo(o.toBigDecimal());
    }
    return toRational().compareTo(o);
  }

  @NotNull
  public BigDecimal add(@NotNull BigDecimal augend) {
    return valueOf(value.add(augend.value));
  }

  @NotNull
  @Override
  public RealNumber add(@NotNull RealNumber augend) {
    if(augend.canPerfectToBigDecimal()){
      return add(augend.toBigDecimal());
    }
    return augend.add(this);
  }

  @NotNull
  public BigDecimal subtract(@NotNull BigDecimal subtrahend) {
    return valueOf(value.subtract(subtrahend.value));
  }

  @NotNull
  @Override
  public RealNumber subtract(@NotNull RealNumber subtrahend) {
    if(subtrahend.canPerfectToBigDecimal()){
      return subtract(subtrahend.toBigDecimal());
    }
    return add(subtrahend.negate());
  }

  @NotNull
  public BigDecimal multiply(@NotNull BigDecimal multiplicand) {
    return valueOf(value.multiply(multiplicand.value));
  }

  @NotNull
  @Override
  public RealNumber multiply(@NotNull RealNumber multiplicand) {
    if(multiplicand.canPerfectToBigDecimal()){
      return multiply(multiplicand.toBigDecimal());
    }
    return multiplicand.multiply(this);
  }

  @NotNull
  public BigDecimal divide(@NotNull BigDecimal divisor) {
    return valueOf(value.divide(divisor.value));
  }

  @NotNull
  public BigDecimal divide(@NotNull BigDecimal multiplicand, @NotNull MathContext mathContext) {
    return valueOf(value.divide(multiplicand.value, mathContext));
  }

  @NotNull
  public BigDecimal pow(int n) {
    return valueOf(value.pow(n));
  }

  @NotNull
  public BigDecimal root(int rootIndex) {
    return root(rootIndex, DEFAULT_MATH_CONTEXT);
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
    BigDecimal x = divide(BigDecimal.valueOf(rootIndex));
    BigDecimal x0 = BigDecimal.ZERO;

    BigDecimal e = BigDecimal.valueOf("0.1");
    for (int i = 1; i < mathContext.getPrecision(); ++i) {
      e = e.divide(BigDecimal.TEN, new MathContext(i + 1, mathContext.getRoundingMode()));
    }

    BigDecimal k = this;
    BigDecimal m = BigDecimal.valueOf(rootIndex);

    while (x.subtract(x0).abs().gt(e)) {
      x0 = x;
      x = x.add(
          k.subtract(x.pow(rootIndex))
              .divide(m.multiply(x.pow(rootIndex - 1)), mathContext));
    }
    return x;
  }

  @NotNull
  public BigInteger unscaledValue() {
    return BigInteger.valueOf(value.unscaledValue());
  }
}
