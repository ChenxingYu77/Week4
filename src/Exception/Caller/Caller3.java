package Exception.Caller;

import Exception.myException.MyException;
import Exception.myException.MyRuntimeException;

public class Caller3 {
    public void callThrowRTException(){
        System.out.println("Caller3.callRTException开始");
        try{
        Object n = null;
        n.toString();
        } catch (Exception ex){
            throw new MyRuntimeException("执行callThrowRTException出错",ex);
        }
        System.out.println("Caller3.callRTException结束");
    }

    public void callThrowException() throws MyException{
        System.out.println("Caller3.callException开始");
        try {
            Class.forName("com.neverland.Rabbit");
        } catch (ClassNotFoundException ex){
            throw new MyException("",ex);
        }
        System.out.println("Caller3.callException结束");
    }
}
