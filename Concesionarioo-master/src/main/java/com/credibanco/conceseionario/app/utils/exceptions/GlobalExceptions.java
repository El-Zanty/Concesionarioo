package com.credibanco.conceseionario.app.utils.exceptions;

public class GlobalExceptions extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GlobalExceptions(String message) {
        super(message);
    }
//Update exception
    public static GlobalExceptions clientUpdateException(int id) {
        return new GlobalExceptions("Ocurrió un error al intentar actualizar al cliente con el ID: " + id);
    }

    public static GlobalExceptions saleUpdateException(int id) {
    	return new GlobalExceptions("Ocurrió un error al intentar actualizar al la venta con el ID:" + id);
    	 }
    
    public static GlobalExceptions employeeUpdateException(int id) {
    	return new GlobalExceptions("Ocurrió un error al intentar actualizar el empleado con el ID:" + id);
    	 }
    
    public static GlobalExceptions vehicleUpdateException(int id) {
    	return new GlobalExceptions("Ocurrió un error al intentar actualizar el vehiculo con el ID:" + id);
    	 }
    
    public static GlobalExceptions concessionareUpdateException(int id) {
    	return new GlobalExceptions("Ocurrió un error al intentar actualizar el concesionario con el ID:" + id);
    	 }
    
    // Not Found
    public static GlobalExceptions clientNotFoundException(int id) {
        return new GlobalExceptions("No se pudo encontrar al cliente con el ID: " + id);
    }
    
    public static GlobalExceptions vehicleNotFoundException(int id) {
    	return new GlobalExceptions("No se pudo encontrar al vehiculo con el ID: "+ id);
    }
    
    public static GlobalExceptions saleNotFoundException(int id) {
    	return new GlobalExceptions("No se pudo encontrar al la venta con el ID:" + id);
    	 }
    public static GlobalExceptions employeeNotFoundException(int id) {
    	return new GlobalExceptions("No se puedo encontrar al empleado con el ID:"+ id);
    }
    public static GlobalExceptions concessionareNotFoundException(int id) {
    	return new GlobalExceptions("No se puedo encontrar el concecionario con el ID:"+ id);
    }
}
