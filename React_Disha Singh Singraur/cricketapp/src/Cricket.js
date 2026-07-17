import React from 'react';

export function ListofPlayers({ players }) {
  return (
    <ul>
      {players.map((item, index) => (
        <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </ul>
  );
}

export function Scorebelow70({ players }) {
  const players70 = players.filter(player => player.score < 70);
  return (
    <ul>
      {players70.map((item, index) => (
        <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </ul>
  );
}

export function OddPlayers([first, , third, , fifth]) {
  return (
    <ul>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </ul>
  );
}

export function EvenPlayers([, second, , fourth, , sixth]) {
  return (
    <ul>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </ul>
  );
}

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
export const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <ul>
      {IndianPlayers.map((player, index) => (
        <li key={index}>{player}</li>
      ))}
    </ul>
  );
}