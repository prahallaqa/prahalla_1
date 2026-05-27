package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC19a_APIntiated_Pirollout extends PlaywrightFactory {

	@Test
	public void TC19() throws Exception {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "PIROLLOUT", "PIROLLOUT");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.locator("mat-tab-header")
				.filter(new Locator.FilterOptions()
						.setHasText("Workorder InfoTimeline"))
				.locator("button")
				.nth(1)
				.click();

		page.getByRole(AriaRole.TAB,
				new Page.GetByRoleOptions().setName("PI CheckList"))
				.locator("span")
				.nth(1)
				.click();

		page.getByLabel("PI CheckList")
				.getByLabel("Save")
				.click();

//		page.getByRole(AriaRole.ROW,
//				new Page.GetByRoleOptions()
//						.setName("Installation FDC/FDF/ODF/P.PANEL/FDP Mounting (Rack/Floor/Plinth/Wall)* Yes"))
//				.getByRole(AriaRole.COMBOBOX)
//				.selectOption("Yes");
//
//		page.getByTitle("Add").click();

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName("End to End Fiber Port"))
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("HANDOVER DOCUMENTS Civil Duct"))
				.getByRole(AriaRole.COMBOBOX)
				.selectOption("Yes");

		page.getByTitle("Add").click();

		page.getByLabel("PI CheckList")
				.getByLabel("Close")
				.click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Construction Remarks"))
				.click();

		Thread.sleep(1000);

		page.locator("textarea[name=\"piTeamRemarks\"]").click();

		Thread.sleep(1000);

		page.locator("textarea[name=\"piTeamRemarks\"]")
				.fill("ok");

		Thread.sleep(2000);

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in AP intiated Stage");

		closeBrowser();
	}
}