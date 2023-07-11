package praktikum.dataprovider;

import org.apache.commons.lang3.RandomStringUtils;
import praktikum.pojo.User;

public class UserProvider {
    public static User getRandomUser() {
        User user = new User(RandomStringUtils.randomAlphabetic(8),
                RandomStringUtils.randomAlphanumeric(8) + "@" + RandomStringUtils.randomAlphabetic(8) +
                        "." + RandomStringUtils.randomAlphabetic(2), RandomStringUtils.randomAlphabetic(8));
        return user;
    }

    public static User getRandomUserWithTooShortPassword() {
        User user = new User(RandomStringUtils.randomAlphabetic(8),
                RandomStringUtils.randomAlphanumeric(8) + "@" + RandomStringUtils.randomAlphabetic(8) +
                        "." + RandomStringUtils.randomAlphabetic(2), RandomStringUtils.randomAlphabetic(5));
        return user;
    }
}
