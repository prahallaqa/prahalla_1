package Telecomgis.Tele;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC3_WO_Creation extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "NetworkDesigner", "Aitek@123");
            NavigationHelper.openManageWorkOrders(page);

            page.getByLabel("Add", new Page.GetByLabelOptions().setExact(true)).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Basic Info")).click();
            page.getByLabel("Basic Info").getByLabel("").click();
            page.getByText("Survey & Construction").click();
            page.locator("input[name='startdate']").fill("2026-04-01");
            page.locator("input[name='endDate']").fill("2026-06-19");

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Project Details")).click();
            page.locator("mat-select[name='projectName']").click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("NGBB")).locator("span").click();

            page.getByLabel("Project Details")
                    .getByLabel("", new Locator.GetByLabelOptions().setExact(true))
                    .locator("svg").click();

            // *********Enter cluster/design value here*******//
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("DGN_00863")).click();

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Vendor Details")).click();
            page.locator("#mat-select-54").click();
            page.getByText("FTTx Survey").click();
            page.getByLabel("Vendor Details").getByLabel("", new Locator.GetByLabelOptions().setExact(true)).click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("DYNAMIC-TELECOMMUNICATION SDN"))
                    .locator("span").click();

            page.locator("#workorder").getByLabel("Save").click();

            System.out.println("WO Created");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}