/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Eduar
 */
public class Ventana extends JPanel implements ActionListener,MouseListener,KeyListener{
    // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    
    
    // declarar la figura
    private Punto[] figura, figuraOriginal;
    
    private JMenuBar barra;
    private JMenu menu_Transformaciones;
    private JMenuItem item_Escalar, item_Traslacion, item_Rotacion1, item_Rotacion2;
    private JMenuItem item_ReflejarX, item_ReflejarY, item_ReflejarXY, item_Deformar, item_Redibujar;
    
    private JButton btn_Escalar, btn_Trasladar, btn_Rotacion1, btn_Rotacion2;
    private JButton btn_ReflejarX, btn_ReflejarY, btn_ReflejarXY, btn_Deformar, btn_Redibujar;
    
     public Ventana(String titulo, Proyecto.Punto[] figura) {
         
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(1000, 600);
         //Menu
        barra  = new JMenuBar();
        menu_Transformaciones = new JMenu("Transformaciones");
        item_Escalar = new JMenuItem("Escalar");
        item_Traslacion = new JMenuItem("Traslación");
        item_Rotacion1 = new JMenuItem("Rotación 1");
        item_Rotacion2 = new JMenuItem("Rotación 2");
        item_ReflejarX = new JMenuItem("ReflejarX");
        item_ReflejarY = new JMenuItem("ReflejarY");
        item_ReflejarXY = new JMenuItem("ReflejarXY");
        item_Deformar = new JMenuItem("Deformar");
        item_Redibujar = new JMenuItem("Redibujar");
        
        //Botones
        btn_Escalar = new JButton("Escalar");
        btn_Trasladar = new JButton("Traslación");
        btn_Rotacion1 = new JButton("Rotación1");
        btn_Rotacion2 = new JButton("Rotación2");
        btn_ReflejarX = new JButton("ReflejarX");
        btn_ReflejarY = new JButton("ReflejarY");
        btn_ReflejarXY = new JButton("ReflejarXY");
        btn_Deformar = new JButton("Deformar");
        btn_Redibujar = new JButton("Redibujar");
        
//        eR = new EventosDeRaton();
//         this.addMouseListener(eR);
        //Se agrega la barra a la ventana
        this.add(barra);
        //Agregamos el boton a la ventana
        this.add(btn_Escalar);
        this.add(btn_Trasladar);
        this.add(btn_Rotacion1);
        this.add(btn_Rotacion2);
        this.add(btn_ReflejarX);
        this.add(btn_ReflejarY);
        this.add(btn_ReflejarXY);
        this.add(btn_Deformar);
        this.add(btn_Redibujar);
        
        //Agregamos a la barra el menu de transformaciones
        barra.add(menu_Transformaciones);
        //Agregamos al menu de transformaciones cada uno de los items
        menu_Transformaciones.add(item_Escalar);
        menu_Transformaciones.add(item_Traslacion);
        menu_Transformaciones.add(item_Rotacion1);
        menu_Transformaciones.add(item_Rotacion2);
        menu_Transformaciones.add(item_ReflejarX);
        menu_Transformaciones.add(item_ReflejarY);
        menu_Transformaciones.add(item_ReflejarXY);
        menu_Transformaciones.add(item_Deformar);
        menu_Transformaciones.add(item_Redibujar);
        //Agregamos los escuchas a cada Item
        item_Escalar.addActionListener(this);
        item_Traslacion.addActionListener(this);
        item_Rotacion1.addActionListener(this);
        item_Rotacion2.addActionListener(this);
        item_ReflejarX.addActionListener(this);
        item_ReflejarY.addActionListener(this);
        item_ReflejarXY.addActionListener(this);
        item_Deformar.addActionListener(this);
        item_Redibujar.addActionListener(this);
        //Agregamos los escuchas a los botones
        btn_Escalar.addActionListener(this);
        btn_Trasladar.addActionListener(this);
        btn_Rotacion1.addActionListener(this);
        btn_Rotacion2.addActionListener(this);
        btn_ReflejarX.addActionListener(this);
        btn_ReflejarY.addActionListener(this);
        btn_ReflejarXY.addActionListener(this);
        btn_Deformar.addActionListener(this);
        btn_Redibujar.addActionListener(this);
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(1000, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
         //definiendo la figura
        this.figura = figura;
        figuraOriginal = figura;
        
        
        this.addMouseListener(this);
        ventana.addKeyListener(this);
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        
        
        
        
        
    }
     
     public void redibujar(Punto [] figura){
        this.figura = figura;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // dibujar la figura
        this.dibujar(g);

        
    }
    
    
    
    
    public void dibujar(Graphics g){
        for (int i = 0; i < this.figura.length - 1; i++) {
            g.drawLine(
                    figura[i].getX(), 
                    figura[i].getY(), 
                    figura[i+1].getX(), 
                    figura[i+1].getY()
            );
        }
    } 
    
    private void escalar(double fx, double fy){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            //nuevax:
            //nuevay:
            punto.setX(
                    (int)((punto.getX()- tx)*fx)+ tx
            );
            punto.setY(
                    (int)((punto.getY()- ty)*fy)+ ty
            );
        }
    }
    
    private void traslacion(double Xf, double Yf){
        for (Punto punto : figura) {
            //nueva x:a + xf
            //nueva y:b + yf
            punto.setX(
                    (int)(punto.getX()+ Xf)
            );
            punto.setY(
                    (int)(punto.getY()+Yf)
            );
        }
    }
    
    private void rotacion1(double ang){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        //nueva x: (a - tx) * cos – (b – ty) * sin + tx
        //nueva y: (a - ty) * sin + (b – ty) * cos + ty
        for (Punto punto : figura) {
            punto.setX((int)(((punto.getX() - tx)*Math.cos(Math.toRadians(ang)))-((punto.getY()-ty)*Math.sin(Math.toRadians(ang)))+tx));
            //punto y
            punto.setY((int)(((punto.getX() - ty)*Math.sin(Math.toRadians(ang)))+((punto.getY()-ty)*Math.cos(Math.toRadians(ang)))+ty));
        }
        
    }
    
    private void rotacion2(double ang){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        //nueva x: (a - tx) * cos + (b – ty) * sin + tx
        //nueva y: (-(a - ty) * sin + (b – ty) * cos )+ ty
        for (Punto punto : figura) {
            punto.setX((int)(((punto.getX() - tx)*Math.cos(Math.toRadians(ang)))+((punto.getY()-ty)*Math.sin(Math.toRadians(ang)))+tx));
            //punto y
            punto.setY((int)(-((punto.getX() - tx)*Math.sin(Math.toRadians(ang)))+((punto.getY()-ty)*Math.cos(Math.toRadians(ang)))+ty));
        }
    }
    
    private void reflejarX(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        
        for (Punto punto : figura) {
            punto.setX(
                    (int)(-(punto.getX() - tx) + tx)
            );
            punto.setY(
                    (int)((punto.getY() - ty) + ty)
            );
        }
    }
    
    private void reflejarY(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        
        for (Punto punto : figura) {
            punto.setX(
                    (int)((punto.getX() - tx) + tx)
            );
            punto.setY(
                    (int)(-(punto.getY() - ty) + ty)
            );
        }
    }
    
    private void reflejarXY(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        
        for (Punto punto : figura) {
            punto.setX(
                    (int)(-(punto.getX() - tx) + tx)
            );
            punto.setY(
                    (int)(-(punto.getY() - ty) + ty)
            );
        }
    }
    
    private void deformacionSobreUnPunto(double dx, double dy){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        
        for (Punto punto : figura) {
            //nuevax:
            //nuevay:
            punto.setX(
                    (int)((((punto.getX()- tx))+((punto.getY()-ty)*dx))+tx)
            );
            punto.setY(
                    (int)((((punto.getX()- ty)*dy)+((punto.getY()-ty)))+tx)
            );
        }
        
    }

    //Estos son los métodos que vienen de ActionListener y se usan para las los botones y la barra de menú
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item_Escalar) {
            this.escalar(
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de fx")), 
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de fy"))
            );
            ventana.repaint();
        }
        
        if (e.getSource() == item_Traslacion) {
            this.traslacion(
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de fx")), 
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de fy"))
            );
            ventana.repaint();
        }
        
        if (e.getSource() == item_Rotacion1) {
            this.rotacion1(
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresa los grados a rotar"))
            );
            ventana.repaint();
        }
        
        if (e.getSource() == item_Rotacion2) {
            this.rotacion2(
                     Double.parseDouble(JOptionPane.showInputDialog("Ingresa los grados a rotar"))
            );
            ventana.repaint();
        }
        
        if (e.getSource() == item_ReflejarX) {
            this.reflejarX();
            ventana.repaint();
        }
        
        if (e.getSource() == item_ReflejarY) {
            this.reflejarY();
            ventana.repaint();
        }
        
        if (e.getSource() == item_ReflejarXY) {
            this.reflejarXY();
            ventana.repaint();
        }
        if (e.getSource() == item_Deformar) {
            this.deformacionSobreUnPunto(
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de dx")), 
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de dy"))
            );
            ventana.repaint();
        }
        
        if (e.getSource() == item_Redibujar) {
            Punto figura[] = {
                       
            //1
            new Punto(370,228),
            //2
            new Punto(380,218),
            //3
            new Punto(390,203),
            //4
            new Punto(400,188),
            //6
            new Punto(410,163),
            //7
            new Punto(445,183),
            //8
            new Punto(455,188),
            //9
            new Punto(470,193),
            //10
            new Punto(485,193),
            //11
            new Punto(500,193),
            //12
            new Punto(500,178),
            //13
            new Punto(495,158),
            //14
            new Punto(505,168),
            //15
            new Punto(510,163),
            //16
            new Punto(515,163),
            //17
            new Punto(520,158),
            //18
            new Punto(520,148),
            //19
            new Punto(530,168),
            //20
            new Punto(535,173),
            //21
            new Punto(545,163),
            //22
            new Punto(555,143),
            //23
            new Punto(565,123),
            //24
            new Punto(570,103),
            //25
            new Punto(570,83),
            //26
            new Punto(580,88),
            //27
            new Punto(600,88),
            //28
            new Punto(615,88),
            //29
            new Punto(625,88),
            //30
            new Punto(635,83),
            //31
            new Punto(630,93),
            //32
            new Punto(620,113),
            //33
            new Punto(615,133),
            //34
            new Punto(600,138),
            //35
            new Punto(590,148),
            //36
            new Punto(585,158),
            //37
            new Punto(580,178),
            //38
            new Punto(580,198),
            //39
            new Punto(570,203),
            //40
            new Punto(560,213),
            //41
            new Punto(550,223),
            //42
            new Punto(545,233),
            //43
            new Punto(540,253),
            //44
            new Punto(530,243),
            //45
            new Punto(510,233),
            //46
            new Punto(505,233),
            //47
            new Punto(485,238),
            //48
            new Punto(475,248),
            //49
            new Punto(465,238),
            //50
            new Punto(455,228),
            //51
            new Punto(450,223),
            //52
            new Punto(445,223),
            //53
            new Punto(440,223),
            //54
            new Punto(435,228),
            //55
            new Punto(420,238),
            //56
            new Punto(415,238),
            //57
            new Punto(395,228),
            //58
            new Punto(385,223),
            //59
            new Punto(380,223),
            // 1 de nuevo
            new Punto(370,228)};
            this.redibujar(figura);
            ventana.repaint();
        }
        
        if (e.getSource() == btn_Escalar) {
            this.escalar(0.5,0.5);
            ventana.repaint();
        }
        
        if (e.getSource() == btn_Trasladar) {
            this.traslacion(20,20);
            ventana.repaint();
        }
        
        if (e.getSource() == btn_Rotacion1) {
            this.rotacion1(15);
            ventana.repaint();
        }
        
        if (e.getSource() == btn_Rotacion2) {
            this.rotacion2(15);
            ventana.repaint();
        }
        
        if (e.getSource() == btn_ReflejarX) {
            this.reflejarX();
            ventana.repaint();
        }
        
        if (e.getSource() == btn_ReflejarY) {
            this.reflejarY();
            ventana.repaint();
        }
        
        if (e.getSource() == btn_ReflejarXY) {
            this.reflejarXY();
            ventana.repaint();
        }
        if (e.getSource() == btn_Deformar) {
            this.deformacionSobreUnPunto(0.1,0.1);
            ventana.repaint();
        }
        if (e.getSource() == btn_Redibujar) {
            Punto figura[] = {
                       
            //1
            new Punto(370,228),
            //2
            new Punto(380,218),
            //3
            new Punto(390,203),
            //4
            new Punto(400,188),
            //6
            new Punto(410,163),
            //7
            new Punto(445,183),
            //8
            new Punto(455,188),
            //9
            new Punto(470,193),
            //10
            new Punto(485,193),
            //11
            new Punto(500,193),
            //12
            new Punto(500,178),
            //13
            new Punto(495,158),
            //14
            new Punto(505,168),
            //15
            new Punto(510,163),
            //16
            new Punto(515,163),
            //17
            new Punto(520,158),
            //18
            new Punto(520,148),
            //19
            new Punto(530,168),
            //20
            new Punto(535,173),
            //21
            new Punto(545,163),
            //22
            new Punto(555,143),
            //23
            new Punto(565,123),
            //24
            new Punto(570,103),
            //25
            new Punto(570,83),
            //26
            new Punto(580,88),
            //27
            new Punto(600,88),
            //28
            new Punto(615,88),
            //29
            new Punto(625,88),
            //30
            new Punto(635,83),
            //31
            new Punto(630,93),
            //32
            new Punto(620,113),
            //33
            new Punto(615,133),
            //34
            new Punto(600,138),
            //35
            new Punto(590,148),
            //36
            new Punto(585,158),
            //37
            new Punto(580,178),
            //38
            new Punto(580,198),
            //39
            new Punto(570,203),
            //40
            new Punto(560,213),
            //41
            new Punto(550,223),
            //42
            new Punto(545,233),
            //43
            new Punto(540,253),
            //44
            new Punto(530,243),
            //45
            new Punto(510,233),
            //46
            new Punto(505,233),
            //47
            new Punto(485,238),
            //48
            new Punto(475,248),
            //49
            new Punto(465,238),
            //50
            new Punto(455,228),
            //51
            new Punto(450,223),
            //52
            new Punto(445,223),
            //53
            new Punto(440,223),
            //54
            new Punto(435,228),
            //55
            new Punto(420,238),
            //56
            new Punto(415,238),
            //57
            new Punto(395,228),
            //58
            new Punto(385,223),
            //59
            new Punto(380,223),
            // 1 de nuevo
            new Punto(370,228)};
            this.redibujar(figura);
            ventana.repaint();
        }
    }

    
    //Estos son los métodos que vienen desde MouseListener y se usan para los eventos del mouse
    @Override
    public void mouseClicked(MouseEvent me) {
       
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
           this.traslacion(-50, 0);
           ventana.repaint();
    }
        
        if (me.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
            this.traslacion(50, 0);
            ventana.repaint();
        }
        
        if (me.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
            this.rotacion1(10);
            ventana.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        char codigo = ke.getKeyChar();
        
        
        if (ke.getKeyChar() == 't') {
            this.traslacion(30,30);
            ventana.repaint();
        }
        
        if (codigo == 'r') {
            this.rotacion1(1);
            ventana.repaint();
        }
        
        
        if (codigo == 'x') {
            this.reflejarX();
            ventana.repaint();
        }
        
        if (codigo == 'y') {
            this.reflejarY();
            ventana.repaint();
        }
        
        if (codigo == 'd') {
            this.deformacionSobreUnPunto(0.2,0.2);
            ventana.repaint();
        }
    }
    //Por último tenemos los métdos que vienen de KeyListener y que utilizamos para los eventos del teclado
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            this.escalar(1.5,1.5);
            ventana.repaint();
        }
        
        else if (ke.isAltDown() && ke.getKeyChar()!='r' && ke.getKeyCode() == KeyEvent.VK_R) {
            this.rotacion2(1);
            ventana.repaint();
        }
        
         else if (ke.isShiftDown() && ke.getKeyChar()!='x' && ke.getKeyCode() == KeyEvent.VK_X) {
            this.reflejarXY();
            ventana.repaint();
        }
        
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            Punto figura[] = {
                       
            //1
            new Punto(370,228),
            //2
            new Punto(380,218),
            //3
            new Punto(390,203),
            //4
            new Punto(400,188),
            //6
            new Punto(410,163),
            //7
            new Punto(445,183),
            //8
            new Punto(455,188),
            //9
            new Punto(470,193),
            //10
            new Punto(485,193),
            //11
            new Punto(500,193),
            //12
            new Punto(500,178),
            //13
            new Punto(495,158),
            //14
            new Punto(505,168),
            //15
            new Punto(510,163),
            //16
            new Punto(515,163),
            //17
            new Punto(520,158),
            //18
            new Punto(520,148),
            //19
            new Punto(530,168),
            //20
            new Punto(535,173),
            //21
            new Punto(545,163),
            //22
            new Punto(555,143),
            //23
            new Punto(565,123),
            //24
            new Punto(570,103),
            //25
            new Punto(570,83),
            //26
            new Punto(580,88),
            //27
            new Punto(600,88),
            //28
            new Punto(615,88),
            //29
            new Punto(625,88),
            //30
            new Punto(635,83),
            //31
            new Punto(630,93),
            //32
            new Punto(620,113),
            //33
            new Punto(615,133),
            //34
            new Punto(600,138),
            //35
            new Punto(590,148),
            //36
            new Punto(585,158),
            //37
            new Punto(580,178),
            //38
            new Punto(580,198),
            //39
            new Punto(570,203),
            //40
            new Punto(560,213),
            //41
            new Punto(550,223),
            //42
            new Punto(545,233),
            //43
            new Punto(540,253),
            //44
            new Punto(530,243),
            //45
            new Punto(510,233),
            //46
            new Punto(505,233),
            //47
            new Punto(485,238),
            //48
            new Punto(475,248),
            //49
            new Punto(465,238),
            //50
            new Punto(455,228),
            //51
            new Punto(450,223),
            //52
            new Punto(445,223),
            //53
            new Punto(440,223),
            //54
            new Punto(435,228),
            //55
            new Punto(420,238),
            //56
            new Punto(415,238),
            //57
            new Punto(395,228),
            //58
            new Punto(385,223),
            //59
            new Punto(380,223),
            // 1 de nuevo
            new Punto(370,228)};
            this.redibujar(figura);
            ventana.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
   
}

