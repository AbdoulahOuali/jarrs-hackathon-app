package com.ingenico.epayments.jarrs.hackaton.oqp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ingenico.epayments.jarrs.hackaton.oqp.R;
import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHolder> {
    private List<Transaction> transactions;
    private Context context;

    public TransactionsAdapter(Context context, List<Transaction> transactions) {
        this.transactions = transactions;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView amount, currency, receiver, receiverUpdateTime, sender, senderUpdateTime, transactionTime, uuid;

        public ViewHolder(View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.amount);
            currency = itemView.findViewById(R.id.currency);
            receiver = itemView.findViewById(R.id.receiver);
            receiverUpdateTime = itemView.findViewById(R.id.receiverUpdateTime);
            sender = itemView.findViewById(R.id.sender);
            senderUpdateTime = itemView.findViewById(R.id.sender);
            transactionTime = itemView.findViewById(R.id.transactionTime);
            uuid = itemView.findViewById(R.id.uuid);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.amount.setText(transaction.getAmount().toString());
        holder.currency.setText(transaction.getCurrency());
        holder.receiver.setText(transaction.getReceiver());
        holder.receiverUpdateTime.setText(transaction.getReceiverUpdateTime().toString());
        holder.sender.setText(transaction.getSender());
        holder.senderUpdateTime.setText(transaction.getSenderUpdateTime().toString());
        holder.transactionTime.setText(transaction.getTransactionTime().toString());
        holder.uuid.setText(transaction.getUuid());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }
}
