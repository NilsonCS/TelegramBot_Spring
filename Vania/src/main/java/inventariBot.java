import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class inventariBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        
    }

    public String getBotUsername() {
        return "Liz bot";
    }

    public String getBotToken() {
        return "954935122:AAF7m3tQBFO9ZHG0FG_h-iV55FJTM5WlHzQ";
    }
}
