package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.GroupException;

public class Program {

	public static void main(String[] args){
				
		Scanner sc = new Scanner(System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//trecho do codigo a ser tradao colocado dentro de um bloco try
			
		try {
			// Leitura dos dados
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-In date (dd/MM/yyyy):  ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):  ");
			Date checkOut = sdf.parse(sc.next());
			
			//Instanciando a reserva e mostra na tela
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			//Ler os dados da atualizaçao de reserva
			
			System.out.println();
			System.out.println("Enter date to update the reservation:");			
			System.out.print("Check-In date (dd/MM/yyyy):  ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):  ");	
			checkOut = sdf.parse(sc.next());
			
			//Imprimir os dados atualizados da reserva
			
		    reservation.updateDates(checkIn, checkOut);
		    System.out.println("Reservation: " + reservation);
		 }
		
		   // Bloco catch para tratar possiveis exception que possa acontecer no programa
		
        catch (ParseException e) {
        	System.out.println("Invalid date format");
        }
		catch (GroupException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		//Agora qualquer outra exception inesperad  mostra uma mensagem do erro
		
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
        sc.close();
	}

}
