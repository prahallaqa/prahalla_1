package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC17_CInProgress_To_APIntiated extends PlaywrightFactory {

	@Test
	public void TC17() {

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

		page.getByText("ConstructionStages").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Construction Stages"))
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions().setName("Mobilisation * NA"))
				.locator("svg")
				.click();

		page.getByText("Completed").click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions().setName("Civil Construction * NA"))
				.locator("svg")
				.click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Completed"))
				.locator("span")
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions().setName("Cable * NA"))
				.locator("svg")
				.click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Completed"))
				.locator("span")
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions().setName("Splicing * NA"))
				.locator("path")
				.click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Completed"))
				.locator("span")
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions().setName("Pretest * NA"))
				.locator("svg")
				.click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Completed"))
				.locator("span")
				.click();

		page.getByLabel("NA",
				new Page.GetByLabelOptions().setExact(true))
				.locator("svg")
				.click();

		page.getByText("Ready",
				new Page.GetByTextOptions().setExact(true))
				.click();

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Mobilisation * Completed"))
				.locator("input[name=\"startdate\"]")
				.fill("2026-05-01");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Civil Construction * Completed"))
				.locator("input[name=\"startdate\"]")
				.fill("2026-05-01");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Cable * Completed"))
				.locator("input[name=\"startdate\"]")
				.fill("2026-05-01");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Splicing * Completed"))
				.locator("input[name=\"startdate\"]")
				.fill("2026-05-01");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Pretest * Completed"))
				.locator("input[name=\"startdate\"]")
				.fill("2026-05-01");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions().setName("RFC * Ready"))
				.locator("input[name=\"startdate\"]")
				.fill("2026-05-01");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Mobilisation * Completed 2026-05-"))
				.locator("input[name=\"enddate\"]")
				.fill("2026-06-05");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Civil Construction *"))
				.locator("input[name=\"enddate\"]")
				.fill("2026-05-29");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Cable * Completed 2026-05-"))
				.locator("input[name=\"enddate\"]")
				.fill("2026-06-05");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Splicing * Completed 2026-05-"))
				.locator("input[name=\"enddate\"]")
				.fill("2026-06-12");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("Pretest * Completed 2026-05-"))
				.locator("input[name=\"enddate\"]")
				.fill("2026-06-12");

		page.getByRole(AriaRole.ROW,
				new Page.GetByRoleOptions()
						.setName("RFC * Ready 2026-05-"))
				.locator("input[name=\"enddate\"]")
				.fill("2026-06-12");

		page.getByLabel("Construction Stages")
				.getByRole(AriaRole.BUTTON,
						new Locator.GetByRoleOptions().setName("Save"))
				.click();

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByLabel("SubmitApprove").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("Now in CINprogress stage _ plz approve it");

		closeBrowser();
	}
}