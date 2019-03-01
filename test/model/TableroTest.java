package model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import exception.CompleteFieldException;
import exception.DownAddressException;
import exception.LeftAddressException;
import exception.NumberParException;
import exception.RightAddressException;
import exception.UpAddressException;

class TableroTest {
	
	private Tablero tab;
	private static final int MAGIC_CONSTAN_3_3 = 15 ;
	private static final int MAGIC_CONSTAN_5_5 = 65;
	private static final int MAGIC_CONSTAN_7_7 = 175;
	private static final int MAGIC_CONSTAN_9_9 = 369;
	private void setupEscenary1()
	{
		try {
			
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(3);
			tab.setColumn(3);
			tab.locateStart(Tablero.UP, Tablero.NE);
	
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
		
	}
	
	private void setupEscenary2() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(5);
			tab.setColumn(5);
			tab.locateStart(Tablero.UP, Tablero.NO);
		
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	
	private void setupEscenary3() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(7);
			tab.setColumn(7);
			tab.locateStart(Tablero.RIGHT, Tablero.NE);
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenary4() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(3);
			tab.setColumn(3);
			tab.locateStart(Tablero.RIGHT, Tablero.SE);
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenary5() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(5);
			tab.setColumn(5);
			tab.locateStart(Tablero.DOWN,Tablero.SO);
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenary6() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(9);
			tab.setColumn(9);
			tab.locateStart(Tablero.DOWN, Tablero.SE);
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenary7() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(5);
			tab.setColumn(5);
			tab.locateStart(Tablero.LEFT,Tablero.NO);
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenary8() {
		try {
			tab = new Tablero();
			tab.inicializar();
			tab.setRow(7);
			tab.setColumn(7);
			tab.locateStart(Tablero.LEFT, Tablero.SO);
		} catch (NumberParException e) {
			e.printStackTrace();
		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenary9() throws NumberParException, UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
		tab = new Tablero();
		tab.inicializar();
		tab.setRow(2);
		tab.setColumn(2);
		tab.locateStart(Tablero.UP, Tablero.NE);
		
	}
	
	private void setupEscenary10() throws UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException, NumberParException {
		tab = new Tablero();
		tab.inicializar();
		tab.setRow(7);
		tab.setColumn(7);
		tab.locateStart(Tablero.UP, Tablero.SE);
	}
	
	
	private void setupEscenary11() throws NumberParException, UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
		tab = new Tablero();
		tab.inicializar();
		tab.setRow(5);
		tab.setColumn(5);
		tab.locateStart(Tablero.RIGHT, Tablero.NO);
		
	}
	
	
	private void setupEscenary12() throws NumberParException, UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
		tab = new Tablero();
		tab.inicializar();
		tab.setRow(3);
		tab.setColumn(3);
		tab.locateStart(Tablero.LEFT, Tablero.SE);
	}
	
	
	private void setupEscenary13() throws NumberParException, UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
		tab = new Tablero();
		tab.inicializar();
		tab.setRow(9);
		tab.setColumn(9);
		tab.locateStart(Tablero.DOWN, Tablero.NE);
	}
	
	
	
	@Test
	public void checkTopNE(){
		setupEscenary1();
		int[][] matriz = {	{8,1,6},
							{3,5,7},
							{4,9,2}};
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				assertEquals(matriz[i][j], tab.getMatriz()[i][j]);
			}
		}
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		assertEquals(MAGIC_CONSTAN_3_3,tab.magicCostan());
	}
	
	@Test 
	public void checkTopNO() {
		setupEscenary2();
		int [][] matriz = { {15,8,1,24,17},
							{16,14,7,5,23},
							{22,20,13,6,4},
							{3,21,19,12,10},
							{9,2,25,18,11}	};
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				assertEquals(matriz[i][j], tab.getMatriz()[i][j]);
			}
		}
		
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		assertEquals(MAGIC_CONSTAN_5_5,tab.magicCostan());
	} 
	
	
	@Test
	public void checkRightNE_SE() {
        // Verifica si la dirección de llenado es igual a la matriz resultante por pantalla
		// en este caso desplazamiento Noreste.
		setupEscenary3();
		int [][] matriz = {	{20,12,4,45,37,29,28},
							{11,3,44,36,35,27,19},
							{2,43,42,34,26,18,10},
							{49,41,33,25,17,9,1},
							{40,32,24,16,8,7,48},
							{31,23,15,14,6,47,39},
							{22,21,13,5,46,38,30} };
		assertArrayEquals("El metodo de llenado del cuadrado magico es incorrecto o verifique que los"
				+ "valores esten en la ubicación correcta",matriz, tab.getMatriz());
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		assertEquals(MAGIC_CONSTAN_7_7, tab.magicCostan());
		
		// Verifica si la dirección de dezplazamiento es surEste y es igual a la matriz resultante.
		setupEscenary4();		
		int [][] matriz2 = { {4,3,8},
							 {9,5,1},
							 {2,7,6} };
		assertArrayEquals("El metodo de llenado del cuadrado magico es incorrecto o verifique que los"
				+ "valores esten en la ubicación correcta",matriz2, tab.getMatriz());
//		Verifica si la suma de las filas y columnas son iguales y en consecuencia son cuadrados magicos.
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		assertEquals(MAGIC_CONSTAN_3_3, tab.magicCostan());
		
	}


	@Test
	public void checkDownSO_SE() {
		setupEscenary5();
		 // Verifica si la dirección de llenado es igual a la matriz resultante por pantalla
		// en este caso desplazamiento Suroriente.
		int[][] matriz = { {9,2,25,18,11},
							{3,21,19,12,10},
							{22,20,13,6,4},
							{16,14,7,5,23},
							{15,8,1,24,17} };
		assertArrayEquals("El metodo de llenado del cuadrado magico es incorrecto o verifique que los"
				+ "valores esten en la ubicación correcta",matriz, tab.getMatriz());
		// Verifica que la suma de las filas y columnas son iguales, y en consecuencia es un cuadrado magico 
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		//Verifica si la constante magica es la correcta.
		assertEquals(MAGIC_CONSTAN_5_5, tab.magicCostan());
							
		setupEscenary6();
		// Verifica si la dirección de llenado es igual a la matriz resultante por pantalla
		// en este caso desplazamiento Suroeste.
		
		int[][] matriz2 = { {37,48,59,70,81,2,13,24,35},
				  		   {36,38,49,60,71,73,3,14,25},
				  		   {26,28,39,50,61,72,74,4,15},
				  		   {16,27,29,40,51,62,64,75,5},
				  		   {6,17,19,30,41,52,63,65,76},
				  		   {77,7,18,20,31,42,53,55,66},
				  		   {67,78,8,10,21,32,43,54,56},
				  		   {57,68,79,9,11,22,33,44,46},
				  		   {47,58,69,80,1,12,23,34,45}				  		   
				  		   };
		
		assertArrayEquals("El metodo de llenado del cuadrado magico es incorrecto o verifique que los"
				+ "valores esten en la ubicación correcta",matriz2, tab.getMatriz());
		// Verifica que la suma de las filas y columnas son iguales, y en consecuencia es un cuadrado magico 
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		//Verifica si la constante magica es la correcta.
		assertEquals(MAGIC_CONSTAN_9_9, tab.magicCostan());
	
	}
	
	@Test
	public void checkLeftNO_SO() {
		// Verifica si la dirección de llenado es igual a la matriz resultante por pantalla
		// en este caso desplazamiento Nororiente.
		setupEscenary7();
		int matriz[][] = {{15,16,22,3,9},
						  {8,14,20,21,2},
						  {1,7,13,19,25},
						  {24,5,6,12,18},
						  {17,23,4,10,11}
						  };
		assertArrayEquals("El metodo de llenado del cuadrado magico es incorrecto o verifique que los"
				+ "valores esten en la ubicación correcta",matriz, tab.getMatriz());
		// Verifica que la suma de las filas y columnas son iguales, y en consecuencia es un cuadrado magico 
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		//Verifica si la constante magica es la correcta.
		assertEquals(MAGIC_CONSTAN_5_5, tab.magicCostan());
		
		// Verifica si la dirección de llenado es igual a la matriz resultante por pantalla
		// en este caso desplazamiento Suroriente.
		setupEscenary8();
		
		int[][] matriz2 = {	{30,38,46,5,13,21,22},
							{39,47,6,14,15,23,31},
							{48,7,8,16,24,32,40},
							{1,9,17,25,33,41,49},
							{10,18,26,34,42,43,2},
							{19,27,35,36,44,3,11},
							{28,29,37,45,4,12,20}								
							};
		
		assertArrayEquals("El metodo de llenado del cuadrado magico es incorrecto o verifique que los"
				+ "valores esten en la ubicación correcta",matriz2, tab.getMatriz());
		// Verifica que la suma de las filas y columnas son iguales, y en consecuencia es un cuadrado magico 
		assertTrue(tab.checkRow_Column(Tablero.ROW));
		assertTrue(tab.checkRow_Column(Tablero.COLUMN));
		//Verifica si la constante magica es la correcta.
		assertEquals(MAGIC_CONSTAN_7_7, tab.magicCostan());
		
 	}

	@Test
	public void checkNumberParException() {
		try {
			setupEscenary9();
			fail("Se espera una expecion de NumberParException");
		} catch (NumberParException | UpAddressException | RightAddressException | LeftAddressException
				| DownAddressException | CompleteFieldException e) {
	
		}
	}
	
	@Test
	public void checkUpAddressException() {
		
		try {
			setupEscenary10();
			fail("Se espera una expecion de UpAddressException");

		} catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException
				| CompleteFieldException | NumberParException e) {
	
		}
	}
	
	
	@Test
	public void checkRightAddressException() {
		try {
			setupEscenary11();
			fail("Se espera una expecion de RightAddressException");

		} catch (NumberParException | UpAddressException | RightAddressException | LeftAddressException
				| DownAddressException | CompleteFieldException e) {
		
		}
	}
	
	@Test
	public void checkLeftAddressException() {
			
		try {
			setupEscenary12();
			fail("Se espera una expecion de LeftAddressException");

		} catch (NumberParException | UpAddressException | RightAddressException | LeftAddressException
				| DownAddressException | CompleteFieldException e) {
		
		}
	}
	
	
	@Test
	public void checkDownAddresException() {
		try {
			setupEscenary13();
			fail("Se espera una expecion de DownAddressException");

		} catch (NumberParException | UpAddressException | RightAddressException | LeftAddressException
				| DownAddressException | CompleteFieldException e) {
		
		}
	}
	
	
	
	
}
