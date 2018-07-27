package spring_annotation.bean;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata:	annotation information
	 * BeanDefinitionRegistry:	Registry of BeanDefinition
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		if(registry.containsBeanDefinition("spring_annotation.bean.Green")&&
			registry.containsBeanDefinition("spring_annotation.bean.Yellow")) {
			/**
			 * Register a new bean definition with this registry.
			 * Must support RootBeanDefinition and ChildBeanDefinition.
			 * @param beanName the name of the bean instance to register
			 * @param beanDefinition definition of the bean instance to register
			 * @throws BeanDefinitionStoreException if the BeanDefinition is invalid
			 * or if there is already a BeanDefinition for the specified bean name
			 * (and we are not allowed to override it)
			 * @see RootBeanDefinition
			 * @see ChildBeanDefinition
			 */
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
			registry.registerBeanDefinition("Rainbow", rootBeanDefinition);
		}
	}

}
