package cainiaojava.modifiers;

public class AccessModifiers {
    private String format;   //private keyword, only in this class can access
    
    /**
     * public keyword, all can use this method
     * @return
     */
    public String getFormat() {
       return this.format;
    }
    public void setFormat(String format) {
       this.format = format;
    }

    /**
     * non-modifier --> default, only used in one package
     * can be writed "public static final"
     */
    String version = "1.5.1";
    boolean processOrder() {
        return true;
    }

    /**
     * protected can used in one package, but can not modify class and interface
     */
    protected int s;
    protected void method2(){
        // pass
    }
}