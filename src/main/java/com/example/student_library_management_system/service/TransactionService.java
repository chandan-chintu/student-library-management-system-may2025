package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.TransactionConverter;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.repository.TransactionRepository;
import com.example.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);

        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        if(card!=null){
            transaction.setCard(card);
        }else{
            transaction.setCard(null);
        }

        Book book =bookRepository.findById(transactionRequestDto.getBookId()).get();
        if(book!=null){
            transaction.setBook(book);
        }else{
            transaction.setBook(null);
        }

        transactionRepository.save(transaction);
        return "Transaction Saved successfully!";
    }
}
