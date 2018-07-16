package com.exness.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class CalculateResult {

    int commission;
    @SerializedName("long")
    String longValue;
    String lots_mln_usd;
    String margin;
    String margin_formula1;
    String margin_formula2;
    boolean no_quotes;
    String profit;
    String profit_formula1;
    String profit_formula2;
    @SerializedName("short")
    String shortValue;
    String swap_char;
    boolean swap_enable;
    String swap_formula1;
    String swap_formula2;
    String swap_formula3;
    String swap_long;
    String swap_short;
    int tick_size;
    String user_currency;
    String volume_formula1;
    String volume_formula2;
    String volume_mln_usd;
    String form_type;


    HashMap<String, Float> conversion_pairs;

    public int getCommission() {
        return commission;
    }

    public CalculateResult setCommission(int commission) {
        this.commission = commission;
        return this;
    }

    public String getLong() {
        return longValue;
    }

    public CalculateResult setLong(String longValue) {
        this.longValue = longValue;
        return this;
    }

    public String getLots_mln_usd() {
        return lots_mln_usd;
    }

    public CalculateResult setLots_mln_usd(String lots_mln_usd) {
        this.lots_mln_usd = lots_mln_usd;
        return this;
    }

    public String getMargin() {
        return margin;
    }

    public CalculateResult setMargin(String margin) {
        this.margin = margin;
        return this;
    }

    public String getMargin_formula1() {
        return margin_formula1;
    }

    public CalculateResult setMargin_formula1(String margin_formula1) {
        this.margin_formula1 = margin_formula1;
        return this;
    }

    public String getMargin_formula2() {
        return margin_formula2;
    }

    public CalculateResult setMargin_formula2(String margin_formula2) {
        this.margin_formula2 = margin_formula2;
        return this;
    }

    public boolean isNo_quotes() {
        return no_quotes;
    }

    public CalculateResult setNo_quotes(boolean no_quotes) {
        this.no_quotes = no_quotes;
        return this;
    }

    public String getProfit() {
        return profit;
    }

    public CalculateResult setProfit(String profit) {
        this.profit = profit;
        return this;
    }

    public String getProfit_formula1() {
        return profit_formula1;
    }

    public CalculateResult setProfit_formula1(String profit_formula1) {
        this.profit_formula1 = profit_formula1;
        return this;
    }

    public String getProfit_formula2() {
        return profit_formula2;
    }

    public CalculateResult setProfit_formula2(String profit_formula2) {
        this.profit_formula2 = profit_formula2;
        return this;
    }

    public String getShort() {
        return shortValue;
    }

    public CalculateResult setShort(String shortValue) {
        this.shortValue = shortValue;
        return this;
    }

    public String getSwap_char() {
        return swap_char;
    }

    public CalculateResult setSwap_char(String swap_char) {
        this.swap_char = swap_char;
        return this;
    }

    public boolean isSwap_enable() {
        return swap_enable;
    }

    public CalculateResult setSwap_enable(boolean swap_enable) {
        this.swap_enable = swap_enable;
        return this;
    }

    public String getSwap_formula1() {
        return swap_formula1;
    }

    public CalculateResult setSwap_formula1(String swap_formula1) {
        this.swap_formula1 = swap_formula1;
        return this;
    }

    public String getSwap_formula2() {
        return swap_formula2;
    }

    public CalculateResult setSwap_formula2(String swap_formula2) {
        this.swap_formula2 = swap_formula2;
        return this;
    }

    public String getSwap_formula3() {
        return swap_formula3;
    }

    public CalculateResult setSwap_formula3(String swap_formula3) {
        this.swap_formula3 = swap_formula3;
        return this;
    }

    public String getSwap_long() {
        return swap_long;
    }

    public CalculateResult setSwap_long(String swap_long) {
        this.swap_long = swap_long;
        return this;
    }

    public String getSwap_short() {
        return swap_short;
    }

    public CalculateResult setSwap_short(String swap_short) {
        this.swap_short = swap_short;
        return this;
    }

    public int getTick_size() {
        return tick_size;
    }

    public CalculateResult setTick_size(int tick_size) {
        this.tick_size = tick_size;
        return this;
    }

    public String getUser_currency() {
        return user_currency;
    }

    public CalculateResult setUser_currency(String user_currency) {
        this.user_currency = user_currency;
        return this;
    }

    public String getVolume_formula1() {
        return volume_formula1;
    }

    public CalculateResult setVolume_formula1(String volume_formula1) {
        this.volume_formula1 = volume_formula1;
        return this;
    }

    public String getVolume_formula2() {
        return volume_formula2;
    }

    public CalculateResult setVolume_formula2(String volume_formula2) {
        this.volume_formula2 = volume_formula2;
        return this;
    }

    public String getVolume_mln_usd() {
        return volume_mln_usd;
    }

    public CalculateResult setVolume_mln_usd(String volume_mln_usd) {
        this.volume_mln_usd = volume_mln_usd;
        return this;
    }

    public String getForm_type() {
        return form_type;
    }

    public CalculateResult setForm_type(String form_type) {
        this.form_type = form_type;
        return this;
    }

    public HashMap<String, Float> getConversion_pairs() {
        return conversion_pairs;
    }

    public CalculateResult setConversion_pairs(HashMap<String, Float> conversion_pairs) {
        this.conversion_pairs = conversion_pairs;
        return this;
    }

    @Override
    public String toString() {
        return "CalculateResult{ " +
                "\r\n commission=" + commission +
                ",\n longValue='" + longValue + '\'' +
                ",\n lots_mln_usd='" + lots_mln_usd + '\'' +
                ",\n margin='" + margin + '\'' +
                ",\n margin_formula1='" + margin_formula1 + '\'' +
                ",\n margin_formula2='" + margin_formula2 + '\'' +
                ",\n no_quotes=" + no_quotes +
                ",\n profit='" + profit + '\'' +
                ",\n profit_formula1='" + profit_formula1 + '\'' +
                ",\n profit_formula2='" + profit_formula2 + '\'' +
                ",\n shortValue='" + shortValue + '\'' +
                ",\n swap_char='" + swap_char + '\'' +
                ",\n swap_enable=" + swap_enable +
                ",\n swap_formula1='" + swap_formula1 + '\'' +
                ",\n swap_formula2='" + swap_formula2 + '\'' +
                ",\n swap_formula3='" + swap_formula3 + '\'' +
                ",\n swap_long='" + swap_long + '\'' +
                ",\n swap_short='" + swap_short + '\'' +
                ",\n tick_size=" + tick_size +
                ",\n user_currency='" + user_currency + '\'' +
                ",\n volume_formula1='" + volume_formula1 + '\'' +
                ",\n volume_formula2='" + volume_formula2 + '\'' +
                ",\n volume_mln_usd='" + volume_mln_usd + '\'' +
                ",\n form_type='" + form_type + '\'' +
                ",\n conversion_pairs=" + conversion_pairs +
                "\n}";
    }
}

