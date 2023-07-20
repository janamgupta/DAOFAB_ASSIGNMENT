import React from 'react';
//Child Transaction Data Component
function ChildTransaction({ transaction }) {
  return (
    <tr>
      <td>{transaction.id}</td>
      <td>{transaction.sender}</td>
      <td>{transaction.receiver}</td>
      <td>{transaction.totalAmount}</td>
      <td>{transaction.paidAmount}</td>
    </tr>
  );
}

export default ChildTransaction;
