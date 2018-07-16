package com.exness.services;

import com.exness.models.CalculateResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CalculateService {

    @GET("/api/calculator/calculate/")
    public Call<CalculateResult> calculate(
            @Query("form_type") String form_type,
            @Query("instrument") String instrument,
            @Query("symbol") String symbol,
            @Query("lot") String lot,
            @Query("leverage") String leverage,
            @Query("user_currency") String user_currency
    );

}
