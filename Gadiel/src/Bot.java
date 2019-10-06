import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import javax.xml.soap.SOAPPart;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName() + ": " +update.getMessage().getText());
        // enviar mensaje
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        SendMessage.setText("Hola" + update.getMessage().getFrom().getFirstName() + "\n" + update.getMessage().getText());
        try
        {
            sendMessage(sendMessage);
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "803277618:AAGDcQABTx3S71htwRydKVqMMXC3d5iyKYU";
    }
}
