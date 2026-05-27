package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC19b_APIntiated_To_APAccepted extends PlaywrightFactory {

	@Test
	public void TC19b() throws Exception {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "OperationsTeam", "OperationsTeam");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		// Press F11 to go full screen before anything else
		page.locator("body").press("F11");

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		// page.getByRole(AriaRole.ROW,
		// new Page.GetByRoleOptions()
		// .setName(" Show Details PRA WO-NGBB-0000973 AP Initiated DGN_00879 SA_Central NGBB"))
		// .locator("a")
		// .first()
		// .click();

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
				new Page.GetByRoleOptions().setName("OPS CheckList"))
				.locator("span")
				.nth(1)
				.click();

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions()
						.setName("OTDR Test Result (OSP1, OSP2"))
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName(
								"Acknowledgement Site Acceptance Date* Yes DynamicUser DYNAMIC-TELECOMMUNICATION"))
				.getByRole(AriaRole.COMBOBOX)
				.selectOption("Yes");

		page.getByTitle("Add").click();

		Thread.sleep(3000);

		page.locator("mat-tab-header")
				.filter(new Locator.FilterOptions()
						.setHasText("Workorder InfoTimeline"))
				.locator("button")
				.nth(1)
				.click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Construction Remarks"))
				.click();

		page.getByRole(AriaRole.HEADING,
				new Page.GetByRoleOptions()
						.setName("Opearation Team Remarks *"))
				.click();

		page.locator("textarea[name=\"operationRemarks\"]").click();

		page.locator("textarea[name=\"operationRemarks\"]")
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in APIntiated_To_APAccepted");

		closeBrowser();
	}
}