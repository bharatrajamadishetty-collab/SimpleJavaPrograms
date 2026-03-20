import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

class SingletonStrict implements Cloneable, Serializable {

    private static final long serialVersionUID = -5664124213376258176L;

    private static volatile SingletonStrict singleInstance;

    //prevent instantiation via reflection
    private SingletonStrict() {
        if(singleInstance != null) {
            throw new IllegalStateException("Use getInstance() method to create/get instance");
        }
    }

    public static synchronized SingletonStrict getInstance() {
        if (singleInstance == null) {
            singleInstance = new SingletonStrict();
        }
        return singleInstance;
    }

    //prevent cloning
    @Override 
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        throw new CloneNotSupportedException("Cloning of this singleton is not allowed");
    }

    //prevent serialization/deserialization
    protected Object readResolve() {
        return getInstance();
    }
}

class TestSingletonStrict {
    public static void main(String[] args) {
        //Attempt to create multiple instances via getInstance()
        SingletonStrict instance1 = SingletonStrict.getInstance();
        SingletonStrict instance2 = SingletonStrict.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        // Attempt to create instance via reflection
        try {
           java.lang.reflect.Constructor<?> ctor = Class.forName("SingletonStrict").getDeclaredConstructor();
           ctor.setAccessible(true);
           Object v = ctor.newInstance();
            System.out.println(v);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Attempt to clone the singleton instance
        try {
            SingletonStrict clonedInstance = (SingletonStrict) instance1.clone();
            System.out.println(clonedInstance);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        // Attempt to deserialize the singleton instance
        Object o = instance2.readResolve();
        System.out.println(o);
        
    }
}
