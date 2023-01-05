package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

  public class C01_ElvedaMainMethod {
    @Test
    public void test01(){
        // @Test notasyonu sayesinde her bir test medhod'u bagımsız olarak çalışabilir
// Eger testin içerisinde bir assertion yoksa kod problem yaşanmadan çalışıp bittiğinde
//JUnit test passed olarak raporlar
        System.out.println("test01 calıştı");
    }
    @Test @Ignore
    public void test02(){
        //@Ignore yazıldıgında test methodunun çalıştırılmamasını sağlar
        System.out.println("test02 calıştı");
    }
    @Test
    public void test03(){
        System.out.println("test03 calıştı");
    }

}
