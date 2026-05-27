package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC5_AssignedToCompany_To_AssignedtoVendorUser extends PlaywrightFactory {
	@Test
	public void TC5() {
		Page page = startBrowser();
		LoginHelper.login(page, "DynamicLead", "DynamicLead");
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);
		// page.locator("#workorder_list").getByPlaceholder("Search").click();
		// ********* Enter WO Number here *******//
		// page.locator("#workorder_list").getByPlaceholder("Search").fill("938");
		// page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");
		page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Show Details")).locator("a").first()
				.click();
		page.waitForTimeout(2000);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Vendor Details")).click();
		page.getByLabel("Vendor Details").getByLabel("", new Locator.GetByLabelOptions().setExact(true)).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Dynamic User"))
				.locator("mat-pseudo-checkbox").click();
		page.locator(".cdk-overlay-backdrop").click();
		page.waitForTimeout(2000);
		page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Approvals")).locator("span").nth(1).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Survey Remarks")).click();
		page.locator("textarea[name='leadWorkAcceptance']").click();
		page.locator("textarea[name='leadWorkAcceptance']").fill("approved by dynamic lead");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();
		page.waitForTimeout(10000);
		System.out.println("Assigned to Vendor user");
		/// **Logout**//
		page.getByText("Dynamic Lead").click();
		page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Sign Out")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
		closeBrowser();
	}
}