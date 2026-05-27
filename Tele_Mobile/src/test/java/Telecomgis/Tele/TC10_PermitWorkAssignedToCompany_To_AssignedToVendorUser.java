package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC10_PermitWorkAssignedToCompany_To_AssignedToVendorUser extends PlaywrightFactory {

	@Test
	public void TC10() {

		Page page = startBrowser();

		LoginHelper.login(page, "DynamicLead", "DynamicLead");

		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		// page.locator("#workorder_list").getByPlaceholder("Search").click();

		// **Enter WO number here**//

		// page.locator("#workorder_list").getByPlaceholder("Search").fill("938");
		// page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Vendor Details"))
				.click();

		page.getByLabel("Vendor Details")
				.getByLabel("", new Locator.GetByLabelOptions().setExact(true))
				.click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Dynamic User"))
				.locator("mat-pseudo-checkbox")
				.click();

		page.locator(".cdk-overlay-backdrop").click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Permit Remarks"))
				.click();

		page.getByLabel("Permit Remarks")
				.getByRole(AriaRole.TEXTBOX)
				.click();

		page.getByLabel("Permit Remarks")
				.getByRole(AriaRole.TEXTBOX)
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("now in Permit Remarks Completed stage");

		/// **Logout**//

		page.getByText("Dynamic Lead").click();

		page.getByRole(AriaRole.MENUITEM,
				new Page.GetByRoleOptions().setName("Sign Out"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Yes"))
				.click();

		System.out.println("Permit Work Assigned To Vendor User");

		closeBrowser();
	}
}