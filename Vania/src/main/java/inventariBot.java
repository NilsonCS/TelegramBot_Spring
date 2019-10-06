import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class inventariBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getFrom().getFirstName()+ ": " +update.getMessage().getText());

        //Enviando los mensajes

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Bienvenido!!!!" + update.getMessage().getFrom().getFirstName()+"\n"+ update.getMessage().getText());

        try
        {
            sendMessage(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "Liz bot";
    }

    public String getBotToken() {
        return "954935122:AAF7m3tQBFO9ZHG0FG_h-iV55FJTM5WlHzQ";
    }
}
