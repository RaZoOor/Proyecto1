public class MRecursivo{
  //Atributos de clase
  private char[][] arreglo;
  private int areaFinal = 1;    //Inicada con 1 por el mayor numero posible si es que no existiese triangulo formado
  //Construimos la matriz para usar en esta clase
  public MRecursivo(char[][] matriz)
  {
    arreglo = matriz;
  }
  //Metodo para calcular area
  public int AreaMayor()
  {
    return areaFinal;
  }
}
