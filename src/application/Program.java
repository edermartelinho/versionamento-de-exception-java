package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		// solucao muito ruin da logica de validacao no programa principal
		
		Scanner sc = new Scanner(System.in);
		
		//formataçao da  data  na aplicaçao
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//logica de ler os quartos e cdastrar entrada e saida dos clientes
		
		
		// pede para o usuario entrar com o numero do quarto
		// cria uma variavel pra armazenar este numero
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		// pedir para entrar com a data de checkIn com a formataçao sdf
		// checkIn recebe sdf.parser(sc.next()) em formato de texto e conver em um date
		// gera um erro no parse entao lançamos uma auto correçao de tratamento
		// throws parseException (por que colocou dentro do metodo uma chamada que pode causar exeçao
		// se um outro metodo chamar esse Main trataria  tambem da mesma forma
		
		
		
		System.out.print("Check-In date (dd/MM/yyyy):  ");
		Date checkIn = sdf.parse(sc.next());
		
		//Da mesma forma do checkIn sera a do checkOut
		
		System.out.print("Check-out date (dd/MM/yyyy):  ");
		Date checkOut = sdf.parse(sc.next());
		
	
		
		//instanciando a reserva
		//A data de checkOut tem que ser posterior a do checkIn
		// Um if para testar se a data esta correta se nao mostrara a frase de erro
		// Mostra na tela o resultado da reserva
		
		if ( !checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-Out data must be after check-In date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			
		//Atualizaçao da data da reserva
			
			System.out.println();
			System.out.println("Enter date to update the reservation:");			
			System.out.print("Check-In date (dd/MM/yyyy):  ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):  ");	
			checkOut = sdf.parse(sc.next());
			
			//tratamento da data para atualizaçao nao deve ser anteriores a data atual
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: reservation dates for update must be future dates");
			}
			
			// Verificar se a data de checkOut nao e posterior a data de checkIn
			
			else if ( !checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-Out data must be after check-In date");
			}
			
			//Apos ler as novas datas atualiza
			
			else {
			     reservation.updateDates(checkIn, checkOut);
			     System.out.println("Reservation: " + reservation);
			}
			
		}
				 
        sc.close();
	}

}
