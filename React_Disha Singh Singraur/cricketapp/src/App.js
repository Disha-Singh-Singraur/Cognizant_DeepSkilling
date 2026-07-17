import React from 'react';
import {
  ListofPlayers,
  Scorebelow70,
  OddPlayers,
  EvenPlayers,
  IndianPlayers,
  ListofIndianPlayers
} from './Cricket';

function App() {
  const players = [
    { name: 'Sachin', score: 99 },
    { name: 'Virat', score: 85 },
    { name: 'Rohit', score: 95 },
    { name: 'Dhoni', score: 70 },
    { name: 'Jadeja', score: 61 },
    { name: 'Raina', score: 61 }
  ];

  const IndianTeam = ['sachin1', 'Rohit2', 'Virat3', 'Dhoni4', 'Yuvraj5', 'Raina6'];

  const flag = true;

  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Indian Team</h1>
        <h1>Odd Players</h1>
        {OddPlayers(IndianTeam)}
        <h1>Even Players</h1>
        {EvenPlayers(IndianTeam)}
        <h1>List of Indian Players</h1>
        <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;