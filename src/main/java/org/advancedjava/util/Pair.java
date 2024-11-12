package org.advancedjava.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pair<T, U> {
    private T first;  // First field of type T
    private U second; // Second field of type U
}

