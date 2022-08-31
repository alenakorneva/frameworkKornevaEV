package task3.service;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "getUsersData")
    public static Object[][] getUsersData() {
        return new User[][]{
                {UserCreator.getUser1WithCredentialsFromConfigurationFile()}, {UserCreator.getUser2WithCredentialsFromConfigurationFile()}
        };
    }
}
