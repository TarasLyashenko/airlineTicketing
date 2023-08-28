package com.example.airlineTicketing.bot;

import com.example.airlineTicketing.entity.Flight;
import com.example.airlineTicketing.enumFlight.FlightStatus;
import com.example.airlineTicketing.service.FlightService;
import jakarta.annotation.Resource;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

public class AirlineBot extends TelegramLongPollingBot
{
    @Resource
    private FlightService flightService;

    public AirlineBot(String token)
    {
        super(token);
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        long chatId = update.getMessage().getChatId();
        if (message.getText().startsWith("flight+"))
        {
            String[] params = message.getText().split(" ");

            String departureCity = params[1];
            String destinationCity = params[2];
            String dateString = params[3];

            LocalDateTime departureDateTime = LocalDateTime.parse(dateString);

            FlightStatus status = FlightStatus.OK;

            Flight flight = new Flight();
            flight.setDepartureCity(departureCity);
            flight.setDestinationCity(destinationCity);
            flight.setDepartureTime(departureDateTime);
            flight.setStatus(status);

            flightService.saveFlight(flight);

            sendMessage(chatId, "Рейс добавлен");

        }
        else if (message.getText().startsWith("/flights"))
        {
            sendMessage(chatId, flightService.seeAllFlight());
        }
        else if (message.getText().startsWith("flightTime"))
        {
            String[] params = message.getText().split(" ");

            String flightCode = params[1];
            String newDateTime = params[2];

            Flight updatedFlight = flightService.findByCode(flightCode);
            LocalDateTime timeDepart = updatedFlight.getDepartureTime();
            updatedFlight.setDepartureTime(LocalDateTime.parse(newDateTime));
            updatedFlight.setStatus(FlightStatus.DELAYED);
            flightService.saveFlight(updatedFlight);

            sendMessage(chatId, "Время рейса для кода " + flightCode + " было успешно изменено.");
        }
        else if (message.getText().startsWith("flight-"))
        {
            String[] params = message.getText().split(" ");

            String flightCode = params[1];

            Flight updatedFlight = flightService.findByCode(flightCode);
            updatedFlight.setStatus(FlightStatus.CANCELED);
            flightService.saveFlight(updatedFlight);

            sendMessage(chatId, "Рейс номер - " + flightCode + " отменен.");
        }
        else
        {
            sendMessage(chatId, "Команда не распознана");
        }
    }

    @Override
    public String getBotUsername()
    {
        return "airlineTicketing_bot";
    }

    private void sendMessage(long chatId, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try
        {
            execute(sendMessage);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка при отправке сообщения: " + e.getMessage());
        }
    }
}
