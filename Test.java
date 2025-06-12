package All_Websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();

	        try {
	            // 1. Open Homepage
	            driver.get("https://www.automationexercise.com/");
	            driver.manage().window().maximize();

	            // 2. Search for a product
	            driver.findElement(By.xpath("//a[text()=' Products']"));
	            Thread.sleep(3000);
	            WebElement searchBox = driver.findElement(By.id("search_product"));
	            Thread.sleep(3000);
	            searchBox.sendKeys("Dress");
	            Thread.sleep(3000);
	            driver.findElement(By.id("submit_search")).click();
	            Thread.sleep(3000);
	            // 3. Verify results appear
	            WebElement firstResult = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p"));
	            Thread.sleep(3000);
	            if (firstResult.isDisplayed()) {
	                System.out.println("✅ Search result displayed: " + firstResult.getText());
	                Thread.sleep(3000);
	            } else {
	                System.out.println("❌ No search results found.");
	                Thread.sleep(3000);
	            }

	            // 4. Add first product to cart
	            WebElement viewProduct = driver.findElement(By.xpath("//div[@class='productinfo text-center']/a"));
	            viewProduct.click();
	            Thread.sleep(3000);
	            WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
	            addToCartButton.click();
	            Thread.sleep(3000);
	            // 5. Click 'View Cart' in popup
	            WebElement viewCartLink = driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));
	            viewCartLink.click();
	            Thread.sleep(3000);
	            // 6. Assert product name and price in cart
	            WebElement cartProductName = driver.findElement(By.xpath("//a[contains(@href,'/product_details/')]"));
	            Thread.sleep(3000);
	            WebElement cartProductPrice = driver.findElement(By.xpath("//td[@class='cart_price']/p"));
	            Thread.sleep(3000);
	            if (cartProductName.isDisplayed() && cartProductPrice.isDisplayed()) {
	                System.out.println("✅ Cart Product: " + cartProductName.getText());
	                Thread.sleep(3000);
	                System.out.println("✅ Cart Price: " + cartProductPrice.getText());
	                Thread.sleep(3000);
	            } else {
	                System.out.println("❌ Cart does not contain expected product.");
	                Thread.sleep(3000);
	            }

	        } catch (Exception e) {
	            System.out.println("❌ Test failed: " + e.getMessage());
	            Thread.sleep(3000);
	        } finally {
	            // Close browser
	            driver.quit();
	        }
	    }
	}

	


