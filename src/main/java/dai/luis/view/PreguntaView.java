package dai.luis.view;

public class PreguntaView {
	private String pregunta;
    private String respuesta;
 
    public String getPregunta() {
        return pregunta;
    }
 
    public String getRespuesta() {
        return respuesta;
    }
 
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
        this.respuesta = "Tu pregunta fue:  "+pregunta+" ?";
    }
 
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
