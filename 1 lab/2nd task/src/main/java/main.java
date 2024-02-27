import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class main {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuora\\Desktop\\PST\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// 1. Atsidaryti tinklalapį https://demowebshop.tricentis.com/
		driver.get("https://demowebshop.tricentis.com/");
		
		// 2. Spausti 'Gift Cards' kairiajame meniu
		driver.findElement(By.xpath("//div[@class='leftside-3']//a[contains(., 'Gift Cards')]")).click();
		
		// 3. Pasirinkti prekės, kurios kaina didensė nei 99 nuorodą. Reikia 'neįhardcodinti' pasirenkamos prekės, 
        //nes prekių kaina gali keistis ateityje
        driver.findElement(By.xpath("//div[@class='product-item' and .//span[@class='price actual-price' and normalize-space() > '99']]//h2[@class='product-title']/a")).click();      
        
        // 4. Supildyti laukus 'Recipient's Name:', 'Your Name:' savo nuožiūra
		 WebElement RecipientName = driver.findElement(By.className("recipient-name"));
		 RecipientName.sendKeys("Jonas");
		 
		 WebElement YourName = driver.findElement(By.className("sender-name")); 
		 YourName.sendKeys("Pranas");
		 
		// 5. Į tekstinį lauką 'Qty' įvesti '5000'
		 WebElement Qty = driver.findElement(By.className("qty-input"));
		 Qty.clear();
		 Qty.sendKeys("5000");
		 
		// 6. Spausti 'Add to cart' mygtuką
		 driver.findElement(By.className("add-to-cart-button")).click();
		 Thread.sleep(2000);
		 		 
		// 7. Spausti 'Add to wish list' mygtuką
		 driver.findElement(By.className("add-to-wishlist-button")).click();
		 Thread.sleep(4000);
		 	 
		// 8. Spausti 'Jewelry' kairiajame meniu.
		driver.findElement(By.linkText("Jewelry")).click();
		
		// 9. Spausti 'Create Your Own Jewelry' nuorodą.
		driver.findElement(By.linkText("Create Your Own Jewelry")).click();
				
		// 10. Pasirinkti reikšmes: 'Material' - 'Silver 1mm', 'Length in cm' - '80', 'Pendant' - 'Star'
		Select SelectionOption = new Select(driver.findElement(By.name("product_attribute_71_9_15")));
		SelectionOption.selectByVisibleText("Silver (1 mm)");
		
		WebElement LengthInCm = driver.findElement(By.name("product_attribute_71_10_16"));
		LengthInCm.sendKeys("80");
		
		driver.findElement(By.id("product_attribute_71_11_17_50")).click();
		
		// 11. Į tekstinį lauką 'Qty' įvesti '26'
		WebElement Qty2 = driver.findElement(By.className("qty-input"));
		 Qty2.clear();
		 Qty2.sendKeys("26");
		 
		// 12. Spausti 'Add to cart' mygtuką
		 driver.findElement(By.className("add-to-cart-button")).click();
		 Thread.sleep(2000);
		 
		// 13. Spausti 'Add to wish list' mygtuką
		 driver.findElement(By.className("add-to-wishlist-button")).click();
		 Thread.sleep(4000);
		 
		// 14. Spausti nuorodą 'Wishlist' puslapio viršuje
		 driver.findElement(By.className("ico-wishlist")).click();
		 
		// 15. Abejom prekėm paspausti 'Add to cart' varneles
		/*
		 * driver.findElements(By.xpath(
		 * "//td[@class='add-to-cart']//input[@type='checkbox']")).forEach(el ->{
		 * el.click() });
		 */
		 driver.findElement(By.xpath("//tr[@class='cart-item-row'][1]//td[@class='add-to-cart']//input[@type='checkbox']")).click();
		 driver.findElement(By.xpath("//tr[@class='cart-item-row'][2]//td[@class='add-to-cart']//input[@type='checkbox']")).click();
		 
		// 16. Spausti 'Add to cart' mygtuką
		 driver.findElement(By.name("addtocartbutton")).click();
		 
		// 17. Atsiradus Shopping cart puslapyje patvirtinti, kad 'Sub-Total' reikšmė yra '1002600.00'
		 WebElement subtotalElement = driver.findElement(By.xpath("//span[@class='product-price']"));
		 String subtotalValue = subtotalElement.getText();
		 
		 if ("1002600.00".equals(subtotalValue)) {
	            System.out.println("Sub-Total value matches the expected value.");
	        } else {
	            System.out.println("Sub-Total value does not match the expected value.");
	        }
		 
		driver.close();
	}
}
