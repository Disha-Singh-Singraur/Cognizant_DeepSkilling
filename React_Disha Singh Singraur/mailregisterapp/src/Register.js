import React from 'react';

const validEmailRegex = RegExp(
  /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
);

const validateForm = (errors) => {
  let valid = true;
  Object.values(errors).forEach((val) => val.length > 0 && (valid = false));
  return valid;
};

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = { ...this.state.errors };

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5
          ? 'Full Name must be 5 characters long'
          : '';
        break;
      case 'email':
        errors.email = validEmailRegex.test(value)
          ? ''
          : 'Email is not valid';
        break;
      case 'password':
        errors.password = value.length < 8
          ? 'Password must be 8 characters long'
          : '';
        break;
      default:
        break;
    }

    this.setState({
      errors,
      [name]: value
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const { fullName, email, password } = this.state;
    
    let errors = { ...this.state.errors };
    errors.fullName = fullName.length < 5 ? 'Full Name must be 5 characters long' : '';
    errors.email = validEmailRegex.test(email) ? '' : 'Email is not valid';
    errors.password = password.length < 8 ? 'Password must be 8 characters long' : '';
    
    this.setState({ errors }, () => {
      if (validateForm(this.state.errors) && fullName && email && password) {
        alert('Valid Form');
      } else {
        if (this.state.errors.fullName) alert(this.state.errors.fullName);
        else if (this.state.errors.email) alert(this.state.errors.email);
        else if (this.state.errors.password) alert(this.state.errors.password);
        else alert('Form is invalid or incomplete');
      }
    });
  }

  render() {
    const { errors } = this.state;
    return (
      <div>
        <h2>Register Here!!!</h2>
        <form onSubmit={this.handleSubmit} noValidate>
          <div>
            <label>Full Name: </label>
            <input
              type="text"
              name="fullName"
              value={this.state.fullName}
              onChange={this.handleChange}
            />
            {errors.fullName.length > 0 && (
              <span style={{ color: 'red', marginLeft: '10px' }}>{errors.fullName}</span>
            )}
          </div>
          <div style={{ marginTop: '10px' }}>
            <label>Email: </label>
            <input
              type="email"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
            {errors.email.length > 0 && (
              <span style={{ color: 'red', marginLeft: '10px' }}>{errors.email}</span>
            )}
          </div>
          <div style={{ marginTop: '10px' }}>
            <label>Password: </label>
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
            {errors.password.length > 0 && (
              <span style={{ color: 'red', marginLeft: '10px' }}>{errors.password}</span>
            )}
          </div>
          <div style={{ marginTop: '10px' }}>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default Register;