package spring_annotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_annotation.config.MyConfigProfile;

import javax.sql.DataSource;

public class AnnotationProfileTest {
    /**
     * Get IOC use AnnotationConfigApplicationContext
     ConfigClass:MyConfig
     */
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigProfile.class);

    @Test
    public void getDataSources(){
        String[] definitionNames = context.getBeanNamesForType(DataSource.class);
        for (String name : definitionNames) {
            System.out.println("name = " + name);
        }
    }

    /**
     * @Profile
     *    1.不指定，没有任何dataSource被注入
     *    2.默认是@Profile("default")的会被注入
     */
    @Test
    public void getProfiledSources(){
        String[] definitionNames = context.getBeanNamesForType(DataSource.class);
        for (String name : definitionNames) {
            System.out.println("name = " + name);
        }
    }

    /**
     * public AnnotationConfigApplicationContext(Class... annotatedClasses) {
     *         this();
     *         this.register(annotatedClasses);
     *         this.refresh();
     *     }
     *
     *
     */
    @Test
    public void setProfileByJava(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // setActiveProfiles("test")
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test");
        annotationConfigApplicationContext.register(MyConfigProfile.class);
        annotationConfigApplicationContext.refresh();

        String[] definitionNames = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
        for (String name : definitionNames) {
            System.out.println("name = " + name);
        }
    }
}
