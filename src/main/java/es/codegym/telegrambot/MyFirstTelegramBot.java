package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "catmatt_bot";
    public static final String TOKEN = "6598077645:AAE1eKa8dqc-CRBK1S4m5eXZafmvKZpWUI4";
    String gato;

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Robar salchicha! +20 puntos","step_2_btn",
                            "¡tomar pescado! + 20 puntos","step_2_btn",
                            "¡tirar tomar una lata de pepinillos! + 20 puntos","step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("¡romper el robot aspiradora! ","step_3_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("¡mandar al robot por comida! +30 puntos","step_4_btn",
                            "¡Dar un paseo en el robot! +30 puntos","step_4_btn",
                            "¡huir del robot aspiradora! + 30 puntos","step_4_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("ponerse la go pro","step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("¡comerte un salmon fresco!","step_6_btn",
                            "¡comerte un churu sabor a pollo! ","step_6_btn",
                            "¡un masaje en la panza! ","step_6_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("¡hackea la contraseña de la computadora! ","step_7_btn"));
            sendPhotoMessageAsync("step_7_pic");
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("salir a pasear fuera...","step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of());
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}