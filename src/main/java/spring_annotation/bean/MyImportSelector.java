package spring_annotation.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector{

	/**
	 * AnnotationMetadata:annotation information
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// do not return null;
		return new String[] {"spring_annotation.bean.Green","spring_annotation.bean.Yellow"};
	}

}
