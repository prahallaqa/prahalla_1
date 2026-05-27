package Telecomgis.Tele;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC4_Submit_WO extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "NetworkDesigner", "Aitek@123");
            NavigationHelper.openManageWorkOrders(page);

            page.locator("#workorder_list").getByPlaceholder("Search").click();

            // *********Enter WO Number here*******//
            page.locator("#workorder_list").getByPlaceholder("Search").fill("929");
            page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

            page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Show Details "))
                    .locator("a").first().click();

            page.getByLabel("SubmitApprove").click();
            page.locator("#workorder_list").getByLabel("Close").click();

            page.getByText("Network Designer").click();
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Sign Out")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();

            System.out.println("WO Submitted");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}