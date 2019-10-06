import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class inventariBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        String a = update.getMessage().getText();
        String b = update.getMessage().getFrom().getFirstName();
        System.out.println(b + " Dijo: "+a);
    }

    public String getBotUsername() {
        return "Liz bot";
    }

    public String getBotToken() {
        return "954935122:AAF7m3tQBFO9ZHG0FG_h-iV55FJTM5WlHzQ";
    }
}
