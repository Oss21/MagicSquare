package controller;

import javax.swing.JOptionPane;

import exception.CompleteFieldException;
import exception.DownAddressException;
import exception.LeftAddressException;
import exception.NumberParException;
import exception.RightAddressException;
import exception.UpAddressException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Tablero;

public class ControllerBoard {

	private Tablero board;
	private Label[][] matriz;
    @FXML
    private TextField tfDimension;
    @FXML
    private TextField tfMagicCostan;
  
    @FXML
    private ChoiceBox<String> chInitialLocate;
    
    @FXML
    private ChoiceBox<String> chDireccion;


    @FXML
    private GridPane gridData;

    @FXML
    public void build(ActionEvent event) throws NumberParException {
    		try {
    			int dimension = Integer.parseInt(tfDimension.getText());
				board.setRow(dimension);
				board.setColumn(dimension);
				tfMagicCostan.setText(String.valueOf(board.magicCostan()));
				showBoard();
				
    		} catch (NumberFormatException e) {
    			JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
    			limpiarPantalla();
    		} catch (NegativeArraySizeException e) {
    			JOptionPane.showMessageDialog(null, "El valor numerico debe ser positivo", e.getClass().getName(),JOptionPane.ERROR_MESSAGE);
    			limpiarPantalla();
			} catch (CompleteFieldException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),e.getClass().getName(), JOptionPane.WARNING_MESSAGE);
    			tfMagicCostan.clear();
    			gridData.getChildren().clear();
    			
			}catch (NumberParException e) {
				limpiarPantalla();
				JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getName(), JOptionPane.OK_OPTION);
    		
    		}catch (UpAddressException | RightAddressException | LeftAddressException | DownAddressException e) {
    			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getName(),JOptionPane.ERROR_MESSAGE);
    			chDireccion.getSelectionModel().clearSelection();
    			tfMagicCostan.clear();
    			gridData.getChildren().clear();
    		}
				

    }
    	
    
    /**
     * <br> Pre:</br> La matriz ha sido inicializada.
     * Permite mostrar la matriz en la pantalla.
     * <br> Post:</br> la matriz esta declarada 
     * @throws NumberParException lanza una expeción si el valor numerico no es impar.
     * @throws UpAddressException lanza una excepción si la dirección de desplazamiento es diferente NE-NO.
     * @throws RightAddressException lanza una excepción si la dirección de desplazamiento es diferente NE-SE.
     * @throws LeftAddressException lanza una excepción si la dirección de desplazamiento es diferente NO-SO.
     * @throws DownAddressException lanza una excepción si la dirección de desplazamiento es diferente SE-SO.
	 * @throws CompleteFieldException lanza una excepción si los campos no estan completos
     */
    public void showBoard() throws NumberParException, UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
    	check();
    	//Establecer Indice de filas y columnas del GridPane.
				matriz = new Label[board.getRow()][board.getColumn()];
		
    	
    	// LLena la matriz de numeros;
    	//Main.getTablero().fillMatriz();
       	//Recorro la matriz de Label y agrego un label en cada posicion.
       	for (int i = 0; i < matriz.length; i++) {
       		for (int j = 0; j < matriz[i].length; j++) {
       			matriz[i][j] = new Label(Integer.toString(board.getMatriz()[i][j]));
       			gridData.setAlignment(Pos.CENTER);
       			gridData.setHgap(10);
       			gridData.setVgap(10);
       			gridData.setPadding(new Insets(10,10,10,10));
       			gridData.add(matriz[i][j], j, i);
       			
       			
       		}
    	}

    }
    
  
    /**
     * Permite controlar los datos establecido en los choiceBox
     */
    private void controllerChoiceBox()
    {
    	chInitialLocate.setItems(FXCollections.observableArrayList("Arriba", "Derecho", "Izquierdo", "Abajo"));
    	chDireccion.setItems(FXCollections.observableArrayList("Nororiente", "Noroeste", "Suroriente", "Suroeste"));
    	
    }
	/**
	 * Permite verificar la ubicacion inicial de la fila y la columna.
	 * Del mismo modo permite elegir la dirección de desplazamiento.
	 * @throws UpAddressException lanza una excepción si la dirección de desplazamiento es diferente NE-NO.
	 * @throws RightAddressException lanza una excepción si la dirección de desplazamiento es diferente NE-SE.
	 * @throws LeftAddressException lanza una excepción si la dirección de desplazamiento es diferente NO-S0.
	 * @throws DownAddressException lanza una excepción si la dirección de desplazamiento es diferente SE-SO.
	 * @throws CompleteFieldException lanza una excepción si los campos no estan completos
	 */
    private void check() throws UpAddressException, RightAddressException, LeftAddressException, DownAddressException, CompleteFieldException {
    	String initialLocate = chInitialLocate.getSelectionModel().getSelectedItem();
		String direccionDesplazamiento = chDireccion.getSelectionModel().getSelectedItem();
		if (initialLocate == null || direccionDesplazamiento == null) {
			board.locateStart(null, null);
		}else if (initialLocate.equals(Tablero.UP)) {
			if(direccionDesplazamiento.equals(Tablero.NO)) {
					board.locateStart(Tablero.UP, Tablero.NO);
			}else if (direccionDesplazamiento.equals(Tablero.NE)) {
				board.locateStart(Tablero.UP, Tablero.NE);
			}else {
				board.locateStart(Tablero.UP, "ERROR");
			}
		
		}else if(initialLocate.equals(Tablero.RIGHT)) {
			if(direccionDesplazamiento.equals(Tablero.NE)) {
				board.locateStart(Tablero.RIGHT, Tablero.NE);
			}else if (direccionDesplazamiento.equals(Tablero.SE)) {
				board.locateStart(Tablero.RIGHT, Tablero.SE);
			}else {
				board.locateStart(Tablero.RIGHT, "ERROR");
			}
		}else if(initialLocate.equals(Tablero.LEFT)) {
			if(direccionDesplazamiento.equals(Tablero.NO)) {
				board.locateStart(Tablero.LEFT, Tablero.NO);
			}else if (direccionDesplazamiento.equals(Tablero.SO)) {
				board.locateStart(Tablero.LEFT, Tablero.SO);
			}else {
				board.locateStart(Tablero.LEFT, "ERROR");
			}
		}else if(initialLocate.equals(Tablero.DOWN)) {
			if(direccionDesplazamiento.equals(Tablero.SO) ){
				board.locateStart(Tablero.DOWN, Tablero.SO);
			}else if (direccionDesplazamiento.equals(Tablero.SE)) {
				board.locateStart(Tablero.DOWN, Tablero.SE);
			}else {
				board.locateStart(Tablero.DOWN, "ERROR");
			}
		}
		
		

	
    }
    //Limpia los datos en la ventana.
    @FXML
    public void clear(ActionEvent event) {
    	limpiarPantalla();
    }
    
    /**
     * #nuevo
     * Permite limpiar los valores que estan en pantalla
     */
    private void limpiarPantalla() {
    	tfDimension.clear();
    	tfMagicCostan.clear();
    	gridData.getChildren().clear();
    	chInitialLocate.getSelectionModel().clearSelection();
    	chDireccion.getSelectionModel().clearSelection();
    }
    
    	
        @FXML
    public void initialize() {
    	board = new Tablero();
    	board.inicializar();
    	controllerChoiceBox();
    }


}
