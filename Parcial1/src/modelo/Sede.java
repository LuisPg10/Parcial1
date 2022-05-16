package modelo;

import java.util.Scanner;

public class Sede {
    
    private String nombre,direccion,ciudad;
    private final Cuenta cuenta[] = new Cuenta[10];
    private int numCuentas;
    
    public Sede(){
        this.nombre = "";
        this.direccion = "";
        this.ciudad = "";
        this.numCuentas = 0;
    }

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getDireccion(){return direccion;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public String getCiudad(){return ciudad;}
    public void setCiudad(String ciudad){this.ciudad = ciudad;}
    
    public void abrirCuenta(int numero, Scanner sc){
        
        cuenta[numero] = new Cuenta();
        
        System.out.print("Digite el número de cuenta: ");cuenta[numero].setNoCuenta(sc.nextInt());
        sc.nextLine();
        System.out.print("Digite el tipo de cuenta: ");cuenta[numero].setTipo(sc.nextLine());
        System.out.print("Con que saldo inicia la cuenta: ");cuenta[numero].setSaldoInicial(sc.nextDouble());
        
        System.out.println("\nInformación del usuario\n");
        sc.nextLine();
        cuenta[numero].setTitular(sc);
        
        this.numCuentas++;
    }
    public int getNumCuentas(){return this.numCuentas;}
    public Cuenta getCuenta(int numero){return cuenta[numero];}
}
