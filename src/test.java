public class test {
    public static void main(String[] args) {
        String[] nameArray = {"hIEU1","hIEU123","HIEU van hieu","VAYNE12","MODER3"};
        for (String name: nameArray
             ) {
            if (isvalid(name) == true){
                System.out.println(name + " valid");
            }else {
                System.out.println(name + " invalid");
            }
        }
    }
    private static boolean isvalid(String name){
        return name.matches("^[a-zA-Z]+[\\-'\\s]*[a-zA-Z ]+$");
    }
   
    
}
