package com.viber.bot;

import com.viber.bot.api.AccountInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExtraApiTest {

    private ViberBot viberBot;

    @Before
    public void setup() {
        viberBot = new ViberBot(Constants.NAME, Constants.TOKEN);
    }

    @Test
    public void shouldGetAccountInfo() {
        AccountInfo accountInfo = viberBot.getAccountInfo();
        Assert.assertNotNull(accountInfo);
        Assert.assertNotNull(accountInfo.getId());
        Assert.assertNotNull(accountInfo.getName());
        // TODO check all fields
    }
}
