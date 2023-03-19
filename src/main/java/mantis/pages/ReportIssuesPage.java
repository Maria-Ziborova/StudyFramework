package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ReportIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summary;

    @FindBy(css = "#description")
    private WebElement description;

    @FindBy(css = "[type='submit']")
    private WebElement submitIssue;

    @FindBy(css = "[value='Delete']")
    private WebElement delete;

    @FindBy(css = "[value='Delete Issues']")
    private WebElement deleteIssues;

    @FindBy(xpath = "(//*[@class='column-id'])[2]")
    private WebElement newIssue;

    @FindBy(xpath = "(//*[@class='column-summary'])[2]")
    private WebElement newIssueSummary;

    @FindBy(xpath = "//*[@class='widget-header widget-header-small']")
    private WebElement enterIssueDetails;

    public ReportIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }
    public boolean isEnterIssueDetailsDisplayed() {return enterIssueDetails.isDisplayed();}

    public String issueDetailTitle() {return enterIssueDetails.getText();}

    public String newIssueSummaryName() {return newIssueSummary.getText();}

    public void reportIssue(){
        driver.get("https://academ-it.ru/mantisbt/bug_report_page.php");

        summary.sendKeys("summary1903");
        description.sendKeys("description");
        submitIssue.click();
    }

    public void deleteLastCreatedIssue() throws InterruptedException {
        driver.get("https://academ-it.ru/mantisbt/view_all_bug_page.php");

        newIssue.click();
        Thread.sleep(3000);
        delete.click();
        Thread.sleep(3000);
        deleteIssues.click();
    }
}
