import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ParentTransactionTable from './components/ParentTransactionTable';
import ChildTransactionTable from './components/ChildTransactionTable';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<ParentTransactionTable />} />
          <Route path="/parents/:parentId/children" element={<ChildTransactionTable />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
