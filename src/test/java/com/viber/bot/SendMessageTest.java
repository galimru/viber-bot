package com.viber.bot;

import com.google.common.collect.ImmutableList;
import com.viber.bot.api.ApiResponse;
import com.viber.bot.messages.ActionType;
import com.viber.bot.messages.Button;
import com.viber.bot.messages.Keyboard;
import com.viber.bot.messages.TextMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SendMessageTest {

    private ViberBot viberBot;

    @Before
    public void setup() throws IOException {
        viberBot = new ViberBot(Constants.NAME, Constants.TOKEN);
        viberBot.listen(Constants.SERVER_HOST, Integer.parseInt(Constants.SERVER_PORT), Constants.WEBHOOK_PATH);
    }

    @Test
    public void shouldWorkTextMessage() {
        ApiResponse response = viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("shouldWorkTextMessage"));
        Assert.assertEquals(0, (long)response.getStatus());
    }

    @Test
    public void shouldWorkTextMessageWithKeyboard() {
        TextMessage message = new TextMessage("shouldWorkTextMessageWithKeyboard");
        message.setKeyboard(new Keyboard().setButtons(ImmutableList.of(
                new Button()
                        .setText("Hello")
                        .setActionType(ActionType.REPLY)
                        .setActionBody("test"))));
        ApiResponse response = viberBot.sendMessage(Constants.VIBER_USER_ID, message);
        Assert.assertEquals(0, (long)response.getStatus());
    }
}
