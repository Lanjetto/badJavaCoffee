package com.nexign.coffeeShop.domain;

public enum CupSize {
    S(1), M(1.2), L(1.5), XL(2.);
    private double modifier;

    CupSize(double modifier) {
        this.modifier = modifier;
    }
}
