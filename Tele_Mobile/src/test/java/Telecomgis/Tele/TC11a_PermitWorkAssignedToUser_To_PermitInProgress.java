package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC11a_PermitWorkAssignedToUser_To_PermitInProgress extends PlaywrightFactory {

	@Test
	public void TC11a() throws Exception {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "DynamicUser", "DynamicUser");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		Thread.sleep(2000);

		// Open Permit Type section
		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Permit Remarks"))
				.click();

		page.getByLabel("Permit Remarks")
				.locator("a")
				.click();

		page.getByLabel("Permit Remarks")
				.getByRole(AriaRole.TEXTBOX)
				.nth(1)
				.click();

		page.getByLabel("Permit Remarks")
				.getByRole(AriaRole.TEXTBOX)
				.nth(1)
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in Permit InProgress Stage");

		closeBrowser();
	}
}