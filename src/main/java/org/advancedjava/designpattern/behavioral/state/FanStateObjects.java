package org.advancedjava.designpattern.behavioral.state;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FanStateObjects {
    public final FanState offState = new OffState();
    public final FanState lowState = new LowState();
    public final FanState mediumState = new MediumState();
    public final FanState highState = new HighState();
}
