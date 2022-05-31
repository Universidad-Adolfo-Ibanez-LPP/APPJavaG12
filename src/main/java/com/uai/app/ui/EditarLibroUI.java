package com.uai.app.ui;


import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.builders.LibroBuilder;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class EditarLibroUI extends UAIJFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton editarButton;
    private JPanel Panel;
    private JLabel Titulo;
    private JButton buscarButton;
    private JPanel Panel2;
    private JTextField buscartit;
    private JLabel buscartitulo;
    private JLabel autorLabel;
    private JButton editarButton2;


    public EditarLibroUI(String title) {
        super(title);
        this.setMainPanel(Panel);
                editarButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {


                                String tit = textField1.getText();
                                String aut = textField7.getText();
                                String est = textField5.getText();
                                String edi = textField3.getText();
                                String sed = textField2.getText();
                                int enu = Integer.parseInt(textField6.getText());
                                int pis = Integer.parseInt(textField4.getText());

                                HashSet<Libro> data = DataManager.getInstance().getData();

                                for (Libro d:data){
                                    if (d.getTitulo().equals(tit)){
                                        data.remove(d);
                                        LibroBuilder le = new LibroBuilder();
                                        Libro book = (le.build(aut,enu,est,tit,pis,edi,sed));
                                        dispose();
                                        DataManager.getInstance().agregarLibro(book);
                                        dispose();
                                    }
                                    else {}

                                } }




                        });}


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }}










