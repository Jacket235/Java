// Import necessary Selenium WebDriver classes
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CollectionAddingBot {
    public static void main(String[] args) throws IOException {

        String[] addonLinkID = {
                "104486597", "1071725769", "109643223", "1124162421", "112550250", "1126757551",
                "1223656163", "1236181176", "1243825019", "126181015", "131759821", "1337259088",
                "1355143637", "1361342565", "1394998020", "1422933575", "1434731894", "1440092149",
                "1505264612", "152529683", "157854748", "1627003529", "1632550882", "174117071",
                "1770130953", "1784911999", "1843708002", "1845496927", "1851774854", "1884113292",
                "1919689921", "1920810365", "1934526858", "1940264801", "1967495534", "1991247490",
                "2156475810", "2157865676", "2242232335", "2250272709", "2287585809", "2288784152",
                "2317008029", "237872885", "2393175267", "2441210098", "246756300", "2493325727",
                "253297309", "2607227837", "2618790436", "2663434661", "2665441198", "2670218225",
                "2713425690", "2744713103", "2762079932", "276601948", "2789956350", "2793580726",
                "2797155843", "2799307109", "2801746865", "2804625575", "2813197201", "2827004973",
                "2828445664", "2828445735", "2828448531", "2830488783", "2831900714", "2853207488",
                "2856382594", "2868204322", "2876082929", "2882416143", "2883967110", "2892187389",
                "2900454560", "2912816023", "2923828689", "2924927318", "2925579200", "2927204359",
                "2933388060", "2933410080", "2944078031", "2946627978", "2957362926", "2966226281",
                "2969969873", "3000521480", "3008842017", "3012412081", "3027255911", "3028261397",
                "3028266285", "3028343972", "3028542907", "3028543217", "3028582090", "3032299655",
                "3047221988", "3067524435", "3084293143", "3087887909", "3105637302", "3110060938",
                "3135034443", "3137204373", "3138984575", "3145211994", "3145834997", "3167885628",
                "3235598067", "3252138322", "3286923455", "3295357530", "3313894749", "3330547360",
                "3331444824", "3337147730", "3357289247", "3363517539", "3365018778", "449315743",
                "462170301", "465838706", "471518115", "609478456", "673698301", "681674225",
                "692342876", "696374067", "730187817", "764329142", "771487490", "827243834",
                "845068904", "973999028", "2823321919", "2103880801", "1873907782", "541552387",
                "2484790252", "2693995468", "2659980741", "265049021", "2475634549", "855745780",
                "2736711566", "415683233", "262374517", "214144067", "314994389", "104518391",
                "145316417", "153600777", "1198663315", "1860226716", "280833239",
                "2522244292", "2251357708", "2317008029", "2152474495", "2957550771", "2701275326",
                "2971753123", "2996666498", "2482351689", "1768545322", "1307357127", "1924330050",
                "2884139752", "3023164176", "2770880566", "2917343547", "2970916934", "2962050559"
        };
        // 2633506512

        String[] addonLink2IDs = { "2823321919", "2103880801", "1873907782", "541552387", "2484790252",
                "2693995468", "2659980741", "265049021", "2475634549", "855745780",
                "2736711566", "415683233", "262374517", "214144067", "314994389",
                "104518391", "145316417", "153600777", "1198663315", "1860226716",
                "280833239", "2522244292", "2251357708", "2317008029",
                "2152474495", "2957550771", "2701275326", "2971753123", "2996666498",
                "2482351689", "1768545322", "1307357127", "1924330050", "2884139752",
                "3023164176", "2770880566", "2917343547", "2970916934", "2962050559"
        };

        System.setProperty("webdriver.chrome.driver", "X:\\Pobrane z przeglądarki\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\root\\AppData\\Local\\Programs\\Opera\\opera.exe");  // Path to Opera browser

        WebDriver driver = new ChromeDriver(options);  // Using ChromeDriver to launch Opera
        driver.manage().window().maximize();

            driver.get("https://store.steampowered.com/login/");

            WebDriverWait waitForLoginPage = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Find the username input
            WebElement usernameField = waitForLoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='_2GBWeup5cttgbTw8FM3tfx'])[1]")));

            // Find the password input
            WebElement passwordField = waitForLoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='_2GBWeup5cttgbTw8FM3tfx'])[2]")));

            // You have to actually put in your real credentials here
            usernameField.sendKeys("username");
            passwordField.sendKeys("password");

            // Submit the form
            WebElement loginButton = driver.findElement(By.className("DjSvCZoKKfoNSmarsEcTS"));
            loginButton.click();

            // Approve Steam Guard
            System.out.println("Please confirm the login on Steam and press Enter once done.");
            System.in.read();  // Wait until user confirms the login
        
            for(int i = 0; i < addonLink2IDs.length; i++){
                driver.get("https://steamcommunity.com/sharedfiles/filedetails/?id=" + addonLink2IDs[i]);
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='67%';");

                WebDriverWait waitForCollections = new WebDriverWait(driver, Duration.ofSeconds(30));

                WebElement AddToCollectionBtn = waitForCollections.until(ExpectedConditions.visibilityOfElementLocated(By.id("AddToCollectionBtn")));
                AddToCollectionBtn.click();

                WebElement CollectionCheckBox = waitForCollections.until(ExpectedConditions.visibilityOfElementLocated(By.id("2322604591")));
                if (CollectionCheckBox.isSelected()) {
                    continue;
                } else {
                    CollectionCheckBox.click();
                    WebElement OkBtn = driver.findElement(By.className("btn_green_steamui"));
                    OkBtn.click();
                }
            }
    }
}
