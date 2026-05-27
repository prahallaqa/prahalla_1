package Telecomgis.Tele;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC5_Assigned_To_Company_User extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "DynamicLead", "DynamicLead");
            NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

            page.locator("#workorder_list").getByPlaceholder("Search").click();

            // *********Enter WO Number here*******//
            page.locator("#workorder_list").getByPlaceholder("Search").fill("872");
            page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

            page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Show Details"))
                    .locator("a").first().click();

            page.waitForTimeout(2000);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Vendor Details")).click();
            page.getByLabel("Vendor Details").getByLabel("", new Locator.GetByLabelOptions().setExact(true)).click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Dynamic User"))
                    .locator("mat-pseudo-checkbox").click();
            page.locator(".cdk-overlay-backdrop").click();

            page.waitForTimeout(2000);

            page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Approvals"))
                    .locator("span").nth(1).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Survey Remarks")).click();
            page.locator("textarea[name='leadWorkAcceptance']").click();
            page.locator("textarea[name='leadWorkAcceptance']").fill("approved by dynamic lead");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();

            page.waitForTimeout(10000);

            System.out.println("Assigned to Vendor user");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}