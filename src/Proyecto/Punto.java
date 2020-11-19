/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

public class Punto {
    private int x;
    private int y;
    
    /**
     *  Generar un punto en las coordenadas (0,0)
     */
    public Punto() {
        this.x = 0;
        this.y = 0;
        
    }

    /**
     * Generar un punto en las coordenadas (x,y)
     * @param x coordenada en x del punto
     * @param y coordenada en x del punto
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     *  Asignar valor de la coordenada x
     * @param x coordenada en x
     */
    public void setX(int x){
        this.x = x;
    }

    
    /**
     * Obtener el valor de la coordenada en x
     * @return coordenada en x del punto
     */
    public int getX() {
        return this.x;
    }
    
     /**
     *  Asignar valor de la coordenada y
     * @param y coordenada en y
     */
    public void setY(int y){
        this.y = y;
    }

    
    /**
     * Obtener el valor de la coordenada en y
     * @return coordenada en y del punto
     */
    public int getY() {
        return this.y;
    }
    
    
    
}