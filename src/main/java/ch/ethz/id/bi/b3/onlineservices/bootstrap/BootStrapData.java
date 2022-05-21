package ch.ethz.id.bi.b3.onlineservices.bootstrap;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ch.ethz.id.bi.b3.onlineservices.domain.InputElement;
import ch.ethz.id.bi.b3.onlineservices.domain.Page;
import ch.ethz.id.bi.b3.onlineservices.repositories.InputElementRepository;
import ch.ethz.id.bi.b3.onlineservices.repositories.PageRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final InputElementRepository inputElementRepository;
	private final PageRepository pageRepository;

	public BootStrapData(InputElementRepository inputElementRepository, PageRepository pageRepository) {
		super();
		this.inputElementRepository = inputElementRepository;
		this.pageRepository = pageRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Page registrationPage = new Page("registrationPage", "User registration page");
		Page loginPage = new Page("loginPage", "Login page");
		InputElement firstName = new InputElement("First Name", "Please enter your first Name", "Text");
		InputElement lastName = new InputElement("Last Name", "Please enter your last Name", "Text");
		InputElement city = new InputElement("City", "Please choose City Name", "DropDown");
		InputElement username = new InputElement("Username", "Please enter your username", "Text");
		InputElement password = new InputElement("Password", "Please enter your password", "Text");
		
		Collection<InputElement> inputElementsRegistrationPage = new ArrayList<InputElement>();
		inputElementsRegistrationPage.add(firstName);
		inputElementsRegistrationPage.add(lastName);
		inputElementsRegistrationPage.add(city);
		
		Collection<InputElement> inputElementsLoginPage = new ArrayList<InputElement>();
		inputElementsLoginPage.add(username);
		inputElementsLoginPage.add(password);
		
		registrationPage.getInputElements().addAll(inputElementsRegistrationPage);
		loginPage.getInputElements().addAll(inputElementsLoginPage);
		
		inputElementRepository.saveAll(inputElementsRegistrationPage);
		inputElementRepository.saveAll(inputElementsLoginPage);
		pageRepository.save(registrationPage);
		pageRepository.save(loginPage);
		
		System.out.println("Number of Input Elements: " + inputElementRepository.count());
		System.out.println("Number of Pages: " + pageRepository.count());
	}

}
