package com.uai.app.ui;


import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;
import com.uai.app.ui.utils.UIBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class EditarLibroVentana extends UAIJFrame {


    private JButton buscarButton;
    private JLabel Titulo2;
    private JTextField textField1;
    private JPanel PanelVentana;
    private JTextField Buscartitu;
    private JButton buscarButton3;
    private JButton editarButton2;


    public EditarLibroVentana(String title) {
        super(title);
        this.setMainPanel(PanelVentana);

        buscarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tit = Buscartitu.getText();

                HashSet<Libro> data = DataManager.getInstance().getData();

                int existe = 0;
                for (Libro d: data){
                    if (d.getTitulo().equals(tit)){
                        existe++;
                    }}

                if(existe==1){
                    buscarButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            UIBuilder.buildUI(EditarLibroUI.class);
                            dispose();
                        }
                    });
                }
                else{JFrame error= new JFrame();
                    JOptionPane.showMessageDialog(error,"¡no se encontro el libro!");
                }
            }
        });
    }
}

