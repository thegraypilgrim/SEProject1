import org.junit.Test;

import static org.junit.Assert.*;

public class H1Test2 {

    @Test
    public void nextWithNextBeingNull() {
        H1 a = new H1(3);
        assertEquals(a.next(), null);
    }

    @Test
    public void nextWithNextBeingANumber() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        a.setNext(b);
        assertEquals(a.next(), b);
    }

    @Test
    public void lastWithOneItem() {
        H1 a = new H1(3);
        assertEquals(a.last(), a);
    }

    @Test
    public void lastWithTwoItem() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        a.setNext(b);
        assertEquals(a.last(), b);
    }

    @Test
    public void lastWithThreeItem() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        H1 c = new H1(9);
        a.setNext(b);
        b.setNext(c);
        assertEquals(a.last(), c);
    }
    @Test
    public void afterWithNBeing0() {
        H1 a = new H1(3);
        assertEquals(a.after(0), a);
    }

    @Test
    public void afterWithNBeing0WithTwoItems() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        a.setNext(b);
        assertEquals(a.after(0), a);
    }

    @Test
    public void afterWithNBeing1WithTwoItems() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        a.setNext(b);
        assertEquals(a.after(1), b);
    }

    @Test
    public void afterWithNBeing1WithThreeItems() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        a.setNext(b);
        H1 c = new H1(9);
        b.setNext(c);
        assertEquals(a.after(1), b);
    }

    @Test
    public void afterWithNBeing2WithThreeItems() {
        H1 a = new H1(3);
        H1 b = new H1(7);
        a.setNext(b);
        H1 c = new H1(9);
        b.setNext(c);
        assertEquals(a.after(2), c);
    }

    @Test
    public void afterWithANullPointer(){
        try{
            H1 a = new H1(4);
            a.after(4);
            assertEquals(true, false);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Is longer then Length");
        }
    }

    @Test
    public void detachWithOneItems() {
        H1 a = new H1(3);
        a.detach();
        assertEquals(a.next(), null);
    }

    @Test
    public void detachWithTwoItems() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        a.setNext(b);
        assertEquals(a.next(), b);
        a.detach();
        assertEquals(a.next(), null);
    }

    @Test
    public void detachWithThreeItemsAndRemovedTheSecond() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(7);
        a.setNext(b);
        b.setNext(c);
        a.detach();
        assertEquals(a.next(), null);
        assertEquals(b.next(), c);
    }

    @Test
    public void detachWithThreeItemsAndRemovedTheLast() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(7);
        a.setNext(b);
        b.setNext(c);
        b.detach();
        assertEquals(a.next(), b);
        assertEquals(b.next(), null);
    }

    @Test
    public void get() {
        H1 a = new H1(3);
        assertEquals(a.get(), (Integer) 3);
    }

    @Test
    public void get2() {
        H1 a = new H1(5);
        assertEquals(a.get(), (Integer) 5);
    }

    @Test
    public void getSecondItem() {
        H1 a = new H1(5);
        H1 b = new H1(9);
        a.setNext(b);
        assertEquals(a.next().get(), (Integer) 9);
    }

    @Test
    public void getFirstWithTwoItems() {
        H1 a = new H1(5);
        H1 b = new H1(9);
        a.setNext(b);
        assertEquals(a.get(), (Integer) 5);
    }

    @Test
    public void set() {
        H1 a = new H1(3);
        assertEquals(a.get(), (Integer) 3);
        a.set(6);
        assertEquals(a.get(), (Integer) 6);
    }

    @Test
    public void setFirstWithTwo() {
        H1 a = new H1(3);
        H1 b = new H1(9);
        a.setNext(b);
        assertEquals(a.get(), (Integer) 3);
        a.set(6);
        assertEquals(a.get(), (Integer) 6);
    }

    @Test
    public void setSecondWithTwoFromSecond() {
        H1 a = new H1(3);
        H1 b = new H1(9);
        a.setNext(b);
        b.set(6);
        assertEquals(b.get(), (Integer) 6);
    }

    @Test
    public void setSecondWithTwoFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(9);
        a.setNext(b);
        assertEquals(a.get(), (Integer) 3);
        a.next().set(6);
        assertEquals(b.get(), (Integer) 6);
    }

    @Test
    public void setSecondWithTwoFromFirstAndGetFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(9);
        a.setNext(b);
        assertEquals(a.get(), (Integer) 3);
        a.next().set(6);
        assertEquals(a.next().get(), (Integer) 6);
    }

    @Test
    public void setSecondWithTwoFromSecondAndGetFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(9);
        a.setNext(b);
        assertEquals(a.get(), (Integer) 3);
        b.set(6);
        assertEquals(a.next().get(), (Integer) 6);
    }

    @Test
    public void setNext() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        a.setNext(b);
        assertEquals(a.next(), b);
        assertEquals(a.next().get(), (Integer)5);
    }

    @Test
    public void setNextReplaceFirst() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(4);
        a.setNext(b);
        assertEquals(a.next(), b);
        a.setNext(c);
        assertEquals(a.next(), c);
    }

    @Test
    public void setNextSetThirdFormSecond() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(4);
        a.setNext(b);
        b.setNext(c);
        assertEquals(b.next(), c);
    }

    @Test
    public void setNextSetThirdFormSecondAndGetFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(4);
        a.setNext(b);
        b.setNext(c);
        assertEquals(a.next().next(), c);
    }

    @Test
    public void setNextSetThirdFormFirstAndGetFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(4);
        a.setNext(b);
        a.next().setNext(c);
        assertEquals(a.next().next(), c);
    }

    @Test
    public void setNextSetThirdFormFirstAndGetFromSecond() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(4);
        a.setNext(b);
        a.next().setNext(c);
        assertEquals(b.next(), c);
    }

    @Test
    public void append() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        a.append(b);
        assertEquals(a.next(), b);
        assertEquals(a.next().get(), (Integer)5);
    }

    @Test
    public void appendWithThreeAndAddedThirdFromSecondAndTestFromSecond() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(9);
        a.append(b);
        b.append(c);
        assertEquals(b.next(), c);
    }

     @Test
    public void appendWithThreeAndAddedThirdFromSecondAndTestFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(9);
        a.append(b);
        b.append(c);
        assertEquals(a.next().next(), c);
    }

     @Test
    public void appendWithThreeAndAddedThirdFromFirstAndTestFromSecond() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(9);
        a.append(b);
        a.append(c);
        assertEquals(a.next(), b);
        assertEquals(b.next(), c);
    }

    @Test
    public void appendWithThreeAndAddedThirdFromFirstAndTestFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(9);
        a.append(b);
        a.append(c);
        assertEquals(a.next(), b);
        assertEquals(a.next().next(), c);
    }

   @Test
    public void appendWithThreeAndAddedThirdFromTheSecondThenTheSecondFromTheFirstAndTestFromFirst() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(9);
        b.append(c);
        a.append(b);
        assertEquals(a.next(), b);
        assertEquals(a.next().next(), c);
        assertEquals(b.next(), c);
    }

    @Test
    public void insertWithTwoAndTestFromTheInserted() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        a.insert(b);
        assertEquals(b.next(), a);
    }

    @Test
    public void insertWithThreeWithInsertedBeforeTheTwoAndTestFromTheInserted() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(1);
        a.setNext(c);
        a.insert(b);
        assertEquals(b.next(), a);
        assertEquals(b.next().next(), c);
    }

    @Test
    public void insertWithThreeWithTheInsertedBeingTwoSoTheSecondOneIsRemovedAndTestFromTheInserted() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(1);
        b.setNext(c);
        a.insert(b);
        assertEquals(b.next(), a);
        assertEquals(b.next().next(), null);
    }

    @Test
    public void insertWithThreeWithTheInsertedBeingTwoButInsertingTheSecondOneForAListOfAllThreeAndTestFromTheInserted() {
        H1 a = new H1(3);
        H1 b = new H1(5);
        H1 c = new H1(1);
        b.setNext(c);
        a.insert(c);
        assertEquals(b.next(), c);
        assertEquals(b.next().next(), a);
        assertEquals(c.next(), a);
    }
}