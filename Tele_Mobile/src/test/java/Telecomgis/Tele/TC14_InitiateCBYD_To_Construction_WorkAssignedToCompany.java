package Telecomgis.Tele;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC14_InitiateCBYD_To_Construction_WorkAssignedToCompany extends PlaywrightFactory {

	@Test
	public void TC14() {

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

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Vendor Details"))
				.click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Construction Remarks"))
				.click();

		page.locator("textarea[name=\"piRemarks\"]").click();

		page.locator("textarea[name=\"piRemarks\"]")
				.fill("ok");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		page.getByText("Documents").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Upload Document"))
				.click();

		page.getByText("-Select Document Type-").click();

		page.getByText("CBYD Letter").click();

		page.getByLabel("Upload Document")
				.getByText("…")
				.click();

		page.getByLabel("Upload Document")
				.locator("input[name='file']")
				.setInputFiles(
						Paths.get(
								"D:/eclipse-workspace/Tele/src/test/resources/OSSMS_SAP API_Specification_v5.3.16.docx"));

		page.getByLabel("Upload Document")
				.getByRole(AriaRole.BUTTON,
						new Locator.GetByRoleOptions().setName("Upload Document"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		page.getByText("Approvals").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Accept"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in Construction Work Assigned To Company");

		closeBrowser();
	}
}