enum Choice{
    DECRYPTION,
    ENCRYPTION,
    EXIT
}
public class UserInterface {
    FilesHandler filesHandler=new FilesHandler();
    public String pathForOutputFile(String file_path,Choice choice){
        String newPath=file_path;
        if(choice.equals(Choice.ENCRYPTION)){
            newPath=newPath+".encrypted";
        }
        else{
            newPath=
        }
        return newPath;
    }
    public Choice getChoice(){}
    public String getFilePath(){}
    public byte getOrGenKey(int flag){}
    public void start(){
        String file_path="";
        Choice choice=getChoice();
        if(choice!=Choice.EXIT) {
            file_path = getFilePath();
        }
        if(!file_path.equals("EXIT")){
            int flag= choice.equals(Choice.ENCRYPTION) ? 1 : -1;
            byte key= getOrGenKey(flag);// only user
            byte[] fileContent=filesHandler.readFile(file_path);//logic
            byte[] data=CaesarAlgorithm.CaesarAlgo(fileContent,flag);
            String pathOfNewFile=pathForOutputFile(file_path,choice);
            filesHandler.writeToFile(pathOfNewFile,data);

        }
    }


    }

