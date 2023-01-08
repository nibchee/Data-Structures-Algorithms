package com.Generic;

import java.util.Comparator;

public class CarStringComparator implements Comparator<Car> {
    @Override
    public int compare(Car tcar, Car ocar) {
        return tcar.compareTo(ocar);
    }

}
