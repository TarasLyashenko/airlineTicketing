package com.example.airlineTicketing;

import com.example.airlineTicketing.bot.AirlineBot;
import com.example.airlineTicketing.dao.FlightDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class AirlineTicketingApplication implements CommandLineRunner
{
    @Resource
    private FlightDao flightDao;
    @Resource
    private AirlineBot airlineBot;
    @Resource
    private JavaMailSender emailSender;

    public static void main(String[] args)
    {
        SpringApplication.run(AirlineTicketingApplication.class, args);
    }

    @PostConstruct
    public void registerBot()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("Кому (для тестов сюда просто впиши свою почту)");
        message.setSubject("Тема письма");
        message.setText("Текст письма");

        emailSender.send(message);
    }

    @Override
    public void run(String... args) throws Exception
    {

    }
}
