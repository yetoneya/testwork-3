package ru.elena.zh.passwords.service;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.elena.zh.passwords.base.Password;
import static ru.elena.zh.passwords.service.TestData.getList1;
import static ru.elena.zh.passwords.service.TestData.getList12;
import static ru.elena.zh.passwords.service.TestData.getList13;
import static ru.elena.zh.passwords.service.TestData.getList2;
import static ru.elena.zh.passwords.service.TestData.getList3;

public class PasswordDiscardTest {

    public PasswordDiscardTest() {
    }

    @Test
    public void testDiscard() {
        PasswordDiscard pd = new PasswordDiscard();
        List<Password> list = pd.discard(getList1(), getList2());
        assertEquals(list, getList12());

        list = pd.discard(getList2(), getList1());
        assertEquals(list, getList12());
               
        list = pd.discard(getList1(), getList3());
        assertEquals(list,getList13() );
        
        list = pd.discard(getList3(), getList1());
        assertEquals(list, getList13());
    }

}
