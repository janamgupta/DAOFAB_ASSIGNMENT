import React from 'react';
import { Link } from 'react-router-dom';

//Parent Transaction Data Component
function ParentTransaction({ transaction }) {
  return (
    <tr>
      <td>{transaction.id}</td>
      <td>{transaction.sender}</td>
      <td>{transaction.receiver}</td>
      <td>{transaction.totalAmount}</td>
      <td>
        <Link to={{ pathname: `/parents/${transaction.id}/children`, state: { parentId: transaction.id } }}>
          {transaction.totalPaidAmount}
        </Link>
      </td>
    </tr>
  );
}

export default ParentTransaction;
