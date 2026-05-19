package StepsForBackground;

import io.cucumber.java.en.*;

//clase para los pasos del background demo
public class BackgroundDemoSteps {
	
	//Background
	@Given("user is on login page")
	public void user_is_on_login_page() {
	}
	@When("user enters username and password")
	public void user_enters_username_and_password() {
	}
	@When("click on login button")
	public void click_on_login_button() {
	}
	@Then("user is navigatedto the home page")
	public void user_is_navigatedto_the_home_page() {
	}

	//Dado que el usuario está logueado
	@Given("user is logged in")
	//Metodo vacio para el usuario está logueado
	public void user_is_logged_in() {
	    // Imprimimos mensaje en consola
	    System.out.println("Inside Step - user is logged in");
	}
	@When("user clicks on logout link")
	public void user_clicks_on_logout_link() {
		System.out.println("Inside Step -user clicks on logout link");
	}
	@Then("logout text is displayed")
	public void logout_text_is_displayed() {
		System.out.println("Inside Step -user clicks on logout link");
	}

	@When("user clicks on courses link")
	public void user_clicks_on_courses_link() {
	}
	@Then("courses text is displayed")
	public void courses_text_is_displayed() {
	}
}
