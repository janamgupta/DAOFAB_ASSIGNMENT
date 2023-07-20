package com.transaction.services;

import java.util.List;

import com.transaction.model.ChildTransaction;

//Child Transaction Interface
public interface IChildTransactionService {
	List<ChildTransaction> getChildTransactions(int parentId, List<ChildTransaction> childData);
}
