package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC15_Construction_WorkAssignedToCompany_To_User extends PlaywrightFactory {

	@Test
	public void TC15() {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "DynamicLead", "DynamicLead");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Vendor Details"))
				.click();

		page.getByLabel("Vendor Details")
				.getByLabel("",
						new Locator.GetByLabelOptions().setExact(true))
				.locator("path")
				.click();

		// page.getByRole(AriaRole.OPTION,
		// new Page.GetByRoleOptions().setName("Dynamic User"))
		// .locator("mat-pseudo-checkbox").click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Dynamic User"))
				.click();

		page.locator(".cdk-overlay-backdrop").click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Construction Remarks"))
				.click();

		page.locator("textarea[name=\"constLeadRemarks\"]").click();

		page.locator("textarea[name=\"constLeadRemarks\"]")
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in Construction Work Assigned To User");

		closeBrowser();
	}
}