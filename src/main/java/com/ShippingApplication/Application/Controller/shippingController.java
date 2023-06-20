package com.ShippingApplication.Application.Controller;


import com.ShippingApplication.Application.Model.ShippingModel;
import com.ShippingApplication.Application.Service.Shippingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class shippingController {




    @Autowired
    private Shippingservice service;


    @GetMapping
    public String login() {
 return "login";
        //return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/success")
    public String success(){

        return "home";
    }

    @GetMapping("/book_Shippment")
    public String bookRegister() {
        return "shippment_Booking";
    }



      @GetMapping("/getAllBookings")
    public ModelAndView getAllBookings() {
        List<ShippingModel> list=service.getAllBookings();
////		ModelAndView m=new ModelAndView();
////		m.setViewName("bookList");
////		m.addObject("book",list);
        return new ModelAndView("listOfBookings","shippingModel",list);
    }
//
    @PostMapping("/save")
    public String addBook(@ModelAttribute ShippingModel model) {
        service.save(model);
        return "redirect:/getAllBookings";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        ShippingModel model1=service.getShippingModelById(id);
        model.addAttribute("shippingModel",model1);
        return "edit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")Long id) {
        service.deleteById(id);
        return "redirect:/getAllBookings";}

    @GetMapping("/customLogout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "logout";
    }




}
