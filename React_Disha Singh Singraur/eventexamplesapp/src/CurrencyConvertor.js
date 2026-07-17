import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = (event) => {
    event.preventDefault();
    const conversion = (parseFloat(rupees) * 0.011).toFixed(2);
    setEuros(conversion);
  };

  return (
    <div>
      <h2>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Amount in INR:
          <input
            type="number"
            value={rupees}
            onChange={(e) => setRupees(e.target.value)}
            required
          />
        </label>
        <button type="submit">Convert</button>
      </form>
      {euros !== null && (
        <h3>Converted Amount: {euros} EUR</h3>
      )}
    </div>
  );
}

export default CurrencyConvertor;