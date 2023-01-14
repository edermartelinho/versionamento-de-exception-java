package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	
	//Declara internamente na clase um sdf
	// Coloco o metodo static para nao  ser instanciado um novo sdf pra cada aplicaçao
	
	private static  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
		this.roomNumber = roomNumber;
		this.checkOut = checkIn;
		this.checkIn = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	//calculo da duraçao em dias
	//calculando as duas data em milisegundos com TimeUnit converte em dias
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//metodo para atualizara data
	//O metodo nao sera mais void e sim retornar um string
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		//tratamento da data para atualizaçao nao deve ser anteriores a data atual
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return " Reservation dates for update must be future dates";
		}
		
		// Verificar se a data de checkOut nao e posterior a data de checkIn
		
	    if ( !checkOut.after(checkIn)) {
			return "Check-Out data must be after check-In date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}

	//implementar o toString para escrever concatenado 
	// o @override pq o to string e uma sobreposiçao
	
	@Override
	public String toString() {
		return  "Room "
				+ roomNumber
				+ ", check-In: "
				+ sdf.format(checkIn)
				+ ", check-Out: "
				+  sdf.format(checkOut)
				+ " , "
				+ duration()
				+ " nights";
		
	}
	
	
	
	
}
 