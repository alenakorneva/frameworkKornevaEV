package task3.service;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "getUsersData")
    public static Object[][] getUsersData() {
        return new User[][]{
                {InstanceCreator.getUser1WithCredentialsFromConfigurationFile()}, {InstanceCreator.getUser2WithCredentialsFromConfigurationFile()}
        };
    }
}
