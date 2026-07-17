import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <ul>
        {this.props.item.map((item, index) => (
          <li key={index}>
            {item.itemname} - Rs. {item.price}
          </li>
        ))}
      </ul>
    );
  }
}

export default Cart;