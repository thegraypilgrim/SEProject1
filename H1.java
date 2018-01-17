
public class H1 implements ILinkedList<Integer>{
    private H1 nextList;
    private Integer valueOfElement;

    H1(Integer a){
        valueOfElement = a;
        nextList = null;
    }
    public ILinkedList<Integer> next(){
        return nextList;
    }
    public ILinkedList<Integer> last(){
        H1 temp = this;
        while(temp.nextList != null){
            temp = temp.nextList;
        }
        return temp;
    }
    public ILinkedList<Integer> after(int n){
        H1 temp = this;
        for(int i = 0; i < n; i++){
            if (temp == null){
                throw new NullPointerException("Is longer then Length");
            }
            temp = temp.nextList;

        }
        return temp;

    }
    public ILinkedList<Integer> detach(){
        H1 temp = nextList;
        nextList = null;
        return temp;
    }
    public Integer get(){
        return valueOfElement;
    }
    public void set(Integer value){
        valueOfElement = value;
    } 
    public void setNext(ILinkedList<Integer> next){
        nextList = (H1)next;
    }
    public void append(ILinkedList<Integer> next){
        H1 temp = this;
        while(temp.nextList !=null){
            temp = temp.nextList;
        }
        temp.nextList = (H1)next;
    }
    public void insert(ILinkedList<Integer> newFirst){
        ((H1)newFirst).nextList = this;
    }
}