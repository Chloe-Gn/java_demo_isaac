package eni.demo.demo.module4.bll;


public class EniManagerResponse<T> {
    // Classe créée pour pallier un manque technique.
   public String code;
   public String message;
   public T data;


   public static <T> EniManagerResponse performResponse(String code, String message, T data){

       // Cas 1 : Succès
       EniManagerResponse<T> response = new EniManagerResponse<T>();
       response.code = code;
       response.message = message;
       response.data = data;

// Afficher la réponse métier dans la console/log (avant de return réponse)
       System.out.println(String.format("Response Metier - Code : %s - Message : %s", response.code, response.message));

        return response;
   }

}
