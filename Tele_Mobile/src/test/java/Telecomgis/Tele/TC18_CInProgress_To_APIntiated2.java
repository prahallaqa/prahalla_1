package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC18_CInProgress_To_APIntiated2 extends PlaywrightFactory {

	@Test
	public void TC18() {

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

		page.getByLabel("SubmitApprove").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in AP intiated Stage");

		closeBrowser();
	}
}