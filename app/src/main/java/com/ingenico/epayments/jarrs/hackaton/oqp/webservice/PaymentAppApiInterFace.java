package com.ingenico.epayments.jarrs.hackaton.oqp.webservice;

import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * https://medium.com/@sontbv/retrofit-2-for-beginners-creating-an-android-api-client-3c4370e1118
 */
public interface PaymentAppApiInterFace {

    @GET
    Call<List<Transaction>> getTransactions();
}
