import React from 'react';

function App() {
  const element = "Office Space";
  const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };
  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Premium Space", Rent: 75000, Address: "Bangalore" },
    { Name: "Shared Office", Rent: 45000, Address: "Hyderabad" },
    { Name: "Executive Suite", Rent: 90000, Address: "Mumbai" }
  ];

  return (
    <div style={{ padding: '20px' }}>
      <h1>{element} at Affordable Range</h1>
      <svg width="200" height="150" viewBox="0 0 100 100" style={{ display: 'block', margin: '15px 0' }}>
        <rect x="10" y="20" width="80" height="70" fill="#ddd" stroke="#333" strokeWidth="2" />
        <rect x="25" y="35" width="15" height="15" fill="#fff" stroke="#333" />
        <rect x="60" y="35" width="15" height="15" fill="#fff" stroke="#333" />
        <rect x="42" y="65" width="16" height="25" fill="#8b5a2b" stroke="#333" />
      </svg>
      <h1>Name: {ItemName.Name}</h1>
      <h3 style={{ color: ItemName.Rent < 60000 ? 'red' : 'green' }}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>

      <hr />
      <h2>Additional Office Spaces</h2>
      <ul>
        {offices.map((office, index) => (
          <li key={index} style={{ marginBottom: '15px' }}>
            <h2>Name: {office.Name}</h2>
            <h3 style={{ color: office.Rent < 60000 ? 'red' : 'green' }}>Rent: Rs. {office.Rent}</h3>
            <h3>Address: {office.Address}</h3>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;