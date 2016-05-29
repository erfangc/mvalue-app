package org.erfangc.mvalue.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link IRRCalcTest}
 * Created by erfangchen on 5/29/16.
 */
public class IRRCalcTest {

    @Test
    public void irr() throws Exception {
        assertEquals(0.38367, IRRCalc.irr(new double[]{-100,50,50,100}), 0.001);
        // with negative future cf
        assertEquals(0.11939, IRRCalc.irr(new double[]{-100,50,-20,100}), 0.001);
    }

    @Test
    public void irr1() throws Exception {
        assertEquals(0.38367, IRRCalc.irr(new double[]{-100,50,50,100}, 1d), 0.001);
    }

}