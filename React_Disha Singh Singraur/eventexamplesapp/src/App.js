import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  sayHello = () => {
    alert("Hello! Counter incremented.");
  }

  increment = () => {
    this.setState(prevState => ({
      counter: prevState.counter + 1
    }), this.sayHello);
  }

  decrement = () => {
    this.setState(prevState => ({
      counter: prevState.counter - 1
    }));
  }

  sayWelcome = (msg) => {
    alert(msg);
  }

  handlePress = (e) => {
    alert("I was clicked");
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1>Event Examples App</h1>
        <div>
          <h3>Counter: {this.state.counter}</h3>
          <button onClick={this.increment}>Increment</button>
          <button onClick={this.decrement}>Decrement</button>
        </div>
        <hr />
        <div>
          <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>
        </div>
        <hr />
        <div>
          <button onClick={this.handlePress}>Synthetic Event (OnPress)</button>
        </div>
        <hr />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;