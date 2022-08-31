package task3.service;

public class UserCreator {

    public static final String FIRST_NAME_USER_1 = "firstNameOfUser1";
    public static final String LAST_NAME_USER_1 = "lastNameOfUser1";
    public static final String EMAIL_USER_1 = "emailOfUser1";
    public static final String AGE_USER_1 = "ageOfUser1";
    public static final String SALARY_USER_1 = "salaryOfUser1";
    public static final String DEPARTMENT_USER_1 = "departmentOfUser1";

    public static final String FIRST_NAME_USER_2 = "firstNameOfUser2";
    public static final String LAST_NAME_USER_2 = "lastNameOfUser2";
    public static final String EMAIL_USER_2 = "emailOfUser2";
    public static final String AGE_USER_2 = "ageOfUser2";
    public static final String SALARY_USER_2 = "salaryOfUser2";
    public static final String DEPARTMENT_USER_2 = "departmentOfUser2";

    public static User getUser1WithCredentialsFromConfigurationFile() {

        return User.builder().firstName(TestDataReaderFromTestFile.getStringValueFromJsonByKey(FIRST_NAME_USER_1))
                .lastName(TestDataReaderFromTestFile.getStringValueFromJsonByKey(LAST_NAME_USER_1))
                .email(TestDataReaderFromTestFile.getStringValueFromJsonByKey(EMAIL_USER_1))
                .age(TestDataReaderFromTestFile.getLongValueFromJsonByKey(AGE_USER_1))
                .salary(TestDataReaderFromTestFile.getLongValueFromJsonByKey(SALARY_USER_1))
                .department(TestDataReaderFromTestFile.getStringValueFromJsonByKey(DEPARTMENT_USER_1)).build();
    }

    public static User getUser2WithCredentialsFromConfigurationFile() {

        return User.builder().firstName(TestDataReaderFromTestFile.getStringValueFromJsonByKey(FIRST_NAME_USER_2))
                .lastName(TestDataReaderFromTestFile.getStringValueFromJsonByKey(LAST_NAME_USER_2))
                .email(TestDataReaderFromTestFile.getStringValueFromJsonByKey(EMAIL_USER_2))
                .age(TestDataReaderFromTestFile.getLongValueFromJsonByKey(AGE_USER_2))
                .salary(TestDataReaderFromTestFile.getLongValueFromJsonByKey(SALARY_USER_2))
                .department(TestDataReaderFromTestFile.getStringValueFromJsonByKey(DEPARTMENT_USER_2)).build();
    }
}
