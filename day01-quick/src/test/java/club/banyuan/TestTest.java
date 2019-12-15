package club.banyuan;

import static org.junit.Assert.*;

/**
 * @author 陈浩
 * @date Created on 2019/12/2
 */
public class TestTest {
    @org.junit.Test
    public  void a(){
        club.banyuan.Test a=new club.banyuan.Test();
        assertEquals(3,a.max(1,3));
    }
}