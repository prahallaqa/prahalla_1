package Telecomgis.Tele;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC13_PemitObtained_To_Initiate_CBYD extends PlaywrightFactory {

	@Test
	public void TC13() {

		Page page = startBrowser();

		// Login
		LoginHelper.login(page, "PMRollout", "PMRollout");

		// Navigate to Manage WorkOrders
		NavigationHelper.openManageWorkOrdersUsingNrmButton(page);

		page.getByRole(AriaRole.CELL,
				new Page.GetByRoleOptions().setName(" Show Details"))
				.locator("a")
				.first()
				.click();

		page.getByText("Workorder Info").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("PI Details"))
				.click();

		page.getByLabel("PI Details")
				.locator("path")
				.click();

		// page.getByRole(AriaRole.OPTION,
		// new Page.GetByRoleOptions().setName("PIROLLOUT"))
		// .locator("span").click();

		page.locator("mat-option")
				.filter(new Locator.FilterOptions().setHasText("PIROLLOUT"))
				.first()
				.click(new Locator.ClickOptions().setForce(true));

		page.getByLabel("SubmitApprove").click();

		page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Ok"))
				.click();

		System.out.println("now in Initiate CBYD stage");

		closeBrowser();
	}
}