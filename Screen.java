import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Screen {
    private JFrame frame;
    private Label label;
    private JPanel ButtonPanel;
    private JButton []numberButtons;
    private JButton addButton;
    private JButton subButton;
    private JButton multiButton;
    private JButton divButton;
    private JButton equalButton;
    private JButton resetButton;
    private JButton demicalButton;
    private final int buttonHeightSize=50;
    private final int buttonWidthSize=50;
    private final int buttonBufferSize=10;
    
    public Screen(){
        //フレーム作成
        frame=new JFrame("8桁電卓");
        frame.setSize(4*(buttonBufferSize+buttonWidthSize)+buttonBufferSize*2,5*(buttonBufferSize+buttonWidthSize)+buttonBufferSize*2+50);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //ラベル作成(ここに計算結果を表示する)
        label=new Label("Let's Calc");
        frame.add("North",label);

        //ボタン用パネル作成
        ButtonPanel=new JPanel();
        ButtonPanel.setLayout(null);
        frame.add("Center",ButtonPanel);

        int buttonLocationX;//ボタン位置X
        int buttonLocationY;//ボタン位置Y

        //数字ボタン作成
        numberButtons=new JButton[10];
        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(Integer.toString(i));
            ButtonPanel.add(numberButtons[i]);
            buttonLocationX=((i+2)%3)*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
            buttonLocationY=((9-i)/3)*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
            numberButtons[i].setBounds(buttonLocationX,buttonLocationY,buttonWidthSize,buttonHeightSize);
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
            });
        }

        // 演算子ボタン作成
        addButton=new JButton("+");
        subButton=new JButton("-");
        multiButton=new JButton("×");
        divButton=new JButton("÷");
        equalButton=new JButton("=");
        resetButton=new JButton("C");
        demicalButton=new JButton(".");

        ButtonPanel.add(addButton);
        ButtonPanel.add(subButton);
        ButtonPanel.add(multiButton);
        ButtonPanel.add(divButton);
        ButtonPanel.add(equalButton);
        ButtonPanel.add(resetButton);
        ButtonPanel.add(demicalButton);

        buttonLocationX=3*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=3*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        addButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize, buttonHeightSize);
        addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });

        buttonLocationX=3*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=2*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        subButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize, buttonHeightSize);
        subButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });

        buttonLocationX=3*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=1*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        multiButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize, buttonHeightSize);
        multiButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });

        buttonLocationX=3*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=0*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        divButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize, buttonHeightSize);
        divButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });
        
        buttonLocationX=0*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=4*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        equalButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize*4+buttonBufferSize*3, buttonHeightSize);
        equalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });

        buttonLocationX=0*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=3*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        resetButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize, buttonHeightSize);
        resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });

        buttonLocationX=1*(buttonBufferSize+buttonWidthSize)+buttonBufferSize;
        buttonLocationY=3*(buttonBufferSize+buttonHeightSize)+buttonBufferSize;
        demicalButton.setBounds(buttonLocationX, buttonLocationY, buttonWidthSize, buttonHeightSize);
        demicalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                }
        });

        //画面描画
        frame.validate();
    }
}
