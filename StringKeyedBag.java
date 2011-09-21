/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxknee1
 */
public class StringKeyedBag {
    private int[] keys;
    private String[] names;
    private int manyItems;
    
    public StringKeyedBag(){
        final int INITIAL_CAPACITY = 10;
        keys = new int[INITIAL_CAPACITY];
        names = new String[INITIAL_CAPACITY];
        manyItems = 0;
   }
    public StringKeyedBag(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException
                    ("The intial capacity is negative: " + initialCapacity);}
            names = new String[initialCapacity];
            keys = new int[initialCapacity];
            manyItems = 0;
        
    }
    public void insert(String element, int key){
        if (manyItems == names.length && manyItems == keys.length){
            ensureCapacity((manyItems + 1) * 2);
        }
        names[manyItems] = element;
        keys[manyItems] = key;
        manyItems++;
    }
    public boolean remove(int target){
        int index;
        for (index =0; (index < manyItems) && (target != keys[index]); index++){}
        if (index == manyItems){
            return false;
        }else {
            manyItems--;
            keys[index] = keys[manyItems];
            names[index] = names[manyItems];
            return true;
        }
        
    }
    public String containsKey(int target){
        int index; 
        for (index = 0; (index < manyItems) && (target != keys[index]); index++){
            
        }
        if (index == manyItems){
            return "Key not Found";
        }
        else {return names[index];}
    }
    public void ensureCapacity(int minimumCapacity){
       int[] biggerArray;
       String [] namesBigger;
       if (names.length < minimumCapacity && keys.length < minimumCapacity){
           biggerArray = new int[minimumCapacity];
           namesBigger = new String[minimumCapacity];
           System.arraycopy(keys, 0, biggerArray, 0, manyItems);
           System.arraycopy(names, 0, namesBigger, 0, manyItems);
           names = namesBigger;
           keys = biggerArray;
       }
    }
     public int getCapacity( )
    {
        return names.length;
    }
    
    public int size()
    {
        return manyItems;        
    }
    public void trimToSize()
    {
        String[] trimmedDataArray;
        int[] trimmedKeyArray;
      
        if (names.length != manyItems)
        {
            trimmedDataArray = new String[manyItems];
            trimmedKeyArray = new int[manyItems];
            
            System.arraycopy(names, 0, trimmedDataArray, 0, manyItems);
            System.arraycopy(keys, 0, trimmedKeyArray, 0, manyItems);
            
            
            names = trimmedDataArray;
            keys = trimmedKeyArray;
        }
    }

    
}
