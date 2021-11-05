package com.hotel_app.web;

import com.hotel_app.data.business.service.ReservationService;
import com.hotel_app.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {

    private final ReservationService reservationService;

    @Autowired
    public GuestWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model){
        List<com.hotel_app.data.entity.Guest> guests = this.reservationService.getHotelGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }

}