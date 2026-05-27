package Telecomgis.Tele;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC6_User_Approved_Surveyinprogress extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "DynamicUser", "DynamicUser");
            NavigationHelper.openManageWorkOrders(page);

            page.locator("#workorder_list").getByPlaceholder("Search").click();
            page.locator("#workorder_list").getByPlaceholder("Search").fill("872");
            page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

            page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Show Details"))
                    .locator("a").first().click();

            page.getByText("Approvals").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Survey Remarks")).click();
            page.getByLabel("Survey Remarks").locator("a").click();
            page.getByLabel("Survey Remarks").getByRole(AriaRole.TEXTBOX).nth(1).click();
            page.getByLabel("Survey Remarks").getByRole(AriaRole.TEXTBOX).nth(1).fill("ok");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();

            System.out.println("now in Survey In Progress stage");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}