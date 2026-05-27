package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class TC16_Construction_WorkAssignedToUser_To_CInProgress extends PlaywrightFactory {

	@Test
	public void TC16() {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "DynamicUser", "DynamicUser");

		// Navigate
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByText("Approvals").click();

		// Expand Construction Remarks section
		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Construction Remarks"))
				.click();

		// Click the + icon inside Construction Remarks
		page.getByLabel("Construction Remarks")
				.locator("a")
				.click();

		// Wait for the enabled comment input
		page.getByLabel("Approvals")
				.getByRole(AriaRole.TEXTBOX)
				.nth(2)
				.waitFor(new Locator.WaitForOptions()
						.setState(WaitForSelectorState.VISIBLE));

		// Fill the comment
		page.getByLabel("Approvals")
				.getByRole(AriaRole.TEXTBOX)
				.nth(2)
				.fill("ok");

		// Click the green checkmark button
		page.getByLabel("Construction Remarks")
				.locator("tbody button")
				.nth(1)
				.click(new Locator.ClickOptions().setForce(true));

		// Wait for Angular to process the save
		page.waitForTimeout(2000);

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in Construction InProgress");

		closeBrowser();
	}
}