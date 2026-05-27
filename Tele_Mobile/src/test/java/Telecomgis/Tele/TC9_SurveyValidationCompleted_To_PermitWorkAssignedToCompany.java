package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC9_SurveyValidationCompleted_To_PermitWorkAssignedToCompany extends PlaywrightFactory {

	@Test
	public void TC9() {

		Page page = startBrowser();

		LoginHelper.login(page, "NIPMCentral", "NIPMCentral");

		page.locator("nrm")
				.getByRole(AriaRole.BUTTON)
				.click();

		page.getByText("Manage WorkOrders",
				new Page.GetByTextOptions().setExact(true))
				.click();

		// page.locator("#workorder_list").getByPlaceholder("Search").click();

		// **Enter the WO Number here***//

		// page.locator("#workorder_list").getByPlaceholder("Search").fill("938");

		// page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details "))
				.locator("a")
				.first()
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions()
						.setName("Required Documents for Permit"))
				.click();

		page.getByLabel("Proceed to Permit").check();

		page.getByLabel("Both").check();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Survey Remarks"))
				.click();

		page.getByLabel("SubmitApprove").click();

		page.locator("#ajax-loading").click();

		System.out.println("Permit Work Assigned To Company");

		closeBrowser();
	}
}