package tr.edu.medipol.ogrenciler.cihangunacti.odev5;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/*
 10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 5/5
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 0/5 , test: 5/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 5/5 , test: 5/5
[ ] - Set<Ogrenci> ogrenciSet() -> kod= 5/5 , test: 5/5
[ ] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 5/5 , test: 5/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 5/5 , test: 5/5
[ ] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 5/5 , test: 5/5

Yorum:
- TODO'lari silsen iyiydi.
- Erisim hatasi: -1

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 3/5
- Test kod mantigi: 0/5

SONUC: 97/115
 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerOgrenci sinifini extends eden sinifiniz ile new'leyiniz.
		
		
		
		islemlerOgrenci = new Odev5Islemler();
        
		
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("1","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("1");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("2");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("32");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
		
		Ogrenci ogrenci1=new OgrenciYuksekLisans("2","Ogrenci 2");
		boolean eklemeBasarili2=islemlerOgrenci.ogrenciEkle(ogrenci1);		
		Ogrenci ogrenci2=new OgrenciLisans("3","Ogrenci 3");
		boolean eklemeBasarili3=islemlerOgrenci.ogrenciEkle(ogrenci2);
		Ogrenci ogrenci3=new OgrenciLisans("4", "Cihan");
		boolean eklemeBasarili4=islemlerOgrenci.ogrenciEkle(ogrenci3);
		Ogrenci ogrenci4=new OgrenciLisans("5", "�brahim");
		boolean eklemeBasarili5=islemlerOgrenci.ogrenciEkle(ogrenci4);
		Ogrenci ogrenci5=new OgrenciLisans("6","Do�an");
		boolean eklemeBasarili6=islemlerOgrenci.ogrenciEkle(ogrenci5);
		
		
		
		// YAPILACAKLAR - 2 **************************************************
		// islemlerOgrenci sinifinin diger metodlarini da ayni sekilde test edin
		// .......................

		System.out.println("\n");
		System.out.println("-----Ogrenci List-----");
		for (Ogrenci ogr : islemlerOgrenci.ogrenciList()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		System.out.println("");
		
		System.out.println("-----S�ral� List-----");
		for(int i=0;i<islemlerOgrenci.ogrenciSiraliList().size();i++){
			// HATALI: Ogrenci o= islemlerOgrenci.tumOgrenciler.get(i);
		    /* OZKANS */ Ogrenci o= islemlerOgrenci.ogrenciSiraliList().get(i);
			System.out.println(""+o.getNo()+o.getAdSoyad()+o.ogrenciTipi());
		}
		System.out.println("");
		System.out.println("-----Linked List-----");
		for (Ogrenci ogr : islemlerOgrenci.ogrenciLinkedList()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		System.out.println("");		
		System.out.println("-----OgrenciSet-----");
		for(Ogrenci ogr:islemlerOgrenci.ogrenciSet()){
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		System.out.println("");
		System.out.println("-----Sorted Set-----");
		for (Ogrenci ogr: islemlerOgrenci.ogrenciSortedSet()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		System.out.println("");
		System.out.println("-----Ogrenci Map-----");
		Map<String, Ogrenci> ogrmap=islemlerOgrenci.ogrenciMap();
		ogrmap.forEach( (k, v) -> System.out.printf("%s %s %s\n", v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		System.out.println("");
		System.out.println("-----Sorted Map-----");
		SortedMap<String, Ogrenci> sortedMap=islemlerOgrenci.ogrenciSortedMap();
		sortedMap.forEach((k, v) -> System.out.printf("%s  %s  %s\n", v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		 
	}

}