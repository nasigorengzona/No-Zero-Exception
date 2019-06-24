import java.util.Scanner;
import java.util.InputMismatchException;


//handmade Exception
class InputAngkaException extends Exception {
	public InputAngkaException() { //struct 
		super("\nAngka yang diinput tidak valid\n");
	}
}

//handmade Exception
class ZeroException extends Exception {
	public ZeroException () {
		super("\nAngka tidak boleh Nol\n");
	}
}


// kelas 
public class TestException {
	//validation buat int 
	public static int inputInt(Scanner input, String label) throws InputAngkaException {
		System.out.print(label);
		try {
			return input.nextInt();
		} catch (InputMismatchException e) {
			throw new InputAngkaException();
		}
	}
	
	//validation untuk penyebut
	public static int inputIntPenyebut (Scanner input, String label) throws ZeroException, InputAngkaException   {
		System.out.print(label);
		try {
			int a = input.nextInt();
			if (a == 0) throw new ZeroException();
			else return a;		
		} catch (InputMismatchException e) {
			throw new InputAngkaException();
		}
	}
	
	public static int inputIntUntilValid(Scanner input, String label) {
		int n = 0;
		do {
			try {
				n = inputInt(input, label);
				break;
			} catch (InputAngkaException e) {
				input.nextLine();
				System.err.print("Input angka integer\n");
			}
		} while(true);
		return n;
	}
	
	//
	public static int inputPenyebutUntilValid(Scanner input, String label) {
		int n = 0;
		do {
			try {
				n = inputIntPenyebut(input, label);
				break;
			} catch ( ZeroException e) {
				input.nextLine();
				System.err.print("Penyebut tidak boleh 0\n");
			} catch (InputAngkaException e) {
				input.nextLine();
				System.err.print("Input angka integer\n");
			}
		} while(true);
		return n;
	}	
	
	

	public static void main(String []args) {
		Scanner input = new Scanner(System.in);

		try {
			int n = inputIntUntilValid(input, "Input angka(n): ");
			int m = inputPenyebutUntilValid(input, "Input angka(m): ");
			System.out.printf("%d/%d = %d\n", n, m, n/m);
		} catch (ArithmeticException e) {
			System.err.println("Kesalahan dalam perhitungan aritmatika");
			//System.exit(-1);
		} catch (Exception e) {
			System.err.println("General failure");
		} finally {
			System.out.println("Program berakhir");
		}
	}
}