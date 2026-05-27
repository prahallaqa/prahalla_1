package Telecomgis.Tele;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC8_Survey_Submitted_NW extends PlaywrightFactory {

	public static void main(String[] args) {
		Page page = null;
		try {
			page = startBrowser();
			LoginHelper.login(page, "NetworkDesigner", "Aitek@123");
			NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

			page.locator("#workorder_list").getByPlaceholder("Search").click();

			// **Enter WO number here**//

			page.locator("#workorder_list").getByPlaceholder("Search").fill("856");

			page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");
			page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Show Details ")).locator("a").first()
					.click();
			page.getByText("Approvals", new Page.GetByTextOptions().setExact(true)).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Survey Remarks")).click();
			page.locator("textarea[name='plannerRemarks']").click();
			page.locator("textarea[name='plannerRemarks']").fill("okayyyy");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
			System.out.println("now in Survey Validation Completed stage");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeBrowser();
		}
	}
}