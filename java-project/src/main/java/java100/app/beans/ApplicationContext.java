package java100.app.beans;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import java100.app.annotation.Component;

public class ApplicationContext {

    HashMap<String,Object> pool = new HashMap<>();

    public ApplicationContext() {}
    
    public ApplicationContext(String basePackage) {

        try {
            Reflections reflections = new Reflections(basePackage);
            
            Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Component.class);

            for(Class<?> clazz : classes) {
                
                System.out.println(clazz.getName());
                
                Component compAnno = clazz.getAnnotation(Component.class);
                if (compAnno == null) continue;

                Object obj = clazz.newInstance();
                
                if (compAnno.value().length() == 0) {
                    pool.put(clazz.getName(),obj);
                } else {
                    pool.put(compAnno.value(), obj);
                }
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
            // invoke() 메소드의 첫번째 파라미터는 메소드를 호출할 객체를 나타내며, 두번째 파라미터는 메소드를 호출할 때
            // 전달할 파라미터를 나타낸다.
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
