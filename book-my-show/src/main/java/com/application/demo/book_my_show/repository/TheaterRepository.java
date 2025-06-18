package com.application.demo.book_my_show.repository;

import com.application.demo.book_my_show.entity.ShowEntity;
import com.application.demo.book_my_show.entity.TheaterEntity;
import com.application.demo.book_my_show.enums.ShowType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {

}
