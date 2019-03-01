package model;

import exception.*;

public class Tablero {

	
/*
 * CONSTANTES
 */
	//Direccion Nororiente.
	public final static String NO = "Nororiente";
	//Direccion Noroeste.
	public final static String NE = "Noroeste";
	//Direccion Suroriente.
	public final static String SO = "Suroriente";
	//Direccion Suroeste.
	public final static String SE = "Suroeste";
	
	//Fila 0 de la matriz.
	public final static String UP = "Arriba";
	//Ultima Columna de la matriz.
	public final static String RIGHT = "Derecho";
	//Columna 0 de la matriz.
	public final static String LEFT = "Izquierdo";
	//Ultima fila de la matriz.
	public final static String DOWN = "Abajo";
	//Define la constante fila.
	public final static String ROW = "Row"; 
	//Define la constante columna
	public final static String COLUMN = "Column";
	
	
	/**
	 * Atributos
	 */	
 // Dimension del tablero.
	private int row;
	private int column;
	private int[][] matriz; 
	
	
	/**
	 * Constructor.
	 */
	public Tablero() {
		
	}
	
	public void inicializar() {		
		row = 0;
		column = 0;
		
	}
	// Fila de la matriz.
	public int getRow() {
		return row;
	}
	// Permite cambiar la fila de la matriz.
	public void setRow(int row) throws NumberParException{
		if ((row % 2) == 0) 
			throw new NumberParException("El número debe ser impar"); 
		this.row = row;
	}
	// Columna de la matriz.
	public int getColumn() throws NumberParException{
		if ((row % 2) == 0) 
		throw new NumberParException("El número debe ser impar"); 
		return column;
	}
	// Permite cambiar la columna de la matriz.
	public void setColumn(int column) {
		this.column = column;
	}
	
	// Matriz de enteros.
	public int[][] getMatriz() {
		return matriz;
	}
	
	// Permite cambiar la matriz.
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
	
	/**
	 * Permite checkear si la dimensiones de la matriz es cuadrada.
	 * @return verdadero: si las dimensiones son iguales.
	 * false : si las dimensiones son distintas.	 	
	 */
	public boolean checkDimension() {
		return (row == column)? true:false;
	}
		
	/**
	 * Permite calcular la constante magica de la matriz, la cual es la sumatoria de las filas,
	 * columnas o diagonales.
	 * @return valor de la constante magica.
	 */
	public int magicCostan() {
		return (row *(int)((Math.pow(row, 2)+ 1)))/ 2;
	}
	
	//Establece la dimension de la matriz
	private int getDimension() {
		return (int)Math.pow(matriz.length, 2);
	}
	
	// Ubica la posicion central de la primera o ultima fila, y primera o ultima columna.
	private int getposicion() {
		return matriz.length/2;
	}
	
	//Ubica la ultima fila o columna(){
	private int getLastRoworColumn() {
		return getposicion()*2;
	}
	
	// Establece el tamaño maximo que tiene la fila y la columna.
	private int getTamahno() {
		return matriz.length-1;
	}
	
	/**
	 * Permite verificar si la suma de todas las filas o columnas son iguales, si lo son es cuadrado magico.
	 * @param posicion 
	 * @return
	 */
	public boolean checkRow_Column(String posicion ) {
		boolean perfecto = false; 
		int contador = 0;
		int suma = 0;
		int comparar = 0;
		for (int i = 0; i < matriz.length; i++) {
			suma = 0;
			for (int j = 0; j < matriz[i].length; j++) {
				if (posicion.equals("Row") ) {     
					suma += matriz[j][i];
					if(comparar == suma){
					contador++;
					}
				}else {
					suma += matriz[i][j];
					if(comparar == suma){
					contador++;
					}
				}
				
			}
			if (comparar == 0) {
				comparar = suma;
			}			
			
		}
		
		if (contador == matriz.length-1) {
			perfecto = true;
		}
		
		
		return perfecto;
	}
	
	/**
	 * Establece la coordenada inicial en la matriz.
	 * @param ubicacion primera fila(Arriba) - columna(Izquierdo) o ultima fila(Abajo) - columna(Derecho).
	 * @param direccion dirección de desplazamiento del llenado de la matriz.
	 * @throws UpAddressException lanza una excepción si la dirección de desplazamiento es diferente NE-NO.
	 * @throws RightAddressException lanza una excepción si la dirección de desplazamiento es diferente NE-SE.
	 * @throws LeftAddressException lanza una excepción si la dirección de desplazamiento es diferente NO-S0.
	 * @throws DownAddressException lanza una excepción si la dirección de desplazamiento es diferente SE-SO.
	 */
	public  void locateStart(String ubicacion,String direccion) throws UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
		
		matriz=new int[row][column];
		int contador = 0;
		// Filas.
		int i = 0;
		// Columnas
		int j = 0;
		//Verificaciones.
		// Verifica que los valores por parametros existen.
		if (ubicacion == null || direccion == null) {
			throw new CompleteFieldException("Debe completar todos los campos para generar el cuadrado magico");
		}else if(ubicacion.equals(UP)) {
			j = getposicion();
			contador += 1;
			matriz[i][j] = contador;
			
			//Permite establecer la dirrecion de llenado.
			if (direccion.equals(NO)) {
				getNorthEastDirectionUp(contador);
			}else if (direccion.equals(NE)) {
				getNorthWestDirectionUp(contador);
			}else {
				throw new UpAddressException("Los valores ingresados deben ser"+"\n"+": Nororiente o Noroeste");
			}
			
			
		}else if (ubicacion.equals(RIGHT)) {
			i = getposicion();
			j = getTamahno();
			contador += 1;
			matriz[i][j] = contador;
			
			//Permite establecer la dirrecion de llenado.
			if (direccion.equals(NE)) {
				getNorthWestDirectionRight(contador);
			}else if (direccion.equals(SE)) {
				getSouthWestDirectionRight(contador);
				
			}else {
				throw new RightAddressException("Los valores ingresados deben ser"+"\n"+": Noreste o Suroeste");
			}
			
		}else if (ubicacion.equals(LEFT)) {
			i = getposicion();
			j = 0;
			contador +=1;
			matriz[i][j] = contador;

			//Permite establecer la dirrecion de llenado.
			if (direccion.equals(NO)) {
				getNorthEastDirectionLeft(contador);
			}else if (direccion.equals(SO)) {
				getSouthEastDirectionLeft(contador);
			}else {
				throw new LeftAddressException("Los valores ingresados deben ser"+"\n"+": Nororiente o Suroriente");
			}
		}else if (ubicacion.equals(DOWN)) {
			i = getTamahno();
			j = getposicion();
			contador+=1;
			matriz[i][j] = contador;
			
			//Permite establecer la dirrecion de llenado.
			if (direccion.equals(SO)) {
				getSouthEastDirectionDown(contador);
			}else if (direccion.equals(SE)) {
				getSouthWestDirectionDown(contador);
			}else {
				throw new DownAddressException("\"Los valores ingresados deben ser"+"\n"+": Suroriente o Suroeste\"");
			}
		}
		
	}
	
	
	
	
	
	
	//Metodos de la parte superior de la matriz.
	

	
	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección nororiental desde la parte superior
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getNorthEastDirectionUp(int contador) {
		int h = 0;
		int w = getposicion();
	
		while(contador < getDimension()) {
			if((h-1) < 0 && (w-1) < 0) {
				h += 1;
				matriz[h][w] = ++contador; 
			}else if ((w-1) < 0) {
				h -= 1;
				w = getLastRoworColumn();
				matriz[h][w] = ++contador;
			}else if((h-1) < 0) {
				h = getLastRoworColumn();
				w -= 1;
				matriz[h][w] = ++contador;
			}else if (matriz[h-1][w-1] == 0) {
				h -= 1;
				w -= 1;
				matriz[h][w] = ++contador;
			}else {
				h += 1;
				matriz[h][w] = ++contador;
			}
			
		}
	}
	
	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección noroccidental desde la parte superior
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getNorthWestDirectionUp(int contador) {
		int h = 0;
		int w = getposicion();
	
		while(contador < getDimension()) {
			if ((h-1) < 0 && (w+1) > getTamahno()) {
				h += 1;
				matriz[h][w] = ++contador;
			}else if ((h-1) < 0) {
				h = getLastRoworColumn();
				w += 1;
				matriz[h][w] = ++contador;
			}else if ((w+1) > getTamahno()) {
				h -= 1; 
				w = 0;
				matriz[h][w] = ++contador;
				 
			}else if (matriz[h-1][w+1] != 0) {
				h += 1;
				matriz[h][w] = ++contador;
			}else {
				h -=1 ;
				w += 1;
				matriz[h][w] = ++contador;
			}
		}
		
	}
	
	
	// Metodos de la parte derecha de la matriz.
	
	
	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección noroccidental desde la posición lateral derecho.
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getNorthWestDirectionRight(int contador) {
		int h = getposicion();
		int w = getLastRoworColumn();
	
		while(contador < getDimension()) {
			if ((h-1) < 0 && (w+1) > getTamahno()) {
				w -= 1;
				matriz[h][w] = ++contador;
			}else if ((h-1) < 0) {
				h = getLastRoworColumn();
				w += 1;
				matriz[h][w] = ++contador;
			}else if ((w+1) > getTamahno()) {
				h -= 1; 
				w = 0;
				matriz[h][w] = ++contador;
				 
			}else if (matriz[h-1][w+1] != 0) {
				w -= 1;
				matriz[h][w] = ++contador;
			}else {
				h -=1 ;
				w += 1;
				matriz[h][w] = ++contador;
			}
		}
		
		
	}
	
	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección suroccidental desde la posición lateral derecho.
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getSouthWestDirectionRight(int contador) {
		int h = getposicion();
		int w = getLastRoworColumn();
		
		while (contador < getDimension()) {
		
			if((h+1) > getTamahno() && (w+1) > getTamahno()) {
				w -= 1;
				contador++;
				matriz[h][w] = contador;
				
			}else if((w+1) > getTamahno()) {
				h += 1;
				w = 0;
				contador++;
				matriz[h][w] = contador;					
			}else if ((h+1)> getTamahno()) {
				h = 0;
				w +=1;
				contador++;
				matriz[h][w] = contador;
			}else if(matriz[h+1][w+1] == 0) {
				h +=1;
				w +=1;
				contador++;
				matriz[h][w] = contador; 
				
			}else {
				w -=1;
				contador++;
				matriz[h][w] = contador;
			}
		}
	}
	
	// Metodos de la parte izquierda de la matriz.
	
	
	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección nororiental desde la posición lateral Izquierdo.
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getNorthEastDirectionLeft(int contador) {
		int h = getposicion();
		int w = 0;
		while(contador < getDimension()) {
			if ((h-1) < 0 && (w-1) < 0) {
				w += 1;
				matriz[h][w] = ++contador;
			}else if ((h-1) < 0) {
				h = getLastRoworColumn();
				w -= 1;
				matriz[h][w] = ++contador;
			}else if ((w-1) < 0) {
				h -=1;
				w = getLastRoworColumn();
				matriz[h][w] = ++contador;
			}else if (matriz[h-1][w-1] != 0) {
				w += 1;
				matriz[h][w] = ++contador;
			}else {
				h -= 1;
				w -= 1;
				matriz[h][w] = ++contador;
			}
		}
		
	}

	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección suroriental desde la posición lateral Izquierdo.
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getSouthEastDirectionLeft(int contador) {
		int h = getposicion();
		int w = 0;
		while(contador < getDimension()) {
		if ((h+1) > getTamahno() && (w-1) < 0) {
			w += 1;
			matriz[h][w] = ++contador;
		}else if ((h+1) > getTamahno()) {
			h = 0;
			w -= 1;
			matriz[h][w] = ++contador;
		}else if ((w-1) < 0)  {
			h += 1;
			w = getLastRoworColumn();
			matriz[h][w] = ++contador;
		}else if (matriz[h+1][w-1] == 0) {
			h += 1;
			w -= 1;
			matriz[h][w] = ++contador;
		}else {
			w+=1;
			matriz[h][w] = ++contador;
		}
		}
		
	}
	
	// Metodo de la parte inferior de la matriz.

	


	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección suroriental desde la parte inferior.
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getSouthEastDirectionDown(int contador) {
		int h = getLastRoworColumn() ;
		int w = getposicion();
		while(contador < getDimension()) {
			if((h+1) > getTamahno() && (w-1)<0) {
				h -= 1;
				contador++;
				matriz[h][w] = contador;									 
			}else if ((w-1) < 0) {
				w = getLastRoworColumn();
				h += 1;
				contador++;
				matriz[h][w] = contador;
			}else if ((h+1) > getTamahno()) {
				h = 0;
				w -= 1 ;
				contador++;
				matriz[h][w] = contador;
			}else if (matriz[h+1][w-1] != 0) {
				h -= 1;
				contador++;
				matriz[h][w] = contador;
			}else {
				h += 1;
				w -= 1;
				contador++;
				matriz[h][w] = contador;
			}
		}
	}


	/**
	 * <br>Pre:</br> El contador fue modificado (contador = 1).
	 * LLena la matriz en dirección surocciental desde la parte inferior.
	 * @param contador define la sumatoria hasta la dimensión de la matriz.
	 */
	private void getSouthWestDirectionDown(int contador) {
		int h = getLastRoworColumn();
		int w = getposicion();
	while(contador < getDimension()) {
		if((h+1) > getTamahno() && (w+1) > getTamahno()) {
			h -=1;
			contador++;
			matriz[h][w] = contador;
			
		}else if((w+1) > getTamahno()) {
			h +=1;
			w = 0;
			contador++;
			matriz[h][w] = contador;																
		}else if ((h+1) > getTamahno()) {
			h = 0;
			w += 1;
			contador++;
			matriz[h][w] = contador;
		}else if (matriz[h+1][w+1] != 0) {
			h -= 1;
			contador++;
			matriz[h][w] = contador;
		}else {
			h +=1;
			w += 1;
			contador++;
			matriz[h][w] = contador;
		}
	}
	}

	
}