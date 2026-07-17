import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

function App() {
  const [theme, setTheme] = useState('light');
  const employees = [
    { id: 1, name: 'John Doe', position: 'Developer' },
    { id: 2, name: 'Jane Smith', position: 'Designer' },
    { id: 3, name: 'Bob Johnson', position: 'Manager' }
  ];

  const toggleTheme = () => {
    setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: '20px', background: theme === 'light' ? '#fff' : '#333', color: theme === 'light' ? '#000' : '#fff' }}>
        <h1>Employee Management</h1>
        <button onClick={toggleTheme}>Toggle Theme (Current: {theme})</button>
        <hr />
        <EmployeesList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;