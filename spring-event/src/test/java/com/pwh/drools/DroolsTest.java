package com.pwh.drools;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

/**
 * @author panweihua450
 * @date 2021/6/3 21:54
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
class DroolsTest {
    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    // https://blog.csdn.net/tanglei6636/article/details/94845270
    @Test
    void test() {
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("all-rules");
        Person person = new Person();

        person.setAge(12);
        person.setName("Test");

        statefulKieSession.insert(person);
        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();
    }


    /**
     * 基于字符串
     *
     * @throws Exception
     */
    @Test
    public void ruleStringTest() throws Exception {

        String myRule = "import com.pwh.drools.Person\n" +
                "\n" +
                "dialect  \"mvel\"\n" +
                "\n" +
                "rule \"age\"\n" +
                "    when\n" +
                "        $person : Person(age<16 || age>50)\n" +
                "    then\n" +
                "        System.out.println(\"这个人的年龄不符合要求！（基于动态加载）\");\n" +
                "end\n";

        KieHelper helper = new KieHelper();

        helper.addContent(myRule, ResourceType.DRL);

        KieSession ksession = helper.build().newKieSession();

        Person person = new Person();

        person.setAge(12);
        person.setName("Test");

        ksession.insert(person);

        ksession.fireAllRules();

        ksession.dispose();
    }
}