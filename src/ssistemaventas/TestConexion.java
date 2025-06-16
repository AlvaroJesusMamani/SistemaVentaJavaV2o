/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ssistemaventas;

import modelo.Conexion;

/**
 *
 * @author Alvaro Jesus Cahuapaza
 */
public class TestConexion {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.getConnection();
    }
}
