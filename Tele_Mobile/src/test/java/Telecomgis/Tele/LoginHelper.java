package Telecomgis.Tele;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginHelper {

    public static void login(Page page, String username, String password) {
        page.navigate("https://192.168.2.200:543");
        page.locator("input[name='LoginId']").fill(username);
        page.locator("input[name='Password']").fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("NMO NMO")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
    }
}