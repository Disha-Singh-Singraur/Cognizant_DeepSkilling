import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  const btnClass = theme === 'light' ? 'btn btn-light' : 'btn btn-dark';

  return (
    <div className="card" style={{ border: '1px solid #ccc', padding: '10px', margin: '10px', borderRadius: '5px' }}>
      <h4>{employee.name}</h4>
      <p>Position: {employee.position}</p>
      <button className={btnClass}>Action Button</button>
    </div>
  );
}

export default EmployeeCard;