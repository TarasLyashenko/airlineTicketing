package com.example.airlineTicketing;

import com.example.airlineTicketing.bot.AirlineBot;
import com.example.airlineTicketing.dao.FlightDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class AirlineTicketingApplication implements CommandLineRunner
{
    @Resource
    private FlightDao flightDao;
    @Resource
    private AirlineBot airlineBot;

    public static void main(String[] args)
    {
        SpringApplication.run(AirlineTicketingApplication.class, args);
    }

    @PostConstruct
    public void registerBot()
    {
        try
        {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(airlineBot);
        }
        catch (TelegramApiException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run(String... args) throws Exception
    {

    }
}
