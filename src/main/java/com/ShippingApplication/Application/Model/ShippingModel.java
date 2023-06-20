package com.ShippingApplication.Application.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    Customer Name*:
//            2.2 Customer Address*:
//            2.3 Consignment Weight (Kg)*:
//            2.4 Consignment Dimensions (L X B X H)*:
//            2.5: Delivery Address*:
    private String Customer_Name;
    private String Customer_Address;

    private String Delivery_Address;
    private String Consignment_Weight;


    private String Consignment_Dimensions;

}
