//import java.awt.Window;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
    static Calclation calc =new Calclation();
    static JFrame frame;
    static Label label;

    public static void main(String[] args) {


        //フレーム作成
        frame=new JFrame("calclation");
        frame.setSize(240,290);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //ラベル作成
        label=new Label("Let's Calc");
        frame.add("North",label);

        //ボタン用パネル作成
        JPanel ButtonPanel=new JPanel();
        ButtonPanel.setLayout(null);
        frame.add("Center",ButtonPanel);

        //ボタン作成
        JButton []numberButtons;
        numberButtons=new JButton[10];
        int x;
        int y;
        for(int i=0;i<10;i++){
            if(i==0){
                x=0;
                y=3;
            }else{
                x=(i-1)%3;
                y=(int)(2-Math.ceil((i-1)/3));
            }
            numberButtons[i]=createButtons(Integer.toString(i),x,y);
            ButtonPanel.add(numberButtons[i]);
        }

        JButton addButton =createButtons("+", 3, 3);
        JButton subButton =createButtons("-", 3, 2);
        JButton multiButton =createButtons("×", 3, 1);
        JButton divButton =createButtons("÷", 3, 0);
        JButton equalButton=createButtons("=", 2, 3);
        JButton resetButton=createButtons("C", 1, 3);
        ButtonPanel.add(addButton);
        ButtonPanel.add(subButton);
        ButtonPanel.add(multiButton);
        ButtonPanel.add(divButton);
        ButtonPanel.add(equalButton);
        ButtonPanel.add(resetButton);
   
        frame.validate();

        
        //テストケース
        /*
        
        calc=calc.inputNumber(1);
        calc=calc.inputNumber(9);
        calc=calc.inputOperator(Operator.Add);
        calc=calc.inputNumber(1);
        calc=calc.inputNumber(1);
        calc=calc.inputOperator(Operator.Add);
        int value=calc.equal();
        System.out.println(value);
        */

    }

    
    private static JButton createButtons(final String text,final int buttonLocationX ,final int buttonLocationY){
        final int buttonsSize=50;
        final int buffer=5;
        final int setButtonsHeight =buffer+buttonLocationY*(buttonsSize+buffer);
        final int setButtonsWidth =buffer +buttonLocationX*(buttonsSize+buffer);

        JButton button =new JButton(text);
        button.setBounds(setButtonsWidth,setButtonsHeight,buttonsSize,buttonsSize);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg;
                if(text.equals("=")){
                    msg=calc.getNum1()+calc.getOpe()+calc.getNum2()+"="+Integer.toString(calc.equal());
                    calc=calc.reset();
                }else if(text.equals("+")){
                    calc=calc.inputOperator(Operator.Add);
                    msg=Integer.toString(calc.num1)+"+";
                }else if(text.equals("-")){
                    calc=calc.inputOperator(Operator.Sub);
                    msg=Integer.toString(calc.num1)+"-";
                }else if(text.equals("×")){
                    calc=calc.inputOperator(Operator.Multi);
                    msg=Integer.toString(calc.num1)+"×";
                }else if(text.equals("÷")){
                    calc=calc.inputOperator(Operator.Div);
                    msg=Integer.toString(calc.num1)+"÷";
                }else if(text.equals("C")){
                    calc=calc.reset();
                    msg="reset!!";
                    
                }else{
                    calc=calc.inputNumber(Integer.parseInt(text));
                    if(calc.getOpe().equals("None")){
                        msg=calc.getNum1();
                    }else{
                        msg=calc.getNum1()+calc.getOpe()+calc.getNum2();
                    }
                }
                label.setText(msg);
            }
        });
        return button;
    }


    

}

