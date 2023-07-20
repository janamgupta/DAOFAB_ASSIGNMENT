package com.transaction.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.model.ChildTransaction;
import com.transaction.model.ParentTransaction;
import com.transaction.model.ParentTransactionDTO;
import com.transaction.model.ParentTransactionResponse;
import com.transaction.services.IChildTransactionService;
import com.transaction.services.IParentTransactionService;


@RestController
@RequestMapping("/parents")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    private final List<ParentTransaction> parentData; // Load parent data from JSON file
    private final List<ChildTransaction> childData; // Load child data from JSON file
    private final IParentTransactionService iParentTransactionService; //Parent Transaction Service Interface
    private final IChildTransactionService iChildTransactionService; //Child Transaction Service Interface
    
    @Autowired
    public TransactionController(IParentTransactionService iParentTransactionService, IChildTransactionService iChildTransactionService) {
        // Load parent and child data from JSON files
        parentData = loadDataFromFile("Parent.json", ParentTransaction.class);
        childData = loadDataFromFile("Child.json", ChildTransaction.class);
        this.iParentTransactionService = iParentTransactionService;
        this.iChildTransactionService = iChildTransactionService;
    }
    
    //Endpoint to get and view all parent transactions
    @GetMapping
    public ParentTransactionResponse getParentTransactions(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
    	if (parentData == null || childData == null)
            return null;

        List<ParentTransactionDTO> parentTransactions = iParentTransactionService.getAllParentTransactions(page, pageSize, sortBy, parentData, childData);

        int noOfPages = (parentData.size() % pageSize == 0) ? (parentData.size() / pageSize) : (parentData.size() / pageSize + 1);

        return new ParentTransactionResponse(parentTransactions, noOfPages);
    }
    
    //Endpoint to get parent transaction using parentID
    @GetMapping("/{parentId}")
    public ParentTransaction getParentTransactionsByID(@PathVariable int parentId) {
    	if(parentData == null)
    		return null;
    	return iParentTransactionService.getParentTransactionById(parentId, parentData);
    }
    
    //Endpoint to get all child transaction using parentID
    @GetMapping("/{parentId}/children")
    public List<ChildTransaction> getChildTransactions(@PathVariable int parentId) {
    	if(childData == null)
    		return null;
    	return iChildTransactionService.getChildTransactions(parentId, childData);
    }

    // Helper method to load JSON data from file
    private <T> List<T> loadDataFromFile(String fileName, Class<T> dataType) {
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(resource.getInputStream());
            JsonNode dataNode = jsonNode.get("data");
            return objectMapper.readValue(dataNode.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, dataType));
        } catch (IOException e) {
        	e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
