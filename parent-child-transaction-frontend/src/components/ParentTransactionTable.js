import React, { useState, useEffect } from 'react';
import ParentTransaction from './ParentTransaction';
import { Link, useLocation } from 'react-router-dom';
import '../style/ParentTransactionTable.css';

// Parent Transaction Table Component
function ParentTransactionTable() {
  const location = useLocation();
  const [parentTransactions, setParentTransactions] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [pageSize, setPageSize] = useState(2);
  const [totalPages, setTotalPages] = useState(1);

  useEffect(() => {
    fetchParentTransactions();
  }, [currentPage, pageSize]);

  // Fetch parent transactions for current page
  const fetchParentTransactions = async () => {
    try {
      const response = await fetch(`http://localhost:8080/parents?page=${currentPage}&pageSize=${pageSize}&sortBy=id`);
      const data = await response.json();
      
      // Extract parent transactions and totalPages from the response data
      const { parentTransactions, totalPages } = data;
      
      setParentTransactions(parentTransactions);
      setTotalPages(totalPages);
    } catch (error) {
      console.error('Error fetching parent transactions:', error);
    }
  };

  // Handle pagination
  const handleNextPage = () => {
    if (currentPage < totalPages) {
      setCurrentPage((prevPage) => prevPage + 1);
    }
  };

  const handlePreviousPage = () => {
    if (currentPage > 1) {
      setCurrentPage((prevPage) => prevPage - 1);
    }
  };

  return (
    <div>
      <h1 className="parent-heading">Parent Transaction</h1>
      <table className="parent-transactions-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Total Amount</th>
            <th>Total Paid Amount</th>
          </tr>
        </thead>
        <tbody>
          {parentTransactions.map((transaction) => (
            <ParentTransaction key={transaction.id} transaction={transaction} />
          ))}
        </tbody>
      </table>

      <div className="parent-transactions-pagination">
        <button className={`pagination-button ${currentPage === 1 ? 'disabled' : ''}`} onClick={handlePreviousPage} disabled={currentPage === 1}>
          Previous
        </button>
        <span>Page {currentPage}</span>
        <button className={`pagination-button ${currentPage === totalPages ? 'disabled' : ''}`} onClick={handleNextPage} disabled={currentPage === totalPages}>
          Next
        </button>
      </div>

      {location.state && (
        <div>
          <h2>Child Transactions for Parent ID: {location.state.parentId}</h2>
          <Link to="/">Go Back</Link>
        </div>
      )}
    </div>
  );
}

export default ParentTransactionTable;
