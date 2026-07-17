import React from 'react';

class GetUser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      person: null,
      loading: true
    };
  }

  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }

  render() {
    if (this.state.loading) {
      return <div>Loading...</div>;
    }

    const { person } = this.state;
    const name = `${person.name.title} ${person.name.first} ${person.name.last}`;

    return (
      <div style={{ border: '1px solid #ccc', padding: '20px', width: '300px', margin: '20px auto', textAlign: 'center', borderRadius: '8px' }}>
        <img src={person.picture.large} alt={name} style={{ borderRadius: '50%' }} />
        <h2>{name}</h2>
      </div>
    );
  }
}

export default GetUser;