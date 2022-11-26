package system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class AddStudent implements ActionListener {

    JFrame frame;
    JLabel fName, lastName, age, dateOfBerth, phone, Email, id8, IdNumber, caves, courseLabel, departmentLabel;
    JTextField jTextFieldFName, jTextFieldLastName, jTextFieldAge, jTextFieldDateOfBerth,  jTextFieldPhone, jTextFieldEmail, jTextFieldIdNumber;
    JButton submit, cancel;
    JComboBox course, Department;


    Random random = new Random();
    long first4 = (random.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4);


     AddStudent() {
        frame = new JFrame("Add Student");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        caves = new JLabel();
        caves.setBounds(0, 0, 900, 700);
        caves.setLayout(null);
        ImageIcon img = new ImageIcon("~/icons/fourth.jpg");
        Image i3 = img.getImage().getScaledInstance(1220, 700, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        caves.setIcon(icc3);

        id8 = new JLabel("New Student Details");
        id8.setBounds(320, 30, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 25));
        id8.setForeground(Color.black);
        caves.add(id8);
        frame.add(caves);


        fName = new JLabel("Name");
        fName.setBounds(50, 150, 100, 30);
        fName.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(fName);

        jTextFieldFName = new JTextField();
        jTextFieldFName.setBounds(200, 150, 150, 30);
        caves.add(jTextFieldFName);

        lastName = new JLabel("last Name");
        lastName.setBounds(400, 150, 200, 30);
        lastName.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(lastName);

        jTextFieldLastName = new JTextField();
        jTextFieldLastName.setBounds(600, 150, 150, 30);
        caves.add(jTextFieldLastName);

        age = new JLabel("Age");
        age.setBounds(50, 200, 100, 30);
        age.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(age);

        jTextFieldAge = new JTextField();
        jTextFieldAge.setBounds(200, 200, 150, 30);
        caves.add(jTextFieldAge);

        dateOfBerth = new JLabel("DOB (dd/mm/yyyy)");
        dateOfBerth.setBounds(400, 200, 200, 30);
        dateOfBerth.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(dateOfBerth);

        jTextFieldDateOfBerth = new JTextField();
        jTextFieldDateOfBerth.setBounds(600, 200, 150, 30);
        caves.add(jTextFieldDateOfBerth);


        phone = new JLabel("Phone");
        phone.setBounds(400, 250, 100, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(phone);

        jTextFieldPhone = new JTextField();
        jTextFieldPhone.setBounds(600, 250, 150, 30);
        caves.add(jTextFieldPhone);

        Email = new JLabel("Email ");
        Email.setBounds(50, 250, 100, 30);
        Email.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(Email);

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setBounds(200, 250, 150, 30);
        caves.add(jTextFieldEmail);


        IdNumber = new JLabel("ID No");
        IdNumber.setBounds(50, 400, 150, 30);
        IdNumber.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(IdNumber);

        jTextFieldIdNumber = new JTextField();
        jTextFieldIdNumber.setBounds(200, 400, 150, 30);
        jTextFieldIdNumber.setText("1533" + first);
        caves.add(jTextFieldIdNumber);


        courseLabel = new JLabel("Course");
        courseLabel.setBounds(400, 400, 150, 30);
        courseLabel.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(courseLabel);

        String course[] = {"calculus", "physic", "OOP", "Programing", "database", "AI", "Linux"};
        this.course = new JComboBox(course);
        this.course.setBackground(Color.WHITE);
        this.course.setBounds(600, 400, 150, 30);
        caves.add(this.course);

        departmentLabel = new JLabel("department");
        departmentLabel.setBounds(50, 450, 150, 30);
        departmentLabel.setFont(new Font("serif", Font.BOLD, 20));
        caves.add(departmentLabel);

        String departments[] = {"Computer Science", "Computer Engineering", "Civil Engineering", "MLS", "Pharmacy"};
        Department = new JComboBox(departments);
        Department.setBackground(Color.WHITE);
        Department.setBounds(200, 450, 150, 30);
        caves.add(Department);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 550, 150, 40);

        caves.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450, 550, 150, 40);

        caves.add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setLocation(400, 150);
    }

    public void actionPerformed(ActionEvent ae) {

        String fNameText = jTextFieldFName.getText();
        String lastNameText = jTextFieldLastName.getText();
        String ageText = jTextFieldAge.getText();
        String dateOfBerthText = jTextFieldDateOfBerth.getText();
        String phoneText = jTextFieldPhone.getText();
        String emailText = jTextFieldEmail.getText();
        String idNumberText = jTextFieldIdNumber.getText();
        String courseSelectedItem = (String) course.getSelectedItem();
        String departmentSelectedItem = (String) Department.getSelectedItem();

        if (ae.getSource() == submit) {
            try {

                dbConnection connection = new dbConnection();
                String q = "insert into student values('" + fNameText + "','" + lastNameText + "','" + ageText + "','" + dateOfBerthText + "','" + phoneText + "','" + emailText + "','"  + idNumberText + "','" + courseSelectedItem + "','" + departmentSelectedItem + "')";
                connection.getMyStamen().executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                frame.setVisible(false);
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        } else if (ae.getSource() == cancel) {
            frame.setVisible(false);
            new Project().setVisible(true);

        }
    }

    public static void main(String[] arg) {
        new AddStudent().frame.setVisible(true);
    }
}