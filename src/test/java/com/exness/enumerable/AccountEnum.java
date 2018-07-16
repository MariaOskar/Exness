package com.exness.enumerable;

public enum AccountEnum {

    MINI("Mini"),
    CENT("Cent"),
    CLASSIC("Classic"),
    ECN("ECN");

    String type;

    AccountEnum(String type) {
        this.type = type;
    }
}
