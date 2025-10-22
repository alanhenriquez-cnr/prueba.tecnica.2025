package cnr.pruebatecnica.responses;

import java.util.HashMap;
import java.util.Map;



//=================================================================================================
// RESPONSE APIs ----------------------------------------------------------------------------------
//=================================================================================================



/**
 * Clase estándar para las respuestas basicas de las APIs.
 * 
 * @author PRUEBA TECNICA
 * @version 1.0
 */
public class ResponseAPIs {
    

    
    //=============================================================================================
    // METHODS - BASIC ---------------------------------------------------------------------------
    //=============================================================================================



    /**
     * Clase estándar para las respuestas basicas de las APIs.
     * 
     * @author PRUEBA TECNICA
     * @version 1.0
     */
    public static class Basic<T> {
        private boolean success;
        private String message;
        private T data;



        public Basic() {
            this.success = false;
            this.message = "Error en la ejecución del metodo";
            this.data = null;
        }
        
        public Basic(T data) {
            this.success = true;
            this.message = "Operación exitosa";
            this.data = data;
        }
        
        public Basic(String message, T data) {
            this.success = true;
            this.message = message;
            this.data = data;
        }
        
        public Basic(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }
        


        public boolean isSuccess() {
            return success;
        }
        public void setSuccess(boolean success) {
            this.success = success;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
    }


    
    //=============================================================================================
    // METHODS - MASTER ---------------------------------------------------------------------------
    //=============================================================================================



    
    /**
     * Clase estándar para las respuestas basicas de metodos de las APIs.
     * 
     * @author PRUEBA TECNICA
     * @version 1.0
     */
    public static class Methods {
        private MethodsDTO data;
        


        public Methods() {
            this.data = new MethodsDTO();
        }
        public Methods(Methods data) {
            this.data = new MethodsDTO(data);
        }
        public Methods(MethodsDTO data) {
            this.data = data;
        }
        public Methods(boolean success) {
            this.data = new MethodsDTO();
            this.data.setSuccess(success);
        }
        public Methods(boolean success, String message) {
            this.data = new MethodsDTO(success, message);
        }
        public Methods(boolean success, String message, int code) {
            this.data = new MethodsDTO(success, message, code);
        }
        public Methods(boolean success, String message, int code, Map<String, Object> data) {
            this.data = new MethodsDTO(success, message, code, data);
        }



        //metodos getter y setter para el objeto MethodsDTO
        public MethodsDTO getData() { return data; }
        public void setData(MethodsDTO data) { this.data = data; }
        public void setData(boolean success, String message) { this.data = new MethodsDTO(success, message); }
        public void setData(boolean success, String message, int code) { this.data = new MethodsDTO(success, message, code); }
        public void setData(boolean success, String message, int code, Map<String, Object> data) { this.data = new MethodsDTO(success, message, code, data); }
        public void setData(Map<String, Object> data) { this.data.setData(data); }



        //metodos getter y setter para los fragmentos de datos
        public void addDataFragment(String key, Object value) { this.data.addDataFragment(key, value); } 
        public Object getDataFragment(String key) { return this.data.getDataFragment(key); }



        //metodos getter y setter para el estado de la respuesta
        public void setSuccess(boolean success) { this.data.setSuccess(success); }
        public boolean getSuccess() { return this.data.isSuccess(); }



        //metodos getter y setter para el mensaje de la respuesta
        public void setMessage(String message) { this.data.setMessage(message); }
        public String getMessage() { return this.data.getMessage(); }
        

        
        //metodos getter y setter para el codigo de la respuesta
        public void setCode(int code) { this.data.setCode(code); }
        public int getCode() { return this.data.getCode(); }
    }

    /**
     * Clase estándar para las respuestas basicas de metodos de las APIs.
     * 
     * @author PRUEBA TECNICA
     * @version 1.0
     */
    public static class MethodsDTO {
        private boolean success;
        private String message;
        private int code;
        private Map<String, Object> data;
        


        public MethodsDTO() {
            this.success = false;
            this.message = "Error en la ejecución del metodo";
            this.code = 0;
            this.data = new HashMap<String, Object>();
            this.data.put("message", "no configurado");
        }
        public MethodsDTO(Methods data) {
            this.success = data.getData().isSuccess();
            this.message = data.getData().getMessage();
            this.code = data.getData().getCode();
            this.data = data.getData().getData();
        }
        public MethodsDTO(MethodsDTO data) {
            this.success = data.isSuccess();
            this.message = data.getMessage();
            this.code = data.getCode();
            this.data = data.getData();
        }
        public MethodsDTO(boolean success) {
            this.success = success;
            this.message = "Error en la ejecución del metodo";
            this.code = 0;
            this.data = new HashMap<String, Object>();
            this.data.put("message", "no configurado");
        }
        public MethodsDTO(boolean success, String message) {
            this.success = success;
            this.message = message;
            this.code = 0;
            this.data = new HashMap<String, Object>();
            this.data.put("message", "no configurado");
        }
        public MethodsDTO(boolean success, String message, int code) {
            this.success = success;
            this.message = message;
            this.code = code;
            this.data = new HashMap<String, Object>();
            this.data.put("message", "no configurado");
        }
        public MethodsDTO(boolean success, String message, int code, Map<String, Object> data) {
            this.success = success;
            this.message = message;
            this.code = code;
            this.data = data;
        }
        


        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public int getCode() { return code; }
        public void setCode(int code) { this.code = code; }

        public Map<String, Object> getData() { return data; }
        public void setData(Map<String, Object> data) { this.data = data; }

        public void addDataFragment(String key, Object value) { this.data.put(key, value); }
        public Object getDataFragment(String key) { return this.data != null && this.data.containsKey(key) ? this.data.get(key) : null; }
    }




    //=============================================================================================
    // ERROR - EXCEPTION --------------------------------------------------------------------------
    //=============================================================================================



    /**
     * Excepción personalizada para errores de API.
     * 
     * @author PRUEBA TECNICA
     * @version 1.0
     */
    public static class Error extends RuntimeException {
        private final ErrorDTO data;
    
    
        public Error() {
            super(new ErrorDTO().getMessage());
            this.data = new ErrorDTO();
        }

        public Error(String message) {
            super(message);
            this.data = new ErrorDTO();
        }

        public Error(String message, Throwable cause) {
            super(message, cause);
            this.data = new ErrorDTO();
        }
    
        public Error(ErrorDTO data) {
            super(data.getMessage());
            this.data = data;
        }

        public Error(String message, Object... kvPairs) {
            super(message);
            this.data = ErrorDTO.of(message, kvPairs);
        }
    


        public ErrorDTO getData() {
            return data;
        }


    
        public static String cleanMessage(Exception error, String defaultMessage) {
            if (error.getMessage() != null && error.getMessage().contains("cnr.gob.sv.admusweb.responses.ResponseAPIs$Error: ")) {
                return error.getMessage().replace("cnr.gob.sv.admusweb.responses.ResponseAPIs$Error: ", "").trim();
            } else {
                return defaultMessage;
            }
        }
    }
    
        
    /**
     * Clase estándar para las respuestas basicas de errores de las APIs.
     * 
     * @author PRUEBA TECNICA
     * @version 1.0
     */
    public static class ErrorDTO {
        private String message;
        private int code;
        private Map<String, Object> data;



        public ErrorDTO() {
            this.message = "Error no especificado";
            this.code = 0;
            this.data = new HashMap<String, Object>();
            this.data.put("message", "Error no especificado");
        }

        public ErrorDTO(String message, int code, Map<String, Object> data) {
            this.message = message;
            this.code = code;
            this.data = data;
        }



        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public int getCode() { return code; }
        public void setCode(int code) { this.code = code; }

        public Map<String, Object> getData() { return data; }
        public void setData(Map<String, Object> data) { this.data = data; }


        
        public static ErrorDTO of(String message, int code, Object... kvPairs) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < kvPairs.length - 1; i += 2) {
                map.put(String.valueOf(kvPairs[i]), kvPairs[i + 1]);
            }
            return new ErrorDTO(message, code, map);
        }        

        public static ErrorDTO of(String message, Object... kvPairs) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < kvPairs.length - 1; i += 2) {
                map.put(String.valueOf(kvPairs[i]), kvPairs[i + 1]);
            }
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage(message);
            errorDTO.setData(map);
            return errorDTO;
        }     
        
        public static ErrorDTO of(String message, int code) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage(message);
            errorDTO.setCode(code);
            return errorDTO;
        }

        public static ErrorDTO of(String message) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage(message); 
            return errorDTO;
        }
    }



}
