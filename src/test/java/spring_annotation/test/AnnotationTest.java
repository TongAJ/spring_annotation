package spring_annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import spring_annotation.bean.Blue;
import spring_annotation.bean.MyImportBeanDefinitionRegistrar;
import spring_annotation.bean.MyImportSelector;
import spring_annotation.bean.Person;
import spring_annotation.bean.Red;
import spring_annotation.config.MyConfig;

public class AnnotationTest {
	/**
	 * Get IOC use AnnotationConfigApplicationContext
		ConfigClass:MyConfig
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	
	/**
	 * Get All Bean in IOC
	 */
	public void getBeanNames(AnnotationConfigApplicationContext context) {
		String[] names = context.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
		}
	}
	
	/**
	 * Get All Bean in IOC
	 */
	@Test
	public void testGetBeanNames() {
		getBeanNames(context);
	}
	
	/**
	 * @Bean public Person person() {}
	 */
	@Test
	public void testGetPerson() {
		Person person = context.getBean(Person.class);
		System.out.println(person);
	}
	
	/**
	 * @Scope("singleton") Person person(){}
	 */
	@Test
	public void testScopeSingleton() {
		Person person1 = context.getBean(Person.class);
		Person person2 = context.getBean(Person.class);
		System.out.println(person1==person2);
	}
	
	/**
	 * @Scope("prototype") Person person(){}
	 */
	@Test
	public void testScopePrototype() {
		Person person1 = context.getBean(Person.class);
		Person person2 = context.getBean(Person.class);
		System.out.println(person1==person2);
	}
	
	/**
	 * @Lazy Person person(){}
	 */
	@Test
	public void testLazy() {
		getBeanNames(context);
		// No System.out.println("init person...");
		// When perosn used,

		Person person1 = context.getBean(Person.class);
		// System.out.println("init person...");
	}

	
	/**
	 *	@ComponentScan(basePackages="spring_annotation")
	 */
	@Test
	public void testComponentSacn() {
		getBeanNames(context);
	}
	
	/**
	 *	exclude AnnotationClass @Controller
		excludeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}))
		without @Controller classes
	 */
	@Test
	public void testExcludeFilters() {
		getBeanNames(context);
	}
	
	/**
	 * includeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Service.class}),
		useDefaultFilters=false
		Only scan @Service classes
	 */
	@Test
	public void testIncludeFilters() {
		//without MyController
		getBeanNames(context);
	}
	
	
	/**
	 * @ComponentScans
		(
				{
					@ComponentScan
					(
							basePackages="spring_annotation",
							// exclude AnnotationClass @Controller
							excludeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
							includeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Service.class}),
							useDefaultFilters=false
					)
				}
		)
	 */
	@Test
	public void testComponentScans() {
		getBeanNames(context);
	}
	
	
	/**
	 * @Import({Red.class,Blue.class})
	 *	IOC import
	 * spring_annotation.bean.Red
		spring_annotation.bean.Blue
	 */
	@Test
	public void testImport() {
		getBeanNames(context);
	}
	
	/**
	 	@Import({Red.class,Blue.class,MyImportSelector.class})
	 	
		 public class MyImportSelector implements ImportSelector{
		 		public String[] selectImports(AnnotationMetadata importingClassMetadata) {
					// do not return null;
					return new String[] {"spring_annotation.bean.Green","spring_annotation.bean.Yellow"};
				}
		 }
	 */
	@Test
	public void testImportSelector() {
		getBeanNames(context);
	}
	
	/**
	 * @Import({Red.class,Blue.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
	 */
	@Test
	public void testImportBeanDefinitionRegistrar() {
		getBeanNames(context);
	}
}
