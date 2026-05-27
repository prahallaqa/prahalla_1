package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC12_PermitSubitted_To_PermitObtained extends PlaywrightFactory {

	@Test
	public void TC12() {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "NIPMCentral", "NIPMCentral");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByRole(AriaRole.TAB,
				new Page.GetByRoleOptions().setName("Approvals"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Permit Remarks"))
				.click();

		page.locator("textarea[name=\"nipmRemarks\"]").click();

		page.locator("textarea[name=\"nipmRemarks\"]")
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.waitForTimeout(10000);

		System.out.println("Now in permit obtained stage");

		closeBrowser();
	}
}