package task2613.resources;

import java.util.ListResourceBundle;

public class verifiedCards extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"123456789012", "1234"},
                {"234567890123", "2345"},
                {"345678901234", "3456"}
        };
    }
}
