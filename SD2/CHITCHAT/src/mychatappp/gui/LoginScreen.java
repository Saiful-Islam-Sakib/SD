/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatappp.gui;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

/**
 *
 * @author LUCIFER
 */
        
public class LoginScreen extends javax.swing.JFrame {
    
    String birthdayfile = "D:\\Netbeans\\project_files\\chitchat(16.01.04.009,16.01.04.016 & 16.01.04.017)\\src\\doc\\birthday.txt";
    String emailfile = "D:\\Netbeans\\project_files\\chitchat(16.01.04.009,16.01.04.016 & 16.01.04.017)\\src\\doc\\email.txt";
    String genderfile = "D:\\Netbeans\\project_files\\chitchat(16.01.04.009,16.01.04.016 & 16.01.04.017)\\src\\doc\\gender.txt";
    String namefile = "D:\\Netbeans\\project_files\\chitchat(16.01.04.009,16.01.04.016 & 16.01.04.017)\\src\\doc\\name.txt";
    String passwordfile = "D:\\Netbeans\\project_files\\chitchat(16.01.04.009,16.01.04.016 & 16.01.04.017)\\src\\doc\\password.txt";
    
    
    String nastr = new String();    //name
    String nestr = new String();    //email
    String npstr = new String();    //new password
    String rnpstr = new String();   //re enter new password
    String bstr = new String();
    String gstr = new String();
    
    boolean gflag = false;
    
    /**
     * Creates new form NewJFrame
     */
    public LoginScreen() {
        initComponents();
        logout.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        facebook = new javax.swing.JLabel();
        loginemail = new javax.swing.JTextField();
        loginpassword = new javax.swing.JPasswordField();
        loginemaillbl = new javax.swing.JLabel();
        loginpasslbl = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        creatnewaccountlbl = new javax.swing.JLabel();
        newfirstname = new javax.swing.JTextField();
        newlastname = new javax.swing.JTextField();
        newemail = new javax.swing.JTextField();
        day = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JComboBox<>();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        creataccount = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        previousdata = new javax.swing.JButton();
        newpassword = new javax.swing.JPasswordField();
        reenterpassword = new javax.swing.JPasswordField();
        newemaillbl = new javax.swing.JLabel();
        newpasswordlbl = new javax.swing.JLabel();
        namelbl = new javax.swing.JLabel();
        newreenterpasswordlbl = new javax.swing.JLabel();
        genderlbl = new javax.swing.JLabel();
        birthdaylbl = new javax.swing.JLabel();
        firstnamelbl = new javax.swing.JLabel();
        lastnamelbl = new javax.swing.JLabel();
        errormsg = new javax.swing.JLabel();
        errorloginmsg = new javax.swing.JLabel();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facebook Login");

        facebook.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        facebook.setForeground(new java.awt.Color(0, 51, 255));
        facebook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        facebook.setText("ChitChat");

        loginpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginpasswordActionPerformed(evt);
            }
        });

        loginemaillbl.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        loginemaillbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginemaillbl.setText("Email / Phone Number");

        loginpasslbl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        loginpasslbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginpasslbl.setText("Password");

        login.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        login.setText("Log in");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        creatnewaccountlbl.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        creatnewaccountlbl.setText("Creat New Account");

        newfirstname.setToolTipText("");
        newfirstname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        newfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newfirstnameActionPerformed(evt);
            }
        });

        newlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newlastnameActionPerformed(evt);
            }
        });

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - -", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - -", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        creataccount.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        creataccount.setText("Creat Account");
        creataccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creataccountActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        previousdata.setText("Previous Data");

        reenterpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reenterpasswordActionPerformed(evt);
            }
        });

        newemaillbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newemaillbl.setText("Email");

        newpasswordlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newpasswordlbl.setText("New Passsword");

        namelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namelbl.setText("Name");

        newreenterpasswordlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newreenterpasswordlbl.setText("Re Enter Password");

        genderlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderlbl.setText("Gender");

        birthdaylbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        birthdaylbl.setText("Birth Day");

        firstnamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstnamelbl.setText("First Name");
        firstnamelbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lastnamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastnamelbl.setText("Last Name");
        lastnamelbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        errormsg.setForeground(new java.awt.Color(255, 0, 0));

        errorloginmsg.setForeground(new java.awt.Color(255, 0, 0));
        errorloginmsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(loginemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(loginpasslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lastnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(206, 206, 206)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(newpasswordlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newemaillbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(namelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newreenterpasswordlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(genderlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(birthdaylbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(reenterpassword)
                                        .addComponent(newpassword)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(male)
                                            .addGap(18, 18, 18)
                                            .addComponent(female))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(newemail)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(newfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(newlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(firstnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errormsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(facebook, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(refresh)
                                        .addGap(18, 18, 18)
                                        .addComponent(creataccount, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(previousdata))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(loginemail, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(errorloginmsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(login)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logout)))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(creatnewaccountlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginpasslbl)
                    .addComponent(loginemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(facebook)
                        .addGap(18, 18, 18)
                        .addComponent(creatnewaccountlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstnamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(lastnamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginpassword)
                            .addComponent(login)
                            .addComponent(logout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorloginmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpasswordlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reenterpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newreenterpasswordlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(errormsg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdaylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(male)
                    .addComponent(female)
                    .addComponent(genderlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(creataccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(previousdata, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginpasswordActionPerformed

    private void newlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newlastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newlastnameActionPerformed

    private void reenterpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reenterpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reenterpasswordActionPerformed

    private void newfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newfirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newfirstnameActionPerformed

    private void creataccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creataccountActionPerformed
        if (!newfirstname.getText().equals("") && !newlastname.getText().equals("") && !newemail.getText().equals("") && !newpassword.getText().equals("") && !reenterpassword.getText().equals("") && (!day.getItemAt(day.getSelectedIndex()).equals("-") && !month.getItemAt(month.getSelectedIndex()).equals("- - -") && !year.getItemAt(year.getSelectedIndex()).equals("- - -")) && gflag) {
            FileWriter namefw = null;
            FileWriter emailfw = null;
            FileWriter passwordfw = null;
            FileWriter birthdayfw = null;
            FileWriter genderfw = null;
            
            BufferedWriter namebw = null;
            BufferedWriter emailbw = null;
            BufferedWriter passwordbw = null;
            BufferedWriter birthdaybw = null;
            BufferedWriter genderbw = null;

            try {
                // TODO add your handling code here:
                nastr = newfirstname.getText() + " " + newlastname.getText();       //name
                nestr = newemail.getText();                                         // new email address
                npstr = newpassword.getText();                                      // new password
                rnpstr = reenterpassword.getText();                                 //re enter password
                bstr = day.getSelectedItem()+ "-" + month.getSelectedItem() + "-" + year.getSelectedItem();    // birth day
                if (male.isSelected()) {
                    gstr = "male";                                               // Gender
                } else if (female.isSelected()) {
                    gstr = "female";
                }

                namefw = new FileWriter(namefile, true);
                emailfw = new FileWriter(emailfile, true);
                passwordfw = new FileWriter(passwordfile, true);
                birthdayfw = new FileWriter(birthdayfile, true);
                genderfw = new FileWriter(genderfile, true);

                namebw = new BufferedWriter(namefw);
                emailbw = new BufferedWriter(emailfw);
                passwordbw = new BufferedWriter(passwordfw);
                birthdaybw = new BufferedWriter(birthdayfw);
                genderbw = new BufferedWriter(genderfw);

                if (emailchecker(nestr)) {
                    if (npstr.equals(rnpstr)) {
                        namebw.write(nastr.trim());
                        namebw.newLine();

                        emailbw.write(nestr.trim());
                        emailbw.newLine();

                        passwordbw.write(npstr);
                        passwordbw.newLine();

                        birthdaybw.write(bstr);
                        birthdaybw.newLine();

                        genderbw.write(gstr);
                        genderbw.newLine();
                    } else {
                        errormsg.setText("Password Miss Matched");
                    }
                } else {
                    errormsg.setText("Invalid Email Address, use -> (gmail, outlook, icloud, yahoo)");
                }

                // closing Buffer
                namebw.close();
                emailbw.close();
                passwordbw.close();
                birthdaybw.close();
                genderbw.close();

                /// closing file
                namefw.close();
                emailfw.close();
                passwordfw.close();
                birthdayfw.close();
                genderfw.close();

            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            errormsg.setText("Please Fill All the requirements");
        }
        
    }//GEN-LAST:event_creataccountActionPerformed
    public static boolean emailchecker(String email){
        
        boolean tempbool = false;
        
        String[] arraystr = {"gmail.com" , "outlook.com" , "yahoo.com" , "icloud.com"};
        
        for (String s: arraystr){
            if (email.endsWith(s)){
                return true;
            }
        }        
        return tempbool;
    }
    
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String loginemailstr = new String();
        String loginpasswordstr = new String();
        
        String tempemail = new String();
        String temppassword = new String();
        
        loginemailstr = loginemail.getText();
        loginpasswordstr = loginpassword.getText();
        
        Scanner sc1 = null, sc2 = null;
        try {
            FileInputStream istreamemail = new FileInputStream(emailfile);
            FileInputStream istreampass = new FileInputStream(passwordfile);
            
            sc1 = new Scanner(istreamemail);
            sc2 = new Scanner(istreampass);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int flag = 0;
        while(sc1.hasNext() && sc2.hasNext()){
            tempemail = sc1.next();
            temppassword = sc2.next();
            
            if (loginemailstr.equals(tempemail) && loginpasswordstr.equals(temppassword)){
                flag = 1;
                this.loginemail.setText("");
                this.loginpassword.setText("");
                
                MainScreen mainScreen = new MainScreen();
                
                mainScreen.show();
                
                this.show(false);
                // all false
//                facebook.setVisible(false);
//                loginemaillbl.setVisible(false);
//                loginpasslbl.setVisible(false);
//                errorloginmsg.setVisible(false);
//                errormsg.setVisible(false);
//                creatnewaccountlbl.setVisible(false);
//                namelbl.setVisible(false);
//                newemaillbl.setVisible(false);
//                newpasswordlbl.setVisible(false);
//                newreenterpasswordlbl.setVisible(false);
//                birthdaylbl.setVisible(false);
//                genderlbl.setVisible(false);
//                firstnamelbl.setVisible(false);
//                lastnamelbl.setVisible(false);
//                refresh.setVisible(false);
//                creataccount.setVisible(false);
//                previousdata.setVisible(false);
//                loginemail.setVisible(false);
//                loginpassword.setVisible(false);
//                newfirstname.setVisible(false);
//                newlastname.setVisible(false);
//                newemail.setVisible(false);
//                newpassword.setVisible(false);
//                reenterpassword.setVisible(false);
//                day.setVisible(false);
//                month.setVisible(false);
//                year.setVisible(false);
//                male.setVisible(false);
//                female.setVisible(false);
//                login.setVisible(false);
//                logout.setVisible(true);
            }
        }
        if (flag == 0){
            errorloginmsg.setText("incorrect email or password");
        }
    }//GEN-LAST:event_loginActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        this.loginemail.setText("");
        this.loginpassword.setText("");
        this.newfirstname.setText("");
        this.newlastname.setText("");
        this.newemail.setText("");
        this.newpassword.setText("");
        this.reenterpassword.setText("");
        this.errorloginmsg.setText("");
        this.errormsg.setText("");
        this.day.setSelectedIndex(0);
        this.month.setSelectedIndex(0);
        this.year.setSelectedIndex(0);
        this.male.setSelected(false);
        this.female.setSelected(false);
    }//GEN-LAST:event_refreshActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
        gflag = true;
        this.female.setSelected(false);
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
        gflag = true;
        this.male.setSelected(false);
    }//GEN-LAST:event_femaleActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
//        facebook.setVisible(true);
//        loginemaillbl.setVisible(true);
//        loginpasslbl.setVisible(true);
//        errorloginmsg.setVisible(true);
//        errormsg.setVisible(true);
//        creatnewaccountlbl.setVisible(true);
//        namelbl.setVisible(true);
//        newemaillbl.setVisible(true);
//        newpasswordlbl.setVisible(true);
//        newreenterpasswordlbl.setVisible(true);
//        birthdaylbl.setVisible(true);
//        genderlbl.setVisible(true);
//        firstnamelbl.setVisible(true);
//        lastnamelbl.setVisible(true);
//        refresh.setVisible(true);
//        creataccount.setVisible(true);
//        previousdata.setVisible(true);
//        loginemail.setVisible(true);
//        loginpassword.setVisible(true);
//        newfirstname.setVisible(true);
//        newlastname.setVisible(true);
//        newemail.setVisible(true);
//        newpassword.setVisible(true);
//        reenterpassword.setVisible(true);
//        day.setVisible(true);
//        month.setVisible(true);
//        year.setVisible(true);
//        male.setVisible(true);
//        female.setVisible(true);
//        login.setVisible(true);
//        logout.setVisible(false);
//        
//        this.loginemail.setText("");
//        this.loginpassword.setText("");
//        this.newfirstname.setText("");
//        this.newlastname.setText("");
//        this.newemail.setText("");
//        this.newpassword.setText("");
//        this.reenterpassword.setText("");
//        this.errorloginmsg.setText("");
//        this.errormsg.setText("");
//        this.day.setSelectedIndex(0);
//        this.month.setSelectedIndex(0);
//        this.year.setSelectedIndex(0);
//        this.male.setSelected(false);
//        this.female.setSelected(false);
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdaylbl;
    private javax.swing.JButton creataccount;
    private javax.swing.JLabel creatnewaccountlbl;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JLabel errorloginmsg;
    private javax.swing.JLabel errormsg;
    private javax.swing.JLabel facebook;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel firstnamelbl;
    private javax.swing.JLabel genderlbl;
    private javax.swing.JLabel lastnamelbl;
    private javax.swing.JButton login;
    private javax.swing.JTextField loginemail;
    private javax.swing.JLabel loginemaillbl;
    private javax.swing.JLabel loginpasslbl;
    private javax.swing.JPasswordField loginpassword;
    private javax.swing.JButton logout;
    private javax.swing.JRadioButton male;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField newemail;
    private javax.swing.JLabel newemaillbl;
    private javax.swing.JTextField newfirstname;
    private javax.swing.JTextField newlastname;
    private javax.swing.JPasswordField newpassword;
    private javax.swing.JLabel newpasswordlbl;
    private javax.swing.JLabel newreenterpasswordlbl;
    private javax.swing.JButton previousdata;
    private javax.swing.JPasswordField reenterpassword;
    private javax.swing.JButton refresh;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
