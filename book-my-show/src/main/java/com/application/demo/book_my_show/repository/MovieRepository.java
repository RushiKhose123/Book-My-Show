package com.application.demo.book_my_show.repository;

import com.application.demo.book_my_show.entity.MovieEntity;
import com.application.demo.book_my_show.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    public MovieEntity findByMovieName(String movieName);

    public List<MovieEntity> findByLanguage(Language language);

}
