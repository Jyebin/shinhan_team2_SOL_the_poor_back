package com.choikang.poor.the_poor_back.dto;

import com.choikang.poor.the_poor_back.model.Account;
import com.choikang.poor.the_poor_back.model.Transaction;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private String date;
    private String time;
    private String description;
    private Boolean status;
    private int amount;
    private int balance;

    public static TransactionDTO convertToDTO(Transaction transaction) {
        // date, time 분리
        String dateAndTime = transaction.getTransactionDate().toString();
        String date = dateAndTime.substring(0, 10);
        String time = dateAndTime.substring(11, 19);

        return TransactionDTO.builder()
                .date(date)
                .time(time)
                .description(transaction.getTransactionName())
                .status(transaction.getTransactionIsDeposit())
                .amount(transaction.getTransactionMoney())
                .balance(transaction.getTransactionBalance())
                .build();
    }
}
