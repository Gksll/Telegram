package com.gokseldogandev.Telegram.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {

        return "GokselCekinoBot";
    }

    @Override
    public String getBotToken() {
        return "7187559726:AAF2I0kHlxiZinG_msijB8Z1e-PXCkfhMJY";
    }

    @Override
    public void onUpdateReceived(Update update) {
            long chatId = update.getMessage().getChatId();
            try {
                execute(new SendMessage(Long.toString(chatId), "Merhaba Selam Olsun!!"));
        } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }


}
    public void sendMessageToNumber(String phoneNumber, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(phoneNumber);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}