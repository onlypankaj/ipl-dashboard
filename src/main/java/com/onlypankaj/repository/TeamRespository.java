package com.onlypankaj.repository;

import com.onlypankaj.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRespository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);

}
