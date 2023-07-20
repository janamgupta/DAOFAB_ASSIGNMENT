package com.transaction.model;

import java.util.List;

public class ParentTransactionResponse {
    private List<ParentTransactionDTO> parentTransactions;
    private int totalPages;

    public ParentTransactionResponse(List<ParentTransactionDTO> parentTransactions, int totalPages) {
        this.parentTransactions = parentTransactions;
        this.totalPages = totalPages;
    }

    // Getters and setters (or use Lombok annotations)

    public List<ParentTransactionDTO> getParentTransactions() {
        return parentTransactions;
    }

    public void setParentTransactions(List<ParentTransactionDTO> parentTransactions) {
        this.parentTransactions = parentTransactions;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

