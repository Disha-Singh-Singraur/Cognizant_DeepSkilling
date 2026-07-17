import React from 'react';

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: 0
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const refNumber = Math.floor(Math.random() * 10000) + 1;
    this.setState({ NumberHolder: refNumber }, () => {
      var msg = 'Thanks ' + this.state.ename + ' Your Complaint was Submitted. Reference ID is: ' + this.state.NumberHolder;
      alert(msg);
    });
  }

  render() {
    return (
      <div>
        <h2>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Employee Name: </label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ marginTop: '10px' }}>
            <label>Complaint: </label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ marginTop: '10px' }}>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;