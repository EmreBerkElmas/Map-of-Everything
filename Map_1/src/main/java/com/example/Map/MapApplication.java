package com.example.Map;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.Map.entities.EnergyConsumptionData;

@SpringBootApplication
public class MapApplication implements CommandLineRunner {

static List<EnergyConsumptionData> countryList ;


@Autowired
private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
        SpringApplication.run(MapApplication.class, args);
        
        
	}

	@Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM energy_consumption_data";
         
         countryList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(EnergyConsumptionData.class));
        
        
    }

}
