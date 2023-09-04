package com.example.airlineTicketing.config;

import com.example.airlineTicketing.bot.AirlineBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class Beans
{
    @Bean
    public AirlineBot createTelegramBot()
    {
        return new AirlineBot("6507011061:AAEHEsfOES2l7En0bGTu-vZU1jwwtRf9ves");
    }
}
