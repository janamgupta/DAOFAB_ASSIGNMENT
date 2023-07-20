import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import '../style/ChildTransactionTable.css';

//Child Transaction Table Component
function ChildTransactionTable() {
  const { parentId } = useParams();
  const [childTransactions, setChildTransactions] = useState([]);
  const [parentTransaction, setParentTransaction] = useState(null);

  useEffect(() => {
    fetchParentTransaction();
    fetchChildTransactions();
  }, []);

  //Fetch parent transaction for particular parent ID
  const fetchParentTransaction = async () => {
    try {
      const response = await fetch(`http://localhost:8080/parents/${parentId}`);
      const data = await response.json();
      setParentTransaction(data);
    } catch (error) {
      console.error('Error fetching parent transaction:', error);
    }
  };

  //Fetch all child transactions for a particular parent ID
  const fetchChildTransactions = async () => {
    try {
      const response = await fetch(`http://localhost:8080/parents/${parentId}/children`);
      const data = await response.json();
      setChildTransactions(data);
    } catch (error) {
      console.error('Error fetching child transactions:', error);
    }
  };

  if (!parentTransaction) {
    return <div>Loading...</div>;
  }

  const { sender, receiver, totalAmount } = parentTransaction;

  return (
    <div>
      <h1 className='child-heading'>Child Transactions for Parent ID: {parentId}</h1>
      <table className="child-transactions-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Total Amount</th>
            <th>Paid Amount</th>
          </tr>
        </thead>
        <tbody>
          {childTransactions.map((transaction) => (
            <tr key={transaction.id}>
              <td>{transaction.id}</td>
              <td>{sender}</td>
              <td>{receiver}</td>
              <td>{totalAmount}</td>
              <td>{transaction.paidAmount}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ChildTransactionTable;
