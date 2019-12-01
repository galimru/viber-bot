# Viber Bot for Java ☕

[![Build Status](https://travis-ci.org/galimru/viber-bot.svg?branch=develop)](https://travis-ci.org/galimru/viber-bot)
[![Release](https://jitpack.io/v/galimru/viber-bot.svg)](https://jitpack.io/#galimru/viber-bot)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Use this library to develop a bot for the Viber platform. The official Viber Bot library for java is deprecated so I recommend to use this library instead of official.

## Installation

Import the library to your project using [jitpack](https://jitpack.io/#galimru/viber-bot/2.0.0.S2) repository 

#### Gradle

  1. Add the JitPack repository to your build file
  
```gradle
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

  2. Add the Viber Bot library dependency

```gradle
implementation 'com.github.galimru:viber-bot:2.0.0.S12'
```

_Note: The JitPack supports both Gradle/Maven build tools, please refer to jitpack [documentation](https://jitpack.io/#galimru/viber-bot) if you want use Maven_

## Usage

1. Create ViberBot instance with bot name and auth token
2. Start callback server to receive webhook requests
3. Register webhook url in Viber API
4. Add message listener to handle incoming events
5. Use `sendMessage` method to send any type of message

You also can use own webserver to receive webhook requests. In that case, you will have to transform json body to `IncomingEvent` object using jackson library and provide this object to method `ViberBot#handle()`.

#### Creating an echo bot

In this example we use ngrok to have external url pointed to local machine on port 8080.

```java
public class Example {

    public static void main(String[] args) throws IOException {
        ViberBot viberBot = new ViberBot("My Bot", "<AUTH_TOKEN>");
        // start server on 8080 port with path /callback
        viberBot.listen("/callback");
        // let Viber API know about webhook url
        viberBot.setWebhook("https://16063f37.ngrok.io/callback");
        // subscribes on message events 
        viberBot.addMessageListener((event, response) -> {
            Message message = event.getMessage();
            if (message.getType() == MessageType.TEXT) {
                TextMessage textMessage = (TextMessage) message;
                // send message back to user
                viberBot.sendMessage(message.getSender().getId(), 
                        new TextMessage().setText("echo " + textMessage.getText()));
            }
        });
    }
}
```

## Limitations

Currently, the library doesn't support SSL termination on callback server. 
It means you will have to use another webserver behind callback server which supports SSL configuration. 
The Viber API requires to use HTTPS for webhook addresses.

## Links

* [Viber API Documentation](https://developers.viber.com/docs/all/)
* [Viber Admin Panel](https://partners.viber.com/login)
* [Official Viber Bot Java](https://partners.viber.com/login) ️[Deprecated]
* [JitPack Repository](https://jitpack.io/#galimru/viber-bot)

## License

This library is released under the terms of the Apache 2.0 license. See License for more information.