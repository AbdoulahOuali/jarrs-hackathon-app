package com.ingenico.epayments.jarrs.hackaton.oqp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button addMoneyButton = findViewById(R.id.add_money_button);
        final Button payButton = findViewById(R.id.pay_button);
        final Button receiveFundsButton = findViewById(R.id.receive_funds_button);

        addMoneyButton.setOnClickListener(this);
        payButton.setOnClickListener(this);
        receiveFundsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_money_button:
                Toast toastMoneyAdded = Toast.makeText(this, "MONEY WAS ADDED", Toast.LENGTH_LONG);
                toastMoneyAdded.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 24);
                toastMoneyAdded.show();
                break;
            case R.id.pay_button:
                Toast toastPayed = Toast.makeText(this, "YOUR PAYMENT WAS SUCCESSFUL", Toast.LENGTH_LONG);
                toastPayed.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 24);
                toastPayed.show();
                break;
            case R.id.receive_funds_button:
                Toast toastFundsReceived = Toast.makeText(this, "FUNDS RECEIVED", Toast.LENGTH_LONG);
                toastFundsReceived.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 24);
                toastFundsReceived.show();
                break;
        }
    }
}