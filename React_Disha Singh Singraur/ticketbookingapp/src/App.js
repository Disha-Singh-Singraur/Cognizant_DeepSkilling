import React from 'react';

function UserGreeting() {
  const handleBookTicket = () => {
    alert('Ticket Booked Successfully!');
  };

  return (
    <div>
      <h1>Welcome back</h1>
      <h3>Available Flights:</h3>
      <ul>
        <li>
          AI-101: Delhi to Mumbai (Departure: 10:00 AM) - Rs. 5000 
          <button onClick={handleBookTicket} style={{ marginLeft: '10px' }}>Book Ticket</button>
        </li>
        <li>
          AI-102: Chennai to Delhi (Departure: 2:00 PM) - Rs. 6000 
          <button onClick={handleBookTicket} style={{ marginLeft: '10px' }}>Book Ticket</button>
        </li>
      </ul>
    </div>
  );
}

function GuestGreeting() {
  return (
    <div>
      <h1>Please sign up.</h1>
      <h3>Available Flights (Log in to book):</h3>
      <ul>
        <li>AI-101: Delhi to Mumbai (Departure: 10:00 AM) - Rs. 5000</li>
        <li>AI-102: Chennai to Delhi (Departure: 2:00 PM) - Rs. 6000</li>
      </ul>
    </div>
  );
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>Login</button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>Logout</button>
  );
}

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  }

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;
    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogout} />;
    } else {
      button = <LoginButton onClick={this.handleLogin} />;
    }

    return (
      <div style={{ padding: '20px' }}>
        <Greeting isLoggedIn={isLoggedIn} />
        <div style={{ marginTop: '20px' }}>
          {button}
        </div>
      </div>
    );
  }
}

export default App;