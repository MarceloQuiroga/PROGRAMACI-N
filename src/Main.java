import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) throws IOException{
		
		//DECLARACIONES
		
		int size = 251;
		
		String [] E_Nombre = new String [size];
		int [] E_NumDesempleado = new int [size];
		String [] E_Provincia = new String [size];
		
		String [] J_Nombre = new String [size];
		int [] J_NumDesempleado = new int [size];
		String [] J_Provincia = new String [size];
		
		int i = 0;
		int User;
		String TextLine;
		String[] Data;
		
		File E_excel = new File ("Resource/datosParo2018/numParados2018Enero.csv");
		File J_excel = new File ("Resource/datosParo2018/numParados2018Julio.csv");
		
		Scanner excel01 = new Scanner (E_excel);
		Scanner excel02 = new Scanner (J_excel);
		Scanner sc		= new Scanner (System.in);
		
		//ASIGANACIONES
		
		while (excel01.hasNextLine()) {
			
			TextLine = excel01.nextLine();
			Data = TextLine.split(";");
			
			E_Nombre[i] 		= Data[0];
			E_NumDesempleado[i] = Integer.parseInt(Data[1].replace(".", ""));
			E_Provincia[i] 		= Data[2];
			
			i++;
			
		}
		
		excel01.close();
		
		i = 0;
		
		while (excel02.hasNextLine()) {
			
			TextLine = excel02.nextLine();
			Data = TextLine.split(";");
			
			J_Nombre[i] 		= Data[0];
			J_NumDesempleado[i] = Integer.parseInt(Data[1].replace(".", ""));
			J_Provincia[i] 		= Data[2];
			
			i++;
			
		}
		
		excel02.close();
		
		
		
		//CUERPO
		
		do {
			
			System.out.println("MENU \n"
					+ "1. Máximo de parados Enero \n"
					+ "2. Media de desempleados por provincia Julio. \n"
					+ "3. Máximo de parados por provincia Enero \n"
					+ "4. Total de parados por provincia en Enero \n"
					+ "5. La provincia que menos parados hay en Julio \n"
					+ "6. La diferencia de desempleados entre Julio y Enero en Amorebieta-Etxano \n"
					+ "7. Teniendo en cuenta datos de Enero y Julio, decir que provincia es el que tiene más\r\n"
					+ "desempleados \n"
					+ "8. Modify J_NumDesempleado \n"
					+ "9. Modificar provincia \n"
					+ "0. Exit");
			
			
			User = Integer.parseInt(sc.nextLine());
			
			switch (User) {
			
			case 1:
				Opc1(E_NumDesempleado);
				break;
			case 2:
				Opc2(J_NumDesempleado,J_Provincia);
				break;
			case 3:
				Opc3(E_NumDesempleado,E_Provincia);
				break;
			case 4:
				Opc4(E_NumDesempleado,E_Provincia);
				break;
			case 5:
				Opc5(J_NumDesempleado,J_Provincia);
				break;
			case 6:
				Opc6(E_Nombre,J_Nombre,E_NumDesempleado,J_NumDesempleado);
			case 7:
				Opc7(E_Provincia,J_Provincia,E_NumDesempleado,J_NumDesempleado);
				break;
			case 8:
				Opc8(E_NumDesempleado);
				break;
			case 9:
				Opc9(E_Provincia);
				break;
			case 10:
				Opc10(E_Nombre,J_Nombre,E_NumDesempleado,J_NumDesempleado,E_Provincia,J_Provincia);
				break;
			case 11:
				Opc11(E_Provincia);
				break;
			
			}
			
		} while (User!=0);
				
	}
		

	public static void Opc1 (int E_NumDesempleado[]) {
		
		int max = 0;
		for (int i=0; i < E_NumDesempleado.length; i++) {
			
			if (E_NumDesempleado[i] > max) {max=E_NumDesempleado[i];}
			
		}
		
		System.out.println(max);
		
	}
	public static void Opc2 (int J_NumDesempleado[], String J_Provincia[]) {
		
		int sum_G,sum_B,sum_A;
		int cont_G,cont_B,cont_A;
		
		sum_G = 0;
		cont_G = 0;
		
		sum_B = 0;
		cont_B = 0;
		
		sum_A = 0;
		cont_A = 0;
		
		for (int i=0; i < J_NumDesempleado.length; i++) {
			
			if (J_Provincia[i].equals("gipuzkoa")) {
				sum_G = sum_G + J_NumDesempleado[i];
				cont_G++;
			}
			
			if (J_Provincia[i].equals("bizkaia")) {
				sum_B = sum_B + J_NumDesempleado[i];
				cont_B++;
			}
			
			if (J_Provincia[i].equals("araba")) {
				sum_A = sum_A + J_NumDesempleado[i];
				cont_A++;
			}
			
		}
		
		System.out.println("La provincia Gipuzkoa tiene una media de " + sum_G/cont_G);
		System.out.println("La provincia Bizkaia tiene una media de " + sum_B/cont_B);
		System.out.println("La provincia Araba tiene una media de " + sum_A/cont_A);
		
	}
	public static void Opc3 (int E_NumDesempleado[], String E_Provincia[]) {
		
		int max_G,max_B,max_A;
		
		max_G = 0;
		max_B = 0;
		max_A = 0;
		
		for (int i=0; i < E_NumDesempleado.length; i++) {
			
			if (E_Provincia[i].equals("gipuzkoa")) {
				if (E_NumDesempleado[i] > max_G) {max_G=E_NumDesempleado[i];}
				}
			
			if (E_Provincia[i].equals("bizkaia")) {
				if (E_NumDesempleado[i] > max_B) {max_B=E_NumDesempleado[i];}
				}
			
			if (E_Provincia[i].equals("araba")) {
				if (E_NumDesempleado[i] > max_A) {max_A=E_NumDesempleado[i];}
				}
			}
		
		System.out.println("La provincia Gipuzkoa tiene una máximo de " + max_G);
		System.out.println("La provincia Bizkaia tiene una máximo de " + max_B);
		System.out.println("La provincia Araba tiene una máximo de " + max_A);
		
	}
	public static void Opc4 (int E_NumDesempleado[], String E_Provincia[]) {
		
		int sum_G,sum_B,sum_A;
		
		sum_G = 0;
		sum_B = 0;
		sum_A = 0;
		
		for (int i=0; i < E_NumDesempleado.length; i++) {
			
			if (E_Provincia[i].equals("gipuzkoa")) {
				sum_G = sum_G + E_NumDesempleado[i];
			}
			
			if (E_Provincia[i].equals("bizkaia")) {
				sum_B = sum_B + E_NumDesempleado[i];
			}
			
			if (E_Provincia[i].equals("araba")) {
				sum_A = sum_A + E_NumDesempleado[i];
			}
			
		}
		
		System.out.println("Gipuzkoa con " + sum_G + " desembleados");
		System.out.println("Alaba con " + sum_A + " desembleados");
		System.out.println("Bizkaia con " + sum_B + " desembleados");
		
		
	}
	public static void Opc5 (int J_NumDesempleado[], String J_Provincia[]) {
				
		int sum_G,sum_B,sum_A;
		
		sum_G = 0;
		sum_B = 0;
		sum_A = 0;
		
		for (int i=0; i < J_NumDesempleado.length; i++) {
			
			if (J_Provincia[i].equals("gipuzkoa")) {
				sum_G = sum_G + J_NumDesempleado[i];
			}
			
			if (J_Provincia[i].equals("bizkaia")) {
				sum_B = sum_B + J_NumDesempleado[i];
			}
			
			if (J_Provincia[i].equals("araba")) {
				sum_A = sum_A + J_NumDesempleado[i];
			}
			
		}
		
		if (sum_G < sum_B && sum_G < sum_A ) {System.out.println("Gipuzkoa con " + sum_G + " desembleados");}
		if (sum_A < sum_B && sum_A < sum_G) {System.out.println("Alaba con " + sum_A + " desembleados");}
		if (sum_B < sum_A && sum_B < sum_G) {System.out.println("Bizkaia con " + sum_B + " desembleados");}
		
		
	}
	public static void Opc6 (String E_Nombre[], String J_Nombre[], int E_NumDesempleado[], int J_NumDesempleado[]) {
		
		int tag_E,tag_J;
		
		tag_E = 0;
		tag_J = 0;
		
		
		for (int i=0; i<E_Nombre.length; i++) {
			
			if (E_Nombre[i].equals("Amorebieta-Etxano")) {
				tag_E = i;
			}
			if (J_Nombre[i].equals("Amorebieta-Etxano")) {
				tag_E = i;
			}
		}
		
		System.out.println("En el mes de Enero tiene un total de " + E_NumDesempleado[tag_E] + " desempleado.");
		System.out.println("En el mes de Julio tiene un total de " + E_NumDesempleado[tag_J] + " desempleado.");
		
	}
	public static void Opc7 (String E_Provincia[], String J_Provincia[], int E_NumDesempleado[], int J_NumDesempleado[]) {
		
		int sum_G,sum_B,sum_A;
		
		sum_G = 0;
		sum_B = 0;
		sum_A = 0;
		
		for (int i=0; i < J_NumDesempleado.length; i++) {
			
			if (E_Provincia[i].equals("gipuzkoa")) {
				sum_G = sum_G + J_NumDesempleado[i];
			}
			
			if (E_Provincia[i].equals("bizkaia")) {
				sum_B = sum_B + J_NumDesempleado[i];
			}
			
			if (E_Provincia[i].equals("araba")) {
				sum_A = sum_A + J_NumDesempleado[i];
			}
			
			if (J_Provincia[i].equals("gipuzkoa")) {
				sum_G = sum_G + J_NumDesempleado[i];
			}
			
			if (J_Provincia[i].equals("bizkaia")) {
				sum_B = sum_B + J_NumDesempleado[i];
			}
			
			if (J_Provincia[i].equals("araba")) {
				sum_A = sum_A + J_NumDesempleado[i];
			}
			
		}
		
		if (sum_G > sum_B && sum_G > sum_A ) {System.out.println("Gipuzkoa con " + sum_G + " desembleados");}
		if (sum_B > sum_A && sum_B > sum_G) {System.out.println("Alaba con " + sum_A + " desembleados");}
		if (sum_A > sum_B && sum_A > sum_G) {System.out.println("Bizkaia con " + sum_B + " desembleados");}
		
	}
	public static void Opc8 (int E_NumDesempleado[]) {
		
		for (int i=0;i<E_NumDesempleado.length;i++) {
			
			E_NumDesempleado[i] = E_NumDesempleado[i]+2;
			
		}
		
	}
	public static void Opc9 (String E_Provincia[]) {
		
		for (int i=0;i<E_Provincia.length;i++) {
			
			E_Provincia[i] = E_Provincia[i] + " (EAE)";
			
		}
		
	}
	public static void Opc10 (String E_Nombre[],String J_Nombre[],int E_NumDesempleado[],int J_NumDesempleado[],String E_Provincia[],String J_Provincia[]) throws IOException {
		
		File f = new File ("Resource/Prueba.txt");
		PrintWriter printWriter = new PrintWriter(f);
		
		for(int i=0;i<E_Nombre.length;i++) {
			printWriter.println(E_Nombre[i] + ";" + E_NumDesempleado[i] + ";" + E_Provincia[i]);
		}
		
		printWriter.close();
		
		
		/*
		int size = 251;
		String Line[] = new String [size];
		
		for(int i=0;i<E_Nombre.length;i++) {
			Line[i] = E_Nombre[i] + ";" + E_NumDesempleado[i] + ";" + E_Provincia[i];
		}
		
		FileWriter fichero = null;
		fichero = new FileWriter("Resource/Prueba.txt");
		for (String linea : Line) {
			try {
				fichero.write(linea);
				fichero.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		fichero.close();
		*/
		
	 
	}
	public static void Opc11 (String E_Provincia[]) {
		for(int i=0;i<E_Provincia.length;i++) {
			if (!E_Provincia[i].equals("araba")) {System.out.println(E_Provincia[i]);}
		}
	}
}

