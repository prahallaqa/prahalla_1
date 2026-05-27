package Telecomgis.Tele;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC20_APAccepted_To_ChecklistSubmitted extends PlaywrightFactory {

	@Test
	public void TC20() {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "DynamicUser", "DynamicUser");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		// Press F11 to go fullscreen before anything else
		page.locator("body").press("F11");

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.locator("mat-tab-header")
				.filter(new Locator.FilterOptions().setHasText("Workorder"))
				.locator("button")
				.nth(1)
				.click();

		page.getByText("Documents").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Upload Document"))
				.click();

		page.getByLabel("Upload Document")
				.locator("svg")
				.click();

		page.getByText("Checklist Attachment").click();

		page.getByText("Upload file …").click();

		// page.getByLabel("Upload
		// Document").locator("input[name=\"file\"]").click();

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

		page.getByLabel("Upload Document")
				.locator("svg")
				.click();

		page.getByText("Supported Attachment").click();

		page.getByLabel("Upload Document")
				.locator("input[name=\"file\"]")
				.click();

		page.getByLabel("Upload Document")
				.locator("input[name=\"file\"]")
				.setInputFiles(Paths.get("bts site.csv"));

		page.getByLabel("Upload Document")
				.getByRole(AriaRole.BUTTON,
						new Locator.GetByRoleOptions().setName("Upload Document"))
				.click();

		page.getByLabel("Upload Document")
				.locator("svg")
				.click();

		page.getByText("CPC Submission").click();

		page.getByLabel("Upload Document")
				.locator("input[name=\"file\"]")
				.click();

		page.getByLabel("Upload Document")
				.getByText("…")
				.click();

		page.getByLabel("Upload Document")
				.locator("input[name=\"file\"]")
				.setInputFiles(Paths.get("bts site.csv"));

		page.getByLabel("Upload Document")
				.getByRole(AriaRole.BUTTON,
						new Locator.GetByRoleOptions().setName("Upload Document"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		page.getByText("CMB CheckList").click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Fiber Verify NCR Geographical"))
				.getByRole(AriaRole.COMBOBOX)
				.selectOption("Yes");

		page.getByTitle("Add").click();

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