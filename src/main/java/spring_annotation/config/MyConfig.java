package spring_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring_annotation.bean.Blue;
import spring_annotation.bean.MyImportBeanDefinitionRegistrar;
import spring_annotation.bean.MyImportSelector;
import spring_annotation.bean.Person;
import spring_annotation.bean.Red;

@Configuration
//scan all AnnotationClass in specify package
/*@ComponentScan
(
		basePackages="spring_annotation",
		excludeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
		includeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Service.class}),
		useDefaultFilters=false
)*/

@ComponentScans
(
		{
			@ComponentScan
			(
					basePackages="spring_annotation",
					excludeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
					includeFilters=@Filter(type=FilterType.ANNOTATION,classes= {Service.class}),
					useDefaultFilters=false
			)
		}
)

//{@link Configuration}, {@link ImportSelector}, {@link ImportBeanDefinitionRegistrar}
@Import({Red.class,Blue.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {
	
	/**
	 * Scope:
	 *		singleton(default)--init IOC--create Bean
	 * 		prototyoe--init IOC--do not create Bean;When Bean used;init New one;
	 * 
	 * Lazy
	 * 		Only to singleton--do not create Bean;When Bean used;init Bean;
	 * @return
	 */
	@Lazy
//	@Scope("prototype")
	@Bean
	public Person person() {
		System.out.println("init person...");
		return new Person("AJ",28);
	}

}
