package com.example.airlineTicketing.config;

import com.example.airlineTicketing.bot.AirlineBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans
{
    @Bean
    public AirlineBot createTelegramBot()
    {
        return new AirlineBot("6507011061:AAFBkpZjHMRUiLJO0T05GRw26aHRZPPeU8Q");
    }
}
