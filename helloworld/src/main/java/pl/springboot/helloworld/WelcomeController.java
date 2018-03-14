package pl.springboot.helloworld;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private DayOfYear dayOfYear = new DayOfYear();
	private LocalDate date = LocalDate.now();
	private final String[] list = {"Spring Boot", "Thymeleaf", "Maven", "HTML (with canvas)", "CSS", "JavaScript", "Bootstrap"};
	// inject via application.properties
	//@Value("${welcome.message:test}")
	private final String message = "Hello World";
	
	private DayOfYear getInformationAboutDayOfYear(){
		
		dayOfYear.setDay(date.getDayOfMonth());
		char number = Integer.toString(dayOfYear.getDay()).charAt(Integer.toString(dayOfYear.getDay()).length()-1);
		switch(number){
			case '1':
				dayOfYear.setOrdinalNumberSuffix("st");
				break;
			case '2':
				dayOfYear.setOrdinalNumberSuffix("nd");
				break;
			case '3':
				dayOfYear.setOrdinalNumberSuffix("rd");
				break;
			default:
				dayOfYear.setOrdinalNumberSuffix("th");
		}
		dayOfYear.setMonth(date.getMonth().toString().replace(date.getMonth().toString().substring(1), date.getMonth().toString().substring(1).toLowerCase()));
		dayOfYear.setYear(date.getYear());
		dayOfYear.setNumberDayOfYear(date.getDayOfYear());
		dayOfYear.setNumberOfDaysToTheEndOfYear(date.lengthOfYear() - date.getDayOfYear());
		dayOfYear.setDayName(date.getDayOfWeek().toString());
		
		return dayOfYear;
	}
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		
		dayOfYear = this.getInformationAboutDayOfYear();
		model.put("dayOfYear", this.dayOfYear);
		
		return "welcome";
	}
	
	@ModelAttribute("message")
	public void msg(Map<String, Object> model){
		model.put("message", this.message);
	}
	
	@RequestMapping("/about")
	public String technologies(Map<String, Object> model) {
		
		model.put("technologies", this.list);
		
		return "technologies";
	}
}
