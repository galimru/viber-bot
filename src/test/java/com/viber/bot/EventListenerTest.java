package com.viber.bot;

import com.viber.bot.messages.TextMessage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

public class EventListenerTest {

    private ViberBot viberBot;

    @Before
    public void setup() throws IOException {
        viberBot = new ViberBot(Constants.NAME, Constants.TOKEN);
        viberBot.listen(Constants.SERVER_HOST, Integer.parseInt(Constants.SERVER_PORT), Constants.WEBHOOK_PATH);
    }

    @Test
    public void shouldReceiveWebhookEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.addWebhookListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        await().atMost(10, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

    @Test
    public void shouldReceiveMessageEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        viberBot.addMessageListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("Please write message to continue testing"));
        await().atMost(60, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

    @Test
    public void shouldReceiveSeenEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        viberBot.addSeenListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("Please open this message to continue testing"));
        await().atMost(60, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

    @Test
    public void shouldReceiveDeliveredEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        viberBot.addDeliveredListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("This message should be delivered"));
        await().atMost(60, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

    @Test
    public void shouldReceiveSubscribedEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        viberBot.addSubscribedListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("Please subscribe to continue testing"));
        await().atMost(60, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

    @Test
    public void shouldReceiveUnsubscribedEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        viberBot.addUnsubscribedListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("Please unsubscribe to continue testing"));
        await().atMost(60, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

    @Test
    public void shouldReceiveConversationStartedEvent() {
        AtomicBoolean eventReceived = new AtomicBoolean();
        viberBot.setWebhook(Constants.WEBHOOK_HOST + Constants.WEBHOOK_PATH);
        viberBot.addConversationStartedListener((event, response) -> {
            eventReceived.set(true);
        });
        viberBot.sendMessage(Constants.VIBER_USER_ID, new TextMessage("Please start conversation to continue testing"));
        await().atMost(60, TimeUnit.SECONDS).untilTrue(eventReceived);
    }

}
