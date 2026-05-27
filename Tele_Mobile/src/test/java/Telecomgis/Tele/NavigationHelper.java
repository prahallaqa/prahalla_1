package Telecomgis.Tele;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavigationHelper {

    public static void openManageDesigns(Page page) {
        page.locator("rnd > button").click();
        // Fixed: Scope to menu panel, avoids tooltip conflict
        page.locator("#mat-menu-panel-8").getByText("Manage Designs").click();
    }

    public static void openManageWorkOrders(Page page) {
        page.locator("nrm > .mat-mdc-menu-trigger").click();
        page.getByText("Manage WorkOrders", new Page.GetByTextOptions().setExact(true)).click();
    }

    public static void openManageWorkOrdersUsingNrmButton(Page page) {
        page.locator("nrm").getByRole(AriaRole.BUTTON).click();
        page.getByText("Manage WorkOrders", new Page.GetByTextOptions().setExact(true)).click();
    }
}