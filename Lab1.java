import java.util.Scanner;

public class Lab1{

  //Se usan expresiones regulares para verificar si un string esta compuesto de enteros o no, retornando un booleano
  public static boolean isNumeric(String str){
    return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese la cantidad de filas del triangulo: ");
    int verdadero = 1;
    int n = 0;  //Se le otorga un valor a las cantidad de filas para no producir un error con el resto del codigo

    //Se usa un metodo para comprobar que el valor ingresado para las filas del triangulo sea un entero
    while (verdadero == 1)
    {
      String entrada = sc.next();

      if (isNumeric(entrada) == true)
      {
        System.out.println("Entrada valida");
        n = Integer.parseInt(entrada);
        verdadero = 0;
      }

      else
      {
        System.out.println ("Entrada no valida, no introdujo un numero");
        System.out.print ("Ingrese valor valido para la cantidad de filas: ");
      }
    }

    int c = 2 * n - 1; //columnas del triangulo
    String[] triangulo = new String[n];
    //Iteracion para guardar las filas del triangulo en un arreglo String
    for (int j = 0; j < n; j++)
    {
      System.out.print("Ingrese fila " + (j+1) + ": ");
      int verdadero1 = 1;
      String auxiliar = new String();
      auxiliar = sc.next();
      int verificador = 1;

      while (verdadero1 == 1)
      {
        int verdadero2 = 1;
        //Tomamos en cuenta el largo de la fila, si corresponde o no
        if (auxiliar.length() == c && verificador == 0)
        {
          triangulo[j] = auxiliar;
          c = c - 2;
          verdadero1 = 0;
        }

        else if (auxiliar.length() != c)
        {
          System.out.println("Recuerde que el numero de elementos de esta fila corresponde a " + c);
          System.out.println("Recuerde que los elementos permitidos para la fila son - y #");
          System.out.print("Re-Ingrese fila " + (j+1) + ": ");
          verificador = 1;
          auxiliar = sc.next();
        }
        //Tomaeremos cada elemento de esta fila y comprobaremos que sean solo - y #
        else
        {
          while (verdadero2 == 1)
          {
            int cont = 0;
            for (int pos = 0; pos < c; pos++)
            {
                char[] auxiliar2 = auxiliar.toCharArray();
                if (auxiliar2[pos] != '-' && auxiliar2[pos] != '#')
                {
                  System.out.println("Recuerde que el numero de elementos de esta fila corresponde a " + c);
                  System.out.println("Recuerde que los elementos permitidos para la fila son - y #");
                  System.out.print("Re-Ingrese fila " + (j+1) + ": ");
                  auxiliar = sc.next();
                  break;
                }
                else cont++;
            }
            if (cont == c)
            {
              verdadero2 = 0;
              verificador = 0;
            }
            else verdadero2 = 0;
          }
        }
      }
    }
    //Se crea una matriz de n x 2n-1 llena de " " (space) para luego rellenar con lo capturado por consola
    char[][] matrizTriangulo = new char[n][(2*n-1)];
    for (int i = 0; i < n; i++)
    {
      for (int i2 = 0; i2 < (2*n-1); (i2)++)
          matrizTriangulo[i][i2] = ' ';
    }
    //Recorremos este arreglo agregandole los elementos capturados previamente
    for (int x = 0; x < n; x++)
    {
      char[] aux = triangulo[x].toCharArray();                          //Transformar el string a un arreglo de caracteres

      for (int x2 = 0; x2 < triangulo[x].length(); (x2)++)
      {
        int aux1 = (2*n - 1) - triangulo[x].length();
        matrizTriangulo[x][(aux1)/2 + x2] = aux[x2];
      }
    }
    //Mostrar por pantalla figura ingresada por el usuario
    System.out.println("\n---Figura formada---");
    for (int ii = 0; ii < n; ii++)
      System.out.println(matrizTriangulo[ii]);
    System.out.println("--------------------\n");

    MRecursivo instanciaRecursiva = new MRecursivo(matrizTriangulo);

    System.out.print("Modo recursivo: ");
    int a = instanciaRecursiva.AreaMayor();
    System.out.println("El triangulo mas grande posee un area de " + a);

    MIterativo instanciaIterativa = new MIterativo(matrizTriangulo);

    System.out.print("Modo Iterativo: ");
    int b = instanciaIterativa.AreaMayor();
    System.out.println("El triangulo mas grande posee un area de " + b);
  }
}
