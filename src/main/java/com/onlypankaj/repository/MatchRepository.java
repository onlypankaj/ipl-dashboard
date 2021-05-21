package com.onlypankaj.repository;

import com.onlypankaj.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2(String teamName1, String teamName2, Pageable pageable);

    default List<Match> findLateshMatchByTeam(String teamName, int count){
        return getByTeam1OrTeam2(teamName,teamName, PageRequest.of(0, count));
    }

}
