package com.example.airlineTicketing.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AirlineBot extends TelegramLongPollingBot
{
    public AirlineBot(String token)
    {
        super(token);
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        long chatId = update.getMessage().getChatId();
        if (message.getText().startsWith("hi"))
        {
            sendMessage(chatId, "hi");
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
