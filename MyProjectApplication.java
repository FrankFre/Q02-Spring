package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Controller
@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	// doctor-Pfad mit Routing entsprechend des aufgerufenen Paranmeters
	@RequestMapping("/doctor/{incarnationNumber}")
	@ResponseBody


	String getQuestion(@PathVariable int incarnationNumber) {

		String outputString = "";

	

	if (incarnationNumber > 0 && incarnationNumber < 9)   {

//		Exception als Fehlermeldung error 303
		throw new ResponseStatusException(HttpStatus.SEE_OTHER, "No information available about that incarnation " + incarnationNumber + ".");



		}  else if (incarnationNumber <= 0 || incarnationNumber > 13) {

//		Exception als Fehlermeldung Error 404
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + incarnationNumber + ".");

		} else   {

			switch(incarnationNumber)   {

				case 9:
					outputString = "{\"number\": " + incarnationNumber + ", \"name\": \" Christopher Eccleston\"}";
					break;
					 
	
				case 10:
					outputString = "{\"number\": " + incarnationNumber + ", \"name\": \" David Tennant\"}";
					break;
				
		
				case 11:
					outputString = "{\"number\": " + incarnationNumber + ", \"name\": \" Matt Smith\"}";
					break;
					
		
				case 12:
					outputString = "{\"number\": " + incarnationNumber + ", \"name\": \" Peter Capaldi\"}";
					break;
					 
		
				case 13:
					outputString = "{\"number\": " + incarnationNumber + ", \"name\": \" Jodie Wittaker\"}";
					break;
				   
				}
		}
		return outputString;

	}

}
