package com.example.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

   

    @GetMapping("/map")
    public String map() {
        return "map";
    }

    @GetMapping("/energyMap")
    public String showEnergyMapPage(){
        return "energyMap";
    }

}
