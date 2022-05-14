import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private String name;
    private boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][] {
                {"Тимоти Шаламе", true},
                {"Т Ш", true},
                {"Тимотити Шаламемеме", true},
                {"Timothee Chalamet", true},
                {"Тимоти Шаламе1", true},
                {"TШ", false},
                {"Тимотити Шаламемемее", false},
                {"ТимотиШаламе", false},
                {"Тимоти  Шаламе", false},
                {"Тимоти ", false},
                {" Тимоти", false},
                {" ", false},
                {null, false}
        };
    }

    @Test
    public void accountTest() {
        Account account = new Account(name);
        assertEquals("Некорректное имя", account.checkNameToEmboss(), expectedResult);
    }
}
