package com.example.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Map.entities.EnergyConsumptionData;
import org.springframework.http.ResponseEntity;

@Controller
public class EnergyController {
 
static String countryName;
String sliderValue;

@PostMapping("/updateSliderValue")
@ResponseBody
public void updateSliderValue(@RequestBody Map<String,String> requestBody){
        sliderValue = requestBody.get("value");
        System.out.println("Received slider value from frontend: " + sliderValue);
            
    }


@PostMapping("/updateCountryName")
@ResponseBody
public ResponseEntity<?> updateCountryName(@RequestBody Map<String, String> requestBody, Model model) {
    countryName = requestBody.get("countryName");
        
        System.out.println("Received countryName: " + countryName);

        boolean countryNameExists = MapApplication.countryList.stream()
                .anyMatch(data -> data.getCountry_name().equals(countryName));

                MapApplication.countryList.stream()
    .filter(data -> data.getCountry_name().equals(countryName) && data.getYear() == Integer.parseInt(sliderValue))
    .forEach(data -> {
        System.out.println(data);
    });

        if (countryNameExists) {
            System.out.println("The countryName exists in the countryList.");


            
        } else {
            System.out.println("The countryName does not exist in the countryList.");
        }
        List<EnergyConsumptionData> filteredCountryList = MapApplication.countryList.stream()
            .filter(data -> data.getCountry_name().equals(countryName) && data.getYear() == Integer.parseInt(sliderValue))
            .collect(Collectors.toList());

    Map<String, Object> responseData = new HashMap<>();
    responseData.put("countryExists", countryNameExists);
    responseData.put("countryList", filteredCountryList);

    return ResponseEntity.ok(responseData);

    }

}
