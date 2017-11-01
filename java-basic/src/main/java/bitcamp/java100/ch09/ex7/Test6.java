package bitcamp.java100.ch09.ex7;

import java.util.HashSet;

public class Test6 {

    static class Contact {
        String name;
        String email;
        String tel;

        public Contact(String name, String email, String tel) {
            this.name = name;
            this.email = email;
            this.tel = tel;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((tel == null) ? 0 : tel.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Contact other = (Contact) obj;
            if (email == null) {
                if (other.email != null)
                    return false;
            } else if (!email.equals(other.email))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (tel == null) {
                if (other.tel != null)
                    return false;
            } else if (!tel.equals(other.tel))
                return false;
            return true;
        }
        
        
    }
    public static void main(String[] args) {

        HashSet<Contact> set = new HashSet<>();

        Contact c1 = new Contact("홍길동", "hoang@test.com", "1111-1111");
        Contact c2 = new Contact("홍길동", "hoang@test.com", "1111-1111");
        Contact c3 = new Contact("홍길동", "hoang@test.com", "1111-1111");

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));


        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set.size());

        Contact[] arr = new Contact[set.size()];
        set.toArray(arr);

        for (Contact c : arr)
            System.out.printf("%s %s %s\n", c.name, c.email, c.tel);

        
    }

}
