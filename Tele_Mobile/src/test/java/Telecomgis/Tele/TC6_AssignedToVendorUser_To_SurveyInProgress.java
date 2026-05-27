package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC6_AssignedToVendorUser_To_SurveyInProgress extends PlaywrightFactory {

	@Test
	public void TC6() {

		Page page = startBrowser();

		LoginHelper.login(page, "DynamicUser", "DynamicUser");

		NavigationHelper.openManageWorkOrders(page);

		// page.locator("#workorder_list").getByPlaceholder("Search").click();

		// **Enter the WO Number Here**//

		// page.locator("#workorder_list").getByPlaceholder("Search").fill("938");
		// page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Survey Remarks"))
				.click();

		page.getByLabel("Survey Remarks")
				.locator("a")
				.click();

		page.getByLabel("Survey Remarks")
				.getByRole(AriaRole.TEXTBOX)
				.nth(1)
				.click();

		page.getByLabel("Survey Remarks")
				.getByRole(AriaRole.TEXTBOX)
				.nth(1)
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("now in Survey In Progress stage");

		closeBrowser();
	}
}