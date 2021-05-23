package com.onlypankaj.controller;

import com.onlypankaj.model.Match;
import com.onlypankaj.model.Team;
import com.onlypankaj.repository.MatchRepository;
import com.onlypankaj.repository.TeamRespository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class TeamController {


    public TeamRespository teamRespository;
    public MatchRepository matchRepository;

    public TeamController(TeamRespository teamRespository, MatchRepository matchRepository) {
        this.teamRespository = teamRespository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team")
    public Iterable<Team> getAllTeam(){
        return this.teamRespository.findAll();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team = this.teamRespository.findByTeamName(teamName);
        team.setMatches(this.matchRepository.findLatestMatchByTeam(teamName, 4));

        System.out.println("Team UI called" + team);
        return team;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year){
        LocalDate startDate = LocalDate.of(year, 1,1 );
        LocalDate endDate = LocalDate.of(year+1, 1,1 );

        return this.matchRepository.getMatchesByTeamBetweenDates(teamName,startDate,endDate);

//        return this.matchRepository.getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
//                teamName,startDate,endDate,
//                teamName, startDate,endDate);
    }
}
