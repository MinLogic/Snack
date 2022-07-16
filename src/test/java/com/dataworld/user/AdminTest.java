package com.dataworld.user;

import com.dataworld.db.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminTest {
    Admin admin = new Admin("admin", "admin");
    Users users;

    @Before
    public void init() {
        users = Users.getInstance();
    }

    @Test
    public void testRegUser() {
        CommonUser commonUser = new CommonUser("common", "1234");
        admin.regUser(commonUser);
        Assert.assertEquals(commonUser, users.retrieveUser("common"));
    }

    @Test
    public void testDelUser() {
    }

    @Test
    public void testRegProduct() {
    }

    @Test
    public void testDelProduct() {
    }

    @Test
    public void testSetStandard() {
    }
}