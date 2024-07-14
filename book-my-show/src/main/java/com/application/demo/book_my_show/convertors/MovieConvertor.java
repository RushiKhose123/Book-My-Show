package com.application.demo.book_my_show.convertors;

import com.application.demo.book_my_show.entity.MovieEntity;
import com.application.demo.book_my_show.entity.TicketEntity;
import com.application.demo.book_my_show.requestdtos.MovieRequestDto;
import com.application.demo.book_my_show.requestdtos.TicketRequestDto;

public class MovieConvertor {

    public static MovieEntity convertMovieRequestDtoToMovieEntity(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity = MovieEntity.builder().movieName(movieRequestDto.getMovieName())
                .rating(movieRequestDto.getRating()).duration(movieRequestDto.getDuration())
                .language(movieRequestDto.getLanguage()).genre(movieRequestDto.getGenre()).build();

        return movieEntity;
    }
}
