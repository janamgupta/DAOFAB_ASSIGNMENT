package com.transaction.services;

import java.util.List;

import com.transaction.model.ChildTransaction;
import com.transaction.model.ParentTransaction;
import com.transaction.model.ParentTransactionDTO;

//Parent Transaction Interface
public interface IParentTransactionService {
	
	 List<ParentTransactionDTO> getAllParentTransactions(int page, int pageSize, String sortBy, List<ParentTransaction> parentData,  List<ChildTransaction> childData);
	 ParentTransaction getParentTransactionById(int parentId, List<ParentTransaction> parentData);
}
