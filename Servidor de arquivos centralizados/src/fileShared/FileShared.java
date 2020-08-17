package fileShared;

import java.io.Serializable;

public class FileShared implements Serializable{
    private byte bytes[];
    private String name;
    
    public FileShared(byte[] bytes, String name) {
        this.bytes = bytes;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte[] getBytes() {
        return bytes;
    }
    
    public Integer getSize(){
        if(bytes == null){
            return null;
        }
        return bytes.length;
    }
    
    public String msgUploadSucess() {
    	return "Arquivo " + name + " transferido para o servidor!";
    }
    
    public String msgDownloadSucess() {
    	return "Arquivo " + name + " salvo com sucesso!";
    }
}