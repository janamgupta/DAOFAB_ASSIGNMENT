package com.transaction.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.transaction.model.ChildTransaction;
import com.transaction.model.ParentTransaction;
import com.transaction.model.ParentTransactionDTO;

//Parent Transaction Service Impl
@Service
public class ParentTransactionServiceImpl implements IParentTransactionService{

	@Override
	public List<ParentTransactionDTO> getAllParentTransactions(int page, int pageSize, String sortBy,
			List<ParentTransaction> parentData,  List<ChildTransaction> childData) {
		// Calculate start and end indices for pagination
        int startIndex = (page - 1) * pageSize;
        
        // Sort parent transactions by the specified column
        List<ParentTransaction> sortedTransactions = parentData.stream()
                .sorted(Comparator.comparing(ParentTransaction::getId))
                .collect(Collectors.toList());

        // Get the specified page of parent transactions
        List<ParentTransactionDTO> paginatedTransactions = sortedTransactions
                .stream()
                .skip(startIndex)
                .limit(pageSize)
                .map(transaction -> {
                    ParentTransactionDTO dto = new ParentTransactionDTO();
                    dto.setId(transaction.getId());
                    dto.setSender(transaction.getSender());
                    dto.setReceiver(transaction.getReceiver());
                    dto.setTotalAmount(transaction.getTotalAmount());
                    dto.setTotalPaidAmount(transaction.getTotalPaidAmount(childData));
                    return dto;
                })
                .collect(Collectors.toList());

        return paginatedTransactions;
	}

	@Override
	public ParentTransaction getParentTransactionById(int parentId, List<ParentTransaction> parentData) {
		// Get parent data for particular parent ID
        ParentTransaction transaction = parentData.stream()
        		.filter(parent -> parent.getId() == parentId)
        		.findFirst()
                .orElse(null);

        return transaction;
	}
}
