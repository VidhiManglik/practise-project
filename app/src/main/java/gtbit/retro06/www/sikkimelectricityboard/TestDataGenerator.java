package gtbit.retro06.www.sikkimelectricityboard;

import java.util.Random;

public class TestDataGenerator {
	public static Object getRandomObjectFromArray(Object[] Array){
		int length = Array.length -1;
		Random r = new Random();
		return Array[r.nextInt((length - 0) + 1)];
	}
	public static String passwordGenerator(){
		System.out.println("anijscvn");
		String az = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567889";
		String AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "01234567889";
		Random r = new Random();
		int length = r.nextInt((10) + 5);
		String password = "";
		for(int j=0; j<length; j++){
			password += az.charAt(r.nextInt(62));
		}
		return password;
	}
	public static void main(String[] args) {
		String[] NAMES = {"Vinay","Prakash","Balu","Ganesh","Teju","Tejasvine","Ram","Raheem","Ramesh","Sita","Lily","Sanchit","Sachin","Tanmay","Vidhi","Sushant","Jaspreet","Jitender","Taranjot","Shalu"};
		String[] EMAILS = {"vinay@gmail.com","prakash@yahoo.com","balu@hotmail.com","ganesh@gmail.com","teju@yahoo.com","tajas@outlook.com","ram@gmail.com","raheem@yahoo.com","ramesh@gmail.com","sita@outlook.com","lily@gmail.com","sanchitgarg2@gmail.com","sach@gmail.com","tanmay.s97@gmail.com","manglik.vidhi@gmail.com","goyalsushant3@gmail.com","jaspreetnarang83@gmail.com","jitendermittal8697@gmail.com","taranzz25@gmail.com","shal@yahoo.com"};
		String[] PHONE_NUMBERS = {"9121646529","9343646529","9848546452","9493524178","9988776655","8899775566","8811546678","7665545346","9987654321","8897654321","7765432189","9878654321","8765432987","9876598765","8765945789","9867565435","8967543565","7655543387","7685764634","8979675456"};
		for(int i=0;i<110;i++){
			System.out.println("jdcvbshbaj");
			System.out.println("{\"name\":\""+ TestDataGenerator.getRandomObjectFromArray(NAMES) + "\",\"emailID\":\""+TestDataGenerator.getRandomObjectFromArray(EMAILS)+"\",\"phoneNumber\":\""+TestDataGenerator.getRandomObjectFromArray(PHONE_NUMBERS)+"\" , \"password\":\""+TestDataGenerator.passwordGenerator()+"\"}");
			
		}
	}

}
