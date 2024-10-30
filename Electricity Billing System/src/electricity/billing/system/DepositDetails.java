package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*; 
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class DepositDetails extends JFrame implements ActionListener{
    
    
    Choice meternumber,cmonth,cstatus;
    JTable table;
    JButton search,print;
    
    DepositDetails(){
        super("Deposit Details");
        
        
        setSize(700,500);
        setLocation(300,100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblmeternumber = new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20,20,150,20);
        add(lblmeternumber);

        meternumber = new Choice();
        meternumber.setBounds(180,20,150,20);
        add(meternumber);

                try {
                    Conn c = new Conn();
                    ResultSet rs= c.s.executeQuery("Select *from customer");
                    while(rs.next()){
                        meternumber.add(rs.getString("meter_no"));
                    }
                    
                } catch(Exception e){
                    e.printStackTrace();
                }
        JLabel lblmonth = new JLabel("Search By Month");
        lblmonth.setBounds(400,20,100,20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(520,20,150,20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
        
        
         JLabel lblstatus = new JLabel("Search By Status");
        lblstatus.setBounds(20,60,150,20);
        add(lblstatus);

        cstatus = new Choice();
        cstatus.setBounds(180,60,150,20);
        cstatus.add("Paid");
        cstatus.add("Not Paid");
        add(cstatus);


        
        table = new JTable();
        
        try {
                    Conn c = new Conn();
                    ResultSet rs= c.s.executeQuery("Select *from bill");
     
                    
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch(Exception e){
                    e.printStackTrace();
                }
        
                JScrollPane sp = new JScrollPane(table);
                sp.setBounds(0,150,700,600);
                add(sp);
                
                
                search = new JButton("Search");
                search.setBounds(20, 120, 80, 20);
                search.addActionListener(this);
                add(search);
                
                print = new JButton("Print");
                print.setBounds(120, 120, 80, 20);
                print.addActionListener(this);
                add(print);
        

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()== search) {
     String query = "Select * from bill where meter_no = '"+meternumber.getSelectedItem()+"'and month ='"+cmonth.getSelectedItem()+"'and status ='"+cstatus.getSelectedItem()+"'";
     
    try {
         Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        
    }

    }else {
        
        try {
            table.print();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    }
    
    public static void main(String[] args) {
        new DepositDetails();
    }
    
}
