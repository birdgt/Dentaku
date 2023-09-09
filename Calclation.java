//import javax.swing.JOptionPane;


public class Calclation {
    final Integer num1;
    final Integer num2;
    final Operator operator;


    //初期化
    private Calclation(Integer num1,Integer num2,Operator usedOperator){
        this.num1=num1;
        this.num2=num2;
        this.operator=usedOperator;
    }

    Calclation(){
        this.num1=null;
        this.num2=null;
        this.operator=Operator.None;
    }

    Calclation reset(){
        return new Calclation(null, null, Operator.None);
    }


    Calclation inputNumber(int inputNumber){
        Integer newNum1;
        Integer newNum2;
        int tmpNum1;
        int tmpNum2;
        if(num1==null){
            tmpNum1=0;
        }else{
            tmpNum1 =this.num1;
        }
        
        if(num2==null){
            tmpNum2=0;
        }else{
            tmpNum2=this.num2;
        }

        if(operator==Operator.None){
            newNum1=tmpNum1*10+inputNumber;
            newNum2=null;
        }else{
            newNum1=this.num1;
            newNum2=tmpNum2*10+inputNumber;
        }
        return new Calclation(newNum1,newNum2,this.operator);
    }

    Calclation inputOperator(Operator inputOperator){
        Operator newOperator;
        if(this.num1==null){
            return reset();
        }

        if(this.operator==Operator.None){
            //一回目の入力
            newOperator=inputOperator;
        }else{
            //すでに演算子を入力済みのとき
            newOperator=this.operator;
        }

        return new Calclation(num1, num2, newOperator);
    }

    int equal(){
        int calcValue;
        switch(this.operator){
            case None:
                calcValue=0;
                break;

            case Add:
                calcValue=num1+num2;
                break;
            case Div:
                calcValue=num1/num2;
                break;

            case Multi:
                calcValue=num1*num2;
                break;
            
            case Sub:
                calcValue=num1-num2;
                break;

            default:
                calcValue=0;//要修正
                break;

        }

        return calcValue;
    }

    String getNum1(){
        if(num1==null){
            return "";
        }else{
            return Integer.toString(num1);
        }
    }

    String getNum2(){
        if(num2==null){
            return "";
        }else{
            return Integer.toString(num2);
        }
    }

    String getOpe(){
        switch(this.operator){
            case None:
            return "None";
            case Add:
            return "+";
            case Sub:
            return "-";
            case Multi:
            return "×";
            case Div:
            return "÷";
        }
        return null;//要修正

    }
}


