package com.transaction.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.transaction.model.ChildTransaction;

//Child Transaction Implementation
@Service
public class ChildTransactionServiceImpl implements IChildTransactionService{

	@Override
	public List<ChildTransaction> getChildTransactions(int parentId, List<ChildTransaction> childData) {
		return childData.stream()
                .filter(child -> child.getParentId() == parentId)
                .collect(Collectors.toList());
	}
}
