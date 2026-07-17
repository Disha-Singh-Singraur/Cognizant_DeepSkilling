import React from 'react';
import '../Stylesheets/mystyle.css';

const percentToDecimal = (decimal) => {
  return (decimal.toFixed(2) + '%');
};

const calcScore = (total, goal) => {
  return percentToDecimal(total / goal);
};

export const CalculateScore = ({ Name, School, total, goal }) => (
  <div className="formatstyle">
    <h1><font color="Brown">Student Details:</font></h1>
    <div className="Name">
      <b><span>Name: </span><span>{Name}</span></b>
    </div>
    <div className="School">
      <b><span>School: </span><span>{School}</span></b>
    </div>
    <div className="Total">
      <b><span>Total: </span><span>{total} Marks</span></b>
    </div>
    <div className="Score">
      <b><span>Average Score: </span><span>{calcScore(total, goal)}</span></b>
    </div>
  </div>
);