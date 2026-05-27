package Telecomgis.Tele;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC1_LogintoNWD_DesignCreation extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "NetworkDesigner", "Aitek@123");
            NavigationHelper.openManageDesigns(page);

            page.getByLabel("New Design").click();
            page.getByText("Automatic", new Page.GetByTextOptions().setExact(true)).click();
            page.locator("#mat-select-value-51").click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("FTTx")).click();
            page.locator("#mat-select-value-53").click();
            page.getByText("Site-FDC-FDP-PP(OH)").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Basic Info")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clusters").setExact(true)).click();

            Locator searchBox = page.getByLabel("Properties").getByPlaceholder("Search");
            searchBox.click();

            // *********Enter cluster value here*******//
            searchBox.fill("7763");

            page.waitForTimeout(2000);
            page.getByLabel("Properties").getByLabel("", new Locator.GetByLabelOptions().setExact(true)).check();
            page.locator("button").filter(new Locator.FilterOptions().setHasText("nfc")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();

            System.out.println("Design created");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}