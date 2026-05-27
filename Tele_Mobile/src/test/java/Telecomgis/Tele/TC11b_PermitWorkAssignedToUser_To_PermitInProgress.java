package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC11b_PermitWorkAssignedToUser_To_PermitInProgress extends PlaywrightFactory {

	@Test
	public void TC11b() throws Exception {

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

		Thread.sleep(2000);

		// Open Permit Type section
		page.getByText("Permit Type").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Permit Type Details"))
				.click();

		Locator permitSection = page.locator("mat-expansion-panel")
				.filter(new Locator.FilterOptions()
						.setHasText("Permit Type Details"));

		// Select permit type
		permitSection.locator("mat-select[name='permitType']").click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions()
						.setName("InternalTrenchingPermit"))
				.click();

		// Select state
		permitSection.locator("mat-select").nth(1).click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("JOHOR"))
				.click();

		page.getByLabel("Permit Type Details")
				.getByLabel("",
						new Locator.GetByLabelOptions().setExact(true))
				.locator("path")
				.click();

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions().setName("Easy"))
				.click();

		// Add permit details
		page.locator("input[name='itpName']").fill("abc5");

		page.locator("input[name='contactInfo']")
				.fill("0123456789");

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Add Permit"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		page.waitForTimeout(2000);

		// Re-open Permit Type Details section if collapsed
		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Permit Type Details"))
				.click();

		// Open exact permit panel
		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions()
						.setName("abc5")
						.setExact(true))
				.click();

		// Fill permit status details
		page.locator("input[name='contactPerson']")
				.fill("praha3");

		page.locator("input[name='contactNumber']")
				.fill("0123456789");

		page.waitForTimeout(1000);

		page.locator("(//mat-select//div[contains(@class,'mat-mdc-select-value')])[9]")
				.click();

		page.waitForTimeout(1000);

		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions()
						.setName("F2.Permit_Approved"))
				.locator("span")
				.click();

		page.waitForTimeout(2000);

		page.locator(
				"xpath=//label[contains(text(),'Sub Status')]/following::mat-select[1]")
				.click();

		page.waitForTimeout(2000);

		// Select value
		page.locator("mat-option")
				.filter(new Locator.FilterOptions()
						.setHasText("F2.1. Full Permit Received"))
				.click();

		page.waitForTimeout(1000);

		page.locator("input[name='amount']").fill("1234");

		page.waitForTimeout(1000);

		// Open Permit Challenges dropdown
		page.locator(
				"xpath=//label[contains(text(),'Permit Challenges')]/following::mat-select[1]")
				.click();

		page.waitForTimeout(1000);

		// Select dropdown value
		page.getByRole(AriaRole.OPTION,
				new Page.GetByRoleOptions()
						.setName("Corporate LL/LL/ BM/ JMB/ Gov"))
				.click();

		page.locator(".cdk-overlay-backdrop").click();

		page.waitForTimeout(1000);

		page.locator("input[type=\"date\"]")
				.first()
				.fill("2026-05-06");

		page.waitForTimeout(1000);

		page.locator("input[type=\"date\"]")
				.nth(1)
				.fill("2026-05-28");

		page.getByPlaceholder("Remarks").click();

		page.waitForTimeout(1000);

		page.getByPlaceholder("Remarks").fill("dfcgh");

		page.locator("textarea[name=\"remarks\"]").click();

		page.waitForTimeout(1000);

		page.locator("textarea[name=\"remarks\"]")
				.fill("dfghjk");

		page.waitForTimeout(1000);

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Add Status"))
				.click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		page.waitForTimeout(1000);

		page.getByLabel("SubmitApprove").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("now in permit submitted stage");

		closeBrowser();
	}
}