package cainiaojava.modifiers;

public class modifier {
    // This is a static keyword to create class variable
    private static int numInstances = 0;
    
    protected static int getCount() {
        return numInstances;
    }
    
    private static void addInstance() {
        numInstances++;
    }
    
    modifier() {
        modifier.addInstance();
    }
    
    public static void main(String[] arguments) {
        System.out.println("Starting with " +
        modifier.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
            new modifier();
            }
        System.out.println("Created " +
        modifier.getCount() + " instances");
    }
    
    
}
