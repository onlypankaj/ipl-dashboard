package com.onlypankaj.controller;

import com.onlypankaj.model.Team;
import com.onlypankaj.repository.MatchRepository;
import com.onlypankaj.repository.TeamRespository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {


    public TeamRespository teamRespository;
    public MatchRepository matchRepository;

    public TeamController(TeamRespository teamRespository, MatchRepository matchRepository) {
        this.teamRespository = teamRespository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team = this.teamRespository.findByTeamName(teamName);
        team.setMatches(this.matchRepository.findLateshMatchByTeam(teamName, 4));

        System.out.println("Team UI called" + team);
        return team;
    }
}
