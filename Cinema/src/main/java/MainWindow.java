import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class MainWindow{

    private JFrame thisWind;
    private List<Ticket> tickets = new ArrayList<Ticket>();
    private JTextArea standardTicketArea,studentTicketArea,oapTicketArea,childTicketArea,resultArea;

    public void init(){
        thisWind = new JFrame("Cinema System");


        standardTicketArea = SwingUtils.createSimpleTextArea(
                new Color(0,255,255),20,50,100,20);
        standardTicketArea.setText("0");
        thisWind.add(standardTicketArea);

        JLabel standardLabel = SwingUtils.createSimpleLabel("Standard Ticket £8",125,50,120,20);
        thisWind.add(standardLabel);

        studentTicketArea = SwingUtils.createSimpleTextArea(
                new Color(0,255,255),20,75,100,20);
        studentTicketArea.setText("0");
        thisWind.add(studentTicketArea);

        JLabel studentLabel = SwingUtils.createSimpleLabel("Student Ticket £6",125,75,100,20);
        thisWind.add(studentLabel);

        oapTicketArea = SwingUtils.createSimpleTextArea(
                new Color(0,255,255),20,100,100,20);
        oapTicketArea.setText("0");
        thisWind.add(oapTicketArea);

        JLabel oapLabel = SwingUtils.createSimpleLabel("OAP Ticket £6",125,100,100,20);
        thisWind.add(oapLabel);

        childTicketArea = SwingUtils.createSimpleTextArea(
                new Color(0,255,255),20,125,100,20);
        childTicketArea.setText("0");
        thisWind.add(childTicketArea);

        JLabel childLabel = SwingUtils.createSimpleLabel("Child Ticket £4",125,125,100,20);
        thisWind.add(childLabel);

        resultArea = SwingUtils.createSimpleTextArea(
                new Color(255,255,255),50,350,50,20);
        resultArea.setEditable(false);
        resultArea.setText("0");
        thisWind.add(resultArea);

        JButton calculateButton = SwingUtils.createSimpleButton("Calculate",50,300,100,40);
        submitSelection(resultArea, calculateButton);
        thisWind.add(calculateButton);

        JButton clearButton = SwingUtils.createSimpleButton("Clear Screen",160,300,150,40);
        clearScreen(clearButton);
        thisWind.add(clearButton);

        setUpWindow(500,500);
    }

    private void clearScreen(JButton clearButton) {
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                standardTicketArea.setText("0");
                studentTicketArea.setText("0");
                oapTicketArea.setText("0");
                childTicketArea.setText("0");
                resultArea.setText("0");
                tickets.clear();
            }
        });
    }

    private void submitSelection(final JTextArea resultArea, JButton calculate) {
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                findSelectedTickets();
                if (tickets.isEmpty()){
                    System.out.println("NO TICKETS SELECTED");
                }else {
                    String results = PriceCalculator.calculate(tickets);
                    resultArea.setText(results);
                }
            }
        });
    }

    private void findSelectedTickets() {
        int numberOfStandard = Integer.parseInt(standardTicketArea.getText().trim());
        for (int i = 0; i < numberOfStandard; i++) {
            tickets.add(new Ticket(TicketType.STANDARD));
        }
        int numberOfStudent = Integer.parseInt(studentTicketArea.getText().trim());
        for (int i = 0; i < numberOfStudent; i++) {
            tickets.add(new Ticket(TicketType.STUDENT));
        }
        int numberOfOAP = Integer.parseInt(oapTicketArea.getText().trim());
        for (int i = 0; i < numberOfOAP; i++) {
            tickets.add(new Ticket(TicketType.OAP));
        }
        int numberOfChild = Integer.parseInt(childTicketArea.getText().trim());
        for (int i = 0; i < numberOfChild; i++) {
            tickets.add(new Ticket(TicketType.CHILD));
        }
    }

    private void setUpWindow(int width, int height) {
        thisWind.setLayout(null);
        thisWind.setBounds(0,0,width,height);
        thisWind.setVisible(true);
    }

}
