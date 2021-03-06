package tr.edu.medipol.ilerijava.vize.musademirci.ortak;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketYaziciThread4 extends SocketThreadUstSinif3 {

	private static final Logger LOGGER = Logger.getLogger(SocketYaziciThread4.class.getName());

	private PrintWriter socketMesajGonderici;

	private EkranUstSinif2 ekran;

	public SocketYaziciThread4(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}

	public SocketYaziciThread4(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketYaziciThread4(Socket socketBaglantisi, boolean sunucu, EkranUstSinif2 ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.ekran = ekran;
	}

	public void init(Socket socketBaglantisi) {
		socketMesajGonderici = SocketYardimciAraclari3.socketYaziciOlustur(socketBaglantisi);
		LOGGER.info("Yazici Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {
		LOGGER.info("Yazici Thread calisiyor" + socketIsmi);

		// rastgeleMesajGonder();

		while (true) {
			String siradakiMesaj = ekran.getMesajKuyrugu().poll();
			if (siradakiMesaj != null) {
				socketeMesajGonder(siradakiMesaj);
			} else {
				SocketYardimciAraclari3.threadBekle(1000);
			}
		}

	}

	public void rastgeleMesajGonder() {
		int beklemeSuresi = 5000;// 5000 ms = 5 sn bekle
		int i = 1;
		do {
			String mesaj = socketIsmi + ">Mesaj " + i;
			socketeMesajGonder(mesaj);
			SocketYardimciAraclari3.threadBekle(beklemeSuresi);
			i++;
		} while (true);
	}

	public void socketeMesajGonder(String mesaj) {
		if (mesaj != null) {
			System.out.println(mesaj + " gonderiliyor.");
			socketMesajGonderici.println(mesaj);
			socketMesajGonderici.flush();
		}
	}
}