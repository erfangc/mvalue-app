package org.erfangc.spring.models;

import org.erfangc.mvalue.core.income.PropertyAssumptions;
import org.erfangc.mvalue.core.mtg.MtgAssumptions;

/**
 * Created by erfangchen on 5/28/16.
 */
public class Assumptions {
    private MtgAssumptions mtgAssumptions;
    private PropertyAssumptions propertyAssumptions;

    public MtgAssumptions getMtgAssumptions() {
        return mtgAssumptions;
    }

    public void setMtgAssumptions(MtgAssumptions mtgAssumptions) {
        this.mtgAssumptions = mtgAssumptions;
    }

    public PropertyAssumptions getPropertyAssumptions() {
        return propertyAssumptions;
    }

    public void setPropertyAssumptions(PropertyAssumptions propertyAssumptions) {
        this.propertyAssumptions = propertyAssumptions;
    }

    public Assumptions() {
    }

    public Assumptions(MtgAssumptions mtgAssumptions, PropertyAssumptions propertyAssumptions) {

        this.mtgAssumptions = mtgAssumptions;
        this.propertyAssumptions = propertyAssumptions;
    }
}
