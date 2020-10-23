package guru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;	
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		//get a context manager
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
		
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		
													//bean to the object you want to get by context
													//is named like the class of that object but starting lowcase
		MyController myController = (MyController) ctx.getBean("myController");
		
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		
		System.out.println("---------Primary bean");
		System.out.println(myController.sayHello());
		
		System.out.println("---------Property");
		System.out.println(propertyInjectedController.getGreeting());
		
		System.out.println("---------Setter");
		System.out.println(setterInjectedController.getGreeting());		
		
		System.out.println("---------Constructor");
		System.out.println(constructorInjectedController.getGreeting());		
	}

}
