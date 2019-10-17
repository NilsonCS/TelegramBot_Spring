package com.bot.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class InventaryTelegramMessageHandle extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        /** Recibiendo los mesajes que son enviados por los usuarios obteniendo su nombre y el mensaje**/
        System.out.println(update.getMessage().getFrom().getFirstName()+ ": " +update.getMessage().getText());

        //Enviando los mensajes

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText(" Estas en la parte de Inventario !!!!"+"\t" + update.getMessage().getFrom().getFirstName()+"\n"+
                "\n" +"A: Si desea ver el menu escriba /menu" );
        String comando = update.getMessage().getText();
        if (comando.equals("/menu")){
            sendMessage.setText("/A Agregar un nuevo producto"+"\n"+"/B Eliminar producto"+"\n"+"/C Editar producto"+"\n"+"/D Lista de productos");
        }if(comando.equals("/a")){
            sendMessage.setText("Usted eligio agregar productos");
        }if(comando.equals("/b")){
            sendMessage.setText("Usted eligio Eliminar produ+=]ctos");}
        if(comando.equals("/c")){
            sendMessage.setText("Usted eligio Editar productos");}
        if(comando.equals("/d")){
            sendMessage.setText("Usted eligio Listar productos");}

    }
    @Override
    public String getBotUsername() {
        return "GatoscBot";
    }

    @Override
    public String getBotToken() {
        return "${bot.avp256.token}";
    }
}
