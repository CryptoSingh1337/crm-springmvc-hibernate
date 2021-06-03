package com.saransh.utils;

/**
 * Created by CryptoSingh1337 on 6/3/2021
 */

public enum SortUtils {
    SortByFirstName(0), SortByLastName(1), SortByEmail(2);
    private final int value;

    SortUtils(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
