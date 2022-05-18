package vista;

import java.util.Scanner;
import modelo.*;

public class PruebaBanco {

    public static void main(String[] args) {
        
        //Algunas variables a utilizar
        Banco nuevoBanco = new Banco();
        Sede sede;
        Cuenta cuenta;
        
        int opcion = 0,num1 = 0, num2;
        Scanner sc = new Scanner(System.in);
        
        //Menu continuo para crear y consultar sedes y cuentas
        while (opcion != 6){
            System.out.println("\n¿Qué desea hacer?\n");

            System.out.println("1.Crear un banco");
            System.out.println("2.Crear sedes bancarias");
            System.out.println("3.Crear cuenta");
            System.out.println("4.Consultar sedes bancarias");
            System.out.println("5.Consultar cuentas");
            System.out.println("6.Salir");

            System.out.print("\nDigite una opción (1-6): ");opcion = sc.nextInt();
            
            System.out.println();
            sc.nextLine();

            switch (opcion){
                
                case 1:
                    if(nuevoBanco.getNombre().equals("") != true){
                        System.out.println("Ya existe un banco, empiece a crear sedes o cuentas");
                    }else{
                        
                        System.out.print("Digite el nombre del banco: ");
                        nuevoBanco.setNombre(sc.nextLine());
                        System.out.print("Dirección del banco: ");
                        nuevoBanco.setDireccion(sc.nextLine());
                        System.out.print("Ciudad del banco: ");
                        nuevoBanco.setCiudad(sc.nextLine());
                    }
                    break; 
                case 2:
                    
                    if(nuevoBanco.getNombre().equals("")){
                        System.out.println("No existe un banco con el cual trabajar");
                    }else{
                        nuevoBanco.crearSede(num1, sc);
                        num1++;   
                    }
                    break;
                case 4:
                    
                    if(nuevoBanco.getNombre().equals("")){
                        System.out.println("No existe un banco en el cual consultar sedes");   
                        
                    }else if(nuevoBanco.getNumSedes() == 0){
                        System.out.println("Banco sin sedes abiertas"); //En caso tal no hay sedes
                        
                    }else{
                        
                        System.out.print("¿Qué sede desea consultar?: ");num2 = sc.nextInt();
                        
                        if(num2 > nuevoBanco.getNumSedes()){
                            System.out.println("\nNo existe la sede seleccionada"); // La sede no se ha creado
                        }else{
                            sede = nuevoBanco.seleccionarSede(num2-1);

                            System.out.println("\nNombre de la sede: "+sede.getNombre());
                            System.out.println("Ubicación: "+sede.getDireccion());
                            System.out.println("Ciudad: "+sede.getCiudad());
                        }
                    }
                    break;
                case 3:
                    
                    if(nuevoBanco.getNombre().equals("")){
                        System.out.println("No existe un banco en el cual crear cuentas");
                        
                    }else if(nuevoBanco.getNumSedes() == 0){
                        System.out.println("El banco no tiene sedes, por favor cree una");
                        
                    }else{
                        
                        System.out.print("En que sede desea crear la cuenta: ");num2 = sc.nextInt();
                        
                        if(num2 > nuevoBanco.getNumSedes()){
                            System.out.println("\nNo existe la sede seleccionada");
                        }else{
                            
                            sede = nuevoBanco.seleccionarSede(num2-1);
                            if(sede.getNumCuentas()==10){
                                System.out.println("\nLa sede ya no admite más cuentas, trate con otra");
                            }else{

                                for(int i=0;i<=sede.getNumCuentas();i++){
                                    if(sede.getCuenta(i)==null){
                                        num2 = i;
                                        break;
                                    }
                                }
                                System.out.println();
                                sede.abrirCuenta(num2, sc);
                            }                        
                        }                        
                    }
                    break;
                    
                case 5:
                    
                    if(nuevoBanco.getNombre().equals("")){
                        System.out.println("No existe un banco en el cual consultar cuentas");
                        
                    }else if(nuevoBanco.getNumSedes() == 0){
                        System.out.println("No hay sedes en el banco");
                        
                    }else{
                        System.out.print("En que sede desea consultar la cuenta: ");num2 = sc.nextInt();
                        
                        if(num2 > nuevoBanco.getNumSedes()){
                            System.out.println("\nSede inexistente en el banco");
                            
                        }else{
                            
                            sede = nuevoBanco.seleccionarSede(num2 -1);

                            if (sede.getNumCuentas() == 0){
                                System.out.println("\nSede sin cuentas abiertas"); //En caso tal no haya cuentas
                            }else{
                                System.out.print("\nCual cuenta desea consultar: ");num2 = sc.nextInt();
                                
                                if(num2 > sede.getNumCuentas()){
                                    System.out.println("\nNo existe la cuenta solicitada");
                                    
                                }else{
                                    cuenta = sede.getCuenta(num2-1);
                                    System.out.println("\nNo.Cuenta: "+cuenta.getNoCuenta());
                                    System.out.println("Tipo: "+cuenta.getTipo());
                                    System.out.println("Saldo inicial: "+cuenta.getSaldoInicial());

                                    Persona titular = cuenta.getTitular();
                                    System.out.println("Titular: "+titular.getNombre()+" "+titular.getApellido());   
                                }
                            }  
                        }
                    }
                    
                    break;
                case 6:
                    System.out.println("Hasta luego :)\n");break;
                    
                default:System.out.println("Opción invalida");
            }
        }
    }
}