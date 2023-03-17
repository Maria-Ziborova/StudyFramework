package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDeleleIssuesTests extends BaseTest{

    private MantisSite mantisSite;

    @Test
    public void createIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        Thread.sleep(3000);

        String reportIssueTitle = mantisSite.getReportIssuePage().issueDetailTitle();
        Assertions.assertEquals("Enter Issue Details", reportIssueTitle);
        mantisSite.getReportIssuePage().reportIssue();

    }

    @Test
    public void deleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuesPage();

        Thread.sleep(3000);

        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();
        Assertions.assertEquals(50, actualIssuesNumber);
        mantisSite.getReportIssuePage().deleteIssue();

    }

    @Test
    public void createDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        Thread.sleep(3000);

        String reportIssueTitle = mantisSite.getReportIssuePage().issueDetailTitle();
        Assertions.assertEquals("Enter Issue Details", reportIssueTitle);
        mantisSite.getReportIssuePage().reportIssue();
        mantisSite.getMainPage().goToViewIssuesPage();

        Thread.sleep(3000);

        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();
        Assertions.assertEquals(50, actualIssuesNumber);
        mantisSite.getReportIssuePage().deleteIssue();
    }

    @Test
    public void createDeleteIssueWithSoft() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();

        Thread.sleep(3000);

        String reportIssueTitle = mantisSite.getReportIssuePage().issueDetailTitle();

        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(mantisSite.getReportIssuePage().isEnterIssueDetailsDisplayed()).isEqualTo(true);
        softAssert.assertThat(reportIssueTitle).isEqualTo("Enter Issue Details");

        softAssert.assertAll();

        mantisSite.getReportIssuePage().reportIssue();
        mantisSite.getMainPage().goToViewIssuesPage();

        Thread.sleep(3000);

        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();
        Assertions.assertEquals(50, actualIssuesNumber);
        mantisSite.getReportIssuePage().deleteIssue();
    }
}
