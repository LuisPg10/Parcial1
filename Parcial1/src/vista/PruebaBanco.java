package vista;

import java.util.Scanner;
import modelo.*;

public class PruebaBanco {

    public static void main(String[] args) {
        
        //Algunas variables a utilizar
        Banco nuevoBanco = new Banco("Banco Popular", "Calle 44 # 12a-55", "Valledupar");
        int opcion = 0,num1 = 0, num2;
        Scanner sc = new Scanner(System.in);
        Sede sede;

        //MENU
        System.out.println("Bienvenido al Banco " + nuevoBanco.getNombre());
        
        //Menu continuo para crear y consultar sedes y cuentas
        while (opcion != 4){
            System.out.println("\n¿Qué desea hacer?\n");

            System.out.println("1.Abrir una sede");
            System.out.println("2.Consultar una sede");
            System.out.println("3.Abrir una cuenta en sede");
            System.out.println("4.Salir");

            System.out.print("\nDigite una opción (1-4): ");opcion = sc.nextInt();

            System.out.println();
            sc.nextLine();

            switch (opcion){

                case 1:
                    nuevoBanco.crearSede(num1, sc);
                    num1++;
                    break;
                case 2:
                    
                    if(nuevoBanco.getNumSedes() == 0){
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

                            if (sede.getNumCuentas() == 0){
                                System.out.println("\nSede sin cuentas abiertas"); //En caso tal no haya cuentas
                            }else{
                                System.out.println("\nCuentas abiertas en esta sede: " +sede.getNumCuentas());

                                for (int i = 0; i < sede.getNumCuentas(); i++){
                                    Cuenta cuenta = sede.getCuenta(i);

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
                case 3:
                    if(nuevoBanco.getNumSedes() == 0){
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
                    
                case 4:
                    System.out.println("Hasta luego :)\n");
                    break;
                    
                default:System.out.println("Opción invalida");
            }
        }
    }
}