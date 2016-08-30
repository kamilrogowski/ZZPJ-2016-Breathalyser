package zzpj.breathalyser.initialization;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Krzychu on 29.08.2016.
 */
public class UserDataInitializerTest {
    @Test
    public void initUsers() throws Exception {

        UserDataInitializer userDataInitializer = new UserDataInitializer();
        int result = userDataInitializer.initUsers().size();
        int expected = 5;
        Assert.assertEquals(expected, result);
    }

}