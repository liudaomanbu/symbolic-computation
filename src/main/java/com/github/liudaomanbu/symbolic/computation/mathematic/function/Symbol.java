package com.github.liudaomanbu.symbolic.computation.mathematic.function;

import lombok.NonNull;
import lombok.Value;

/**
 * @author liudaomanbu
 * @date 2018-04-13
 * @implSpec
 * @implNote
 * @since 1.0.0
 **/
@Value(staticConstructor = "create")
public final class Symbol implements Item{
  @NonNull
  private final String string;

}
