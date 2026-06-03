package stepDefinations;

import com.pages.buttontest;
import com.pages.elementsPage;
import com.pages.homePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.testBaseClass;

public class buttonTest extends testBaseClass{

	@Given("user is on button page")
	public void user_is_on_button_page() {
	  beforeClass();  
	  homePage hp=  new homePage(driver);
	  hp.clickonElements();
	  
	  
	 
	}

	@When("User click on double click button")
	public void user_click_on_double_click_button() {
		elementsPage el= new elementsPage(driver);
		  el.buttonClick();
		  
		 
	}

	@Then("user able to see message")
	public void user_able_to_see_message() {
		
		buttontest bt= new buttontest(driver);
		  String text= bt.doubleClickTest();
		  System.out.println(text);
	}


}
