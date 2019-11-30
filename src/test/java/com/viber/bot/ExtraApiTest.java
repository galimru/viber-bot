package com.viber.bot;

import com.viber.bot.api.AccountInfo;
import com.viber.bot.api.OnlineStatus;
import com.viber.bot.api.UserDetails;
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

    @Test
    public void shouldGetUserDetails() {
        UserDetails userDetails = viberBot.getUserDetails(Constants.VIBER_USER_ID);
        Assert.assertNotNull(userDetails);
        Assert.assertNotNull(userDetails.getUser());
    }

    @Test
    public void shouldGetOnlineStatus() {
        OnlineStatus onlineStatus = viberBot.getOnlineStatus(Constants.VIBER_USER_ID);
        Assert.assertNotNull(onlineStatus);
        Assert.assertEquals(1, onlineStatus.getUsers().size());
    }
}
