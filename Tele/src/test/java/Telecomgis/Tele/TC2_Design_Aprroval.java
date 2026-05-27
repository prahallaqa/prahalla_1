package Telecomgis.Tele;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC2_Design_Aprroval extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "NetworkDesigner", "Aitek@123");
            NavigationHelper.openManageDesigns(page);

            // *********Enter design value here*******//
            page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("   DGN_00862 DGN_00862"))
                    .locator("a").first().click();

            page.getByLabel("SubmitApprove").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Skip Approval")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
            page.locator("#designslist").getByLabel("Close").click();

            System.out.println("Design approved");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}