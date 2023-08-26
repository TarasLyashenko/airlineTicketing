package com.example.airlineTicketing.bot;

import com.example.airlineTicketing.enumFlight.FlightStatus;
import jakarta.annotation.Resource;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AirlineBot extends TelegramLongPollingBot
{
    @Resource
    private FlightStatus flightStatus;

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
            if (params.length >= 4)
            {
                String departureCity = params[1];
                String destinationCity = params[2];
                String dateString = params[3] + "T" + params[4];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                LocalDateTime departureDateTime = LocalDateTime.parse(dateString, formatter);
                FlightStatus status = FlightStatus.OK;

                sendMessage(chatId, "Рейс добавлен");
            }
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
