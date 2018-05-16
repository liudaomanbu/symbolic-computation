package com.github.liudaomanbu.symbolic.computation.mathematic.function;

import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

/**
 * @author liudaomanbu
 * @date 2018-03-28
 * @implSpec
 * @implNote
 * @since 1.0.0
 **/
@Value
public final class Polynomial {
  public enum Op {
    ADD,SUBTRACT,MULTIPLY,DIVIDE;
  }

  @NonNull
  @NotNull
  private final Op op;

  @NonNull
  @NotNull
  private final Item left;

  @NonNull
  @NotNull
  private final Item right;
}
