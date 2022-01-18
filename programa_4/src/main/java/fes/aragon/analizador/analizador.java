/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.analizador;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author alberto
 */
public class analizador {
       
      private String noterminales[] ={"S","A","B","C"};
      private String terminales[] = {"a","b","c","d","#"};
      private String lambda[] ={"A","A","&" };
      private String [][] tabla={
    { "A","B","error","error","error"},
    { "a","&","error","error","error"},
    { "error", "b","C","d","error"},
    { "error", "error","c","d","error"}
};      //pila  donde  estaran nuestros  estados
      private  Stack<String> pila= new Stack<String>();
      //cadena que se analizara
      
      private ArrayList<String> cadena= new ArrayList<String>();
      private ArrayList<String> cadena2= new ArrayList<String>();
      //apuntador porque necesitamos saber en donde nos encontramos
      private String topepila="";
      private String simbolo="";
      private String tablaS="";     
      private boolean banderaerror=false;
      private int Fila=0;
      private int Columna=0;
      //comparamos si llegamos a un no terminal
      private void cadena(){
          cadena.add("a");
          cadena.add("b"); 
 
          cadena.add("c");
          cadena.add("d");
          System.out.println(cadena);
          
          
      }
      private void comparaNoterminal()   {
   
     pila.push("#");
     pila.push("S");     
       
       while (topepila!="#") {  
           Fila=0;
           Columna=0;
                   
              
          
      simbolo=cadena.get(0);
  
      topepila=pila.peek();
       
          
//OBTENER LA FILA DE NUESTRA CABEZA DE LA PILA
if (topepila=="S"||topepila=="A"||topepila=="B"||topepila=="C") {
              
          
     for (int i = 0; i < noterminales.length-1; i++) {
              
            if (topepila!=noterminales[i]) {
                 Fila=Fila+1;
                 
                 
              }else
                
                break;
            
          }
}else if (topepila=="a"||topepila=="b"||topepila=="c"||topepila=="d"||topepila=="#") {
               for (int i = 0; i < terminales.length; i++) {
              
            if (topepila!=terminales[i]) {
                 Fila=Fila+1;
                 
                 
              }else
                
                break;
            
          }
}
               else if (topepila=="&") {
               for (int i = 0; i < lambda.length; i++) {
              
            if (topepila!=lambda[i]) {
                 Fila=Fila+1;
                 
                 
              }else
                
                break;
            
          }
          }
     
//obtenerr columna
    for (int i = 0; i < terminales.length; i++) {
              
            if (simbolo!=terminales[i]) {
                 Columna=Columna+1;
                 
              }else
                break;
            
          }
    //elimina el elemento de adelante para agregar el siguiente elemento de nuestra tabla
          
    //evaluación para saber si nuestro tope de la pila es igual a simbolo
       
               tablaS=tabla[Fila][Columna];
          
          if (topepila==simbolo) {
              cadena.remove(0);        
          }
          
         System.out.println(pila);
         System.out.println("el tope de la pila es"+" "+topepila);
           System.out.println("estamos en la fila"+" "+Fila);
           System.out.println("estamos en la columna"+" "+Columna); 
           System.out.println("el simbolo de la cadena es"+" "+simbolo);
          pila.pop();
          //evaluacion para saber si existe un  error
          
          if (tablaS=="error") {
          erroranalizador();
          }
          pila.push(tablaS);
         
        
           
          //agregar los elementos de la tabla
         
     
         topepila=pila.peek();
         
      

          
           if (Fila==3 && Columna==3) {
               pila.pop();
              topepila=pila.peek();
               System.out.println("La expresión es correcta");
           }
      }
      }
     private void obtenerFila()   {
         
     }
     private void obtenerColumna()   {
           }
     private void erroranalizador(){
         banderaerror=true;
         System.out.println("error");
     }
       public static void main(String[] args) {
              analizador app = new analizador();
              app.cadena();
              app.comparaNoterminal();
              
                            
    }
}
