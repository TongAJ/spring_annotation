package spring_annotation.test;


public class AnnotationExtTest {
    /**
     * Get IOC use AnnotationConfigApplicationContext

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);

    @Test
    public void testExt(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("name = " + name);
        }

        context.publishEvent(new ApplicationEvent(new String("publishEvent")) {
        });
    }
     */

}
