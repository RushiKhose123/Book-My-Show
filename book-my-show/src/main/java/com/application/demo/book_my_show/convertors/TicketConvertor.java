package com.application.demo.book_my_show.convertors;

import com.application.demo.book_my_show.entity.TicketEntity;
import com.application.demo.book_my_show.requestdtos.TicketRequestDto;

public class TicketConvertor {

    public static TicketEntity convertTicketRequestDtoToTicketEntity(TicketRequestDto ticketRequestDto){
        TicketEntity ticketEntity = TicketEntity.builder().build();

        return ticketEntity;
    }
}
