package zzpj.breathalyser.initialization;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krzychu on 29.08.2016.
 */
public class UserDataInitializerTest {
    @Test
    public void initUsers() throws Exception {

        UserDataInitializer userDataInitializer = new UserDataInitializer();
        int result = userDataInitializer.initUsers().size();
        int expected = 10;
        Assert.assertEquals(expected, result);
    }

}