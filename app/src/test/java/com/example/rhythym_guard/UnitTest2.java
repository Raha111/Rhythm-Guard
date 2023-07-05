package com.example.rhythym_guard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTest2 {
    @Test
    public void testGetRecords() {
        userlist recordList = new userlist();

        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        recordList.add(mainModel);

        MainModel mainModel1=new MainModel("good","20-03-2023","90","60","80","5.10");
        recordList.add(mainModel1);

        assertEquals(0, mainModel.compareTo(recordList.getRecords().get(0)));
        assertEquals(0, mainModel1.compareTo(recordList.getRecords().get(1)));
    }

    @Test
    public void testAdd() {
        userlist recordList = new userlist();

        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        recordList.add(mainModel);

        MainModel mainModel1=new MainModel("bad","20-03-2023","90","60","80","5.10");
        recordList.add(mainModel1);

        assertEquals(2, recordList.getRecords().size());
        assertTrue(recordList.getRecords().contains(mainModel));
    }

    @Test
    public void testAddException() {
        userlist recordList = new userlist();

        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        recordList.add(mainModel);

        assertThrows(IllegalArgumentException.class, () -> {
            recordList.add(mainModel);
        });
    }

    @Test
    public void testDelete() {
        userlist recordList = new userlist();

        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        recordList.add(mainModel);

        MainModel mainModel1=new MainModel("bad","20-03-2023","90","60","80","5.10");
        recordList.add(mainModel1);

        recordList.delete(mainModel);

        assertEquals(1, recordList.getRecords().size());
        assertFalse(recordList.getRecords().contains(mainModel));
    }

    @Test
    public void testDeleteException() {
        userlist recordList = new userlist();

        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        recordList.add(mainModel);

        MainModel mainModel1=new MainModel("bad","20-03-2023","90","60","80","5.10");
        recordList.add(mainModel1);

        recordList.delete(mainModel);

        assertThrows(IllegalArgumentException.class, () -> {
            recordList.delete(mainModel);
        });
    }

    @Test
    public void testUpdate()
    {
        userlist recordList = new userlist();

        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        recordList.add(mainModel);

        MainModel mainModel1=new MainModel("bad","20-03-2023","90","60","80","5.10");
        recordList.update(0, mainModel1);

        assertFalse(recordList.getRecords().contains(mainModel));
        assertTrue(recordList.getRecords().contains(mainModel1));
}
}
