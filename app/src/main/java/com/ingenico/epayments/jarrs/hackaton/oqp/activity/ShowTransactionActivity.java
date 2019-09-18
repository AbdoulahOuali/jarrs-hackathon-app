package com.ingenico.epayments.jarrs.hackaton.oqp.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ingenico.epayments.jarrs.hackaton.oqp.R;
import com.ingenico.epayments.jarrs.hackaton.oqp.adapter.TransactionsAdapter;
import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;
import com.ingenico.epayments.jarrs.hackaton.oqp.webservice.PaymentAppApiInterFace;
import com.ingenico.epayments.jarrs.hackaton.oqp.webservice.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTransactionActivity extends AppCompatActivity {

    private final String TAG = ShowTransactionActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Transaction> transactions = new ArrayList<>();
    private TransactionsAdapter transactionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_transaction);
        recyclerView = findViewById(R.id.transax_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowTransactionActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        transactionsAdapter = new TransactionsAdapter(ShowTransactionActivity.this, transactions);
        recyclerView.setAdapter(transactionsAdapter);

        getTransactions();
    }

    private void getTransactions() {
        PaymentAppApiInterFace paymentAppApiInterFace = ServiceGenerator.createService(PaymentAppApiInterFace.class);
        Call<List<Transaction>> call = paymentAppApiInterFace.getTransactions();
        call.enqueue(new Callback<List<Transaction>>() {
            @Override
            public void onResponse(Call<List<Transaction>> call, Response<List<Transaction>> response) {
                if (response.isSuccessful()) {
                    for (Transaction transaction : response.body()) {
                        transactions.add(transaction);
                    }
                    transactionsAdapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Transaction>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
