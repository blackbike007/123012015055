package com.pattern.singleton;

public class ChocolateBoiler {  
    private boolean empty;  
    private boolean boiled;  
    private static ChocolateBoiler uniqueInstance;  
    
    private ChocolateBoiler() {  
        empty = true;  
        boiled = false;  
    }  
    
    public static ChocolateBoiler getInstance() {  
        if (uniqueInstance == null) {  
            System.out.println("Creating unique instance of Chocolate Boiler");  
            uniqueInstance = new ChocolateBoiler();  
        }  
        System.out.println("Returning instance of Chocolate Boiler");  
        return uniqueInstance;  
    }  
  
    public void fill() {  
        if (isEmpty()) {  
            empty = false;  
            boiled = false;  
            // �ڹ�¯�������ɿ�����ţ�̵Ļ����  
        }  
    }  
   
    public void drain() {  
        if (!isEmpty() && isBoiled()) {  
            //�ų���е��ɿ�����ţ��  
            empty = true;  
        }  
    }  
   
    public void boil() {  
        if (!isEmpty() && !isBoiled()) {  
            //��¯�������  
            boiled = true;  
        }  
    }  
    
    public boolean isEmpty() {  
        return empty;  
    }  
   
    public boolean isBoiled() {  
        return boiled;  
    }  
}  