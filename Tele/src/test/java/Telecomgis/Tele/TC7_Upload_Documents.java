package Telecomgis.Tele;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TC7_Upload_Documents extends PlaywrightFactory {

    public static void main(String[] args) {
        Page page = null;
        try {
            page = startBrowser();

            LoginHelper.login(page, "DynamicUser", "DynamicUser");
            NavigationHelper.openManageWorkOrders(page);

            page.locator("#workorder_list").getByPlaceholder("Search").click();
            page.locator("#workorder_list").getByPlaceholder("Search").fill("923");
            page.locator("#workorder_list").getByPlaceholder("Search").press("Enter");

            page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(" Show Details"))
                    .locator("a").first().click();

            page.getByText("Documents").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Document")).click();
            page.getByLabel("Upload Document").locator("svg").click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Upload Tp")).click();
            page.getByLabel("Upload Document").getByText("…").click();

            page.getByLabel("Upload Document").locator("input[name='file']")
                    .setInputFiles(Paths.get("D:/eclipse-workspace/Tele/src/test/resources/OSSMS_SAP API_Specification_v5.3.15.docx"));

            page.getByLabel("Upload Document")
                    .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Upload Document"))
                    .click();

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
            page.getByLabel("SubmitApprove").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();

            System.out.println("now in Survey Submitted stage");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}