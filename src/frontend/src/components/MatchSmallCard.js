import { React } from 'react';
import { Link } from 'react-router-dom';
import './MatchSmallCard.scss'

export const MatchSmallCard = ({ teamName, match }) => {
    if (!match) return null;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = teamName === match.matchWinner;
    const isTie = match.result == 'tie' ? true : false;
    var cardColur = isTie ? 'MatchDetailCard tie-card' : isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card';
    var matchResult = "";
    if(isTie){
        matchResult = "There was a tie between " + match.team1 + " and " + match.team2;  
    } else {
        matchResult = match.matchWinner + " won by " + match.resultMargin + " " + match.result;
    }
    return (
        <div className={cardColur}>
            <span className="vs">vs</span>
            <h3><Link to={otherTeamRoute}>{otherTeam}</Link></h3>
            <p className="match-result">{matchResult}</p>
        </div>
    );
}