package com.application.demo.book_my_show.service;

import com.application.demo.book_my_show.convertors.TheaterConvertor;
import com.application.demo.book_my_show.entity.TheaterEntity;
import com.application.demo.book_my_show.entity.TheaterSeatEntity;
import com.application.demo.book_my_show.enums.SeatType;
import com.application.demo.book_my_show.repository.TheaterRepository;
import com.application.demo.book_my_show.repository.TheaterSeatRepository;
import com.application.demo.book_my_show.requestdtos.TheaterRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterRequestDto theaterRequestDto) throws Exception{

        if(theaterRequestDto.getName() == null || theaterRequestDto.getLocation() == null){
            throw new Exception("Name and location should not be null");
        }

        TheaterEntity theaterEntity = TheaterConvertor.convertTheaterRequestDtoToTheaterEntity(theaterRequestDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterRequestDto,theaterEntity);
        theaterEntity.setListOfTheaterSeats(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);
        return "Theater Added Successfully";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterRequestDto theaterRequestDto, TheaterEntity theaterEntity){
        int noOfClassicSeats = theaterRequestDto.getClassicSeatCount();
        int noOfPremiumSeats = theaterRequestDto.getPremiumSeatCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        for(int count = 1; count <= noOfClassicSeats; count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.CLASSIC)
                    .seatNo("C"+count).theaterEntity(theaterEntity).build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        for(int count = 1; count <= noOfPremiumSeats; count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.PREMIUM)
                    .seatNo("P"+count).theaterEntity(theaterEntity).build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;
    }


}

