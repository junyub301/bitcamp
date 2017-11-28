package java100.app.beans;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class ApplicationContext {

    HashMap<String,Object> pool = new HashMap<>();

    public ApplicationContext() {}

    public ApplicationContext(String propsPath) {

        // 프로퍼티 파일은 일련의 키-값의 쌍들로 이루어지며 파일에 저장된다
        Properties props = new Properties();
        
        try(FileReader in = new FileReader(propsPath)) {
            props.load(in);

            Set<Object> keySet = props.keySet(); //keySet() : key를 다 가지고온다.
            for (Object key : keySet) {
                
                String name = (String)key;
                Class<?> clazz = Class.forName(props.getProperty(name)); //getProperty : key가 가르키는 값을 출력
                Object obj = clazz.newInstance();
                pool.put(name, obj);
            }
            
            injectDependency();
        } catch (Exception e) {
            throw new BeansException("프로퍼티 파일 로딩 중 오류 발생!");    
        }

    }

    public Object getBean(String name) {
        Object bean = pool.get(name);
        if (bean == null)
            throw new BeansException("빈을 찾을 수 없습니다.");
        return bean;
    }

    public void addBean(String name, Object bean) {
        pool.put(name,bean);
    }

    public String[] getBeanDeinitionNames() {
        Set<String> keySet = pool.keySet();
        String[] names = new String[keySet.size()];

        keySet.toArray(names);

        return names;
    }

    void injectDependency() {

        Collection<Object> objs = pool.values();
        for (Object obj : objs) {
            invokeSetter(obj);
        }
    }

    // 한 객체의 셋터를 찾아 호출한다.
    private void invokeSetter(Object obj) {

        // 해당 객체에 선언된 모든 메서드 목록을 꺼낸다.
        Method[] methods = obj.getClass().getDeclaredMethods();

        // 목록에서 셋터를 찾아 호출한다.
        for (Method m : methods) {
            // System.out.println("=>" + m.getName());

            if (!m.getName().startsWith("set")) 
                continue;

            // 셋터가 원하는 타입의 객체가 pool에 들어 있는지 찾아본다.
            Object dependency = findObject(getFirstParameterType(m));
            if (dependency == null) continue;
            

            // 셋터가 원하는 타입의 객체를 찾았으면, 셋터를 호출하여 그 객체를 주입한다.
            //invoke() 메소드의 첫번째 파라미터는 메소드를 호출할 객체를 나타내며, 두번째 파라미터는 메소드를 호출할 때 전달할 파라미터를 나타낸다.
            try {
                m.invoke(obj, dependency);
                  // System.out.printf("%s().%s) 호출됨!\n", obj.getClass().getName(),
                  //      m.getName());
            } catch (Exception e) {
                throw new BeansException(obj.getClass().getName() + "클래스의" + 
                        m.getName() + "메서드 호출 오류!");
            }
        }

    }

    // 셋터가 파라미터로 원하는 타입이 뭔지 알아낸다.
    private Class<?> getFirstParameterType(Method m){
        return m.getParameterTypes()[0];
    }

    // 주어진 타입의 객체가 pool에 있는지 찾는다.
    private Object findObject(Class<?> type) {

        Collection<Object> objs = pool.values();

        for (Object obj : objs) {
            if (type.isInstance(obj)) 
                return obj;
        }

        return null;
    }
    
    // 빈 컨테이너에 객체가 추가되거나 제거되었을 때 의존 객체 주입을 다시해야 한다.
    public void refreshBeanFactory() {
        injectDependency();
    }
}
