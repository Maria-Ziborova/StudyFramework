package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDeleleIssuesTests extends BaseTest {

    private MantisSite mantisSite;

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

        mantisSite.getReportIssuePage().reportIssue();
        mantisSite.getMainPage().goToViewIssuesPage();

        Thread.sleep(3000);

        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();

        softAssert.assertThat(actualIssuesNumber).isEqualTo(50);
        mantisSite.getReportIssuePage().deleteLastCreatedIssue();
        String newIssueSummaryNameText = mantisSite.getReportIssuePage().newIssueSummaryName();
        softAssert.assertThat(newIssueSummaryNameText).isNotEqualTo("summary1903");

        softAssert.assertAll();
    }
}
