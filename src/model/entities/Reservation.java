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
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
 